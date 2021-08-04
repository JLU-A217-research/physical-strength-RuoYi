package com.ruoyi.project.system.record.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.CAG.mapper.CAGMapper;
import com.ruoyi.project.system.item.mapper.TestItemMapper;
import com.ruoyi.project.system.record.domain.*;
import com.ruoyi.project.system.record.mapper.*;
import com.ruoyi.project.system.record.service.ITestRecordService;
import com.ruoyi.project.system.recordstu.mapper.RecordStuMapper;
import com.ruoyi.project.system.stu.mapper.TestStuMapper;
import com.ruoyi.project.system.teacher.mapper.PrsnTeacherMapper;
import com.ruoyi.project.system.user.service.UserServiceImpl;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Service
public class TestRecordServiceImpl implements ITestRecordService 
{
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private TestRecordMapper testRecordMapper;
    @Autowired
    private TestItemMapper testItemMapper;
    @Autowired
    private TestRecordItemCopyMapper testRecordItemCopyMapper;
    @Autowired
    private PrsnTeacherMapper prsnTeacherMapper;
    @Autowired
    private TestRecordTeacherCopyMapper testRecordTeacherCopyMapper;
    @Autowired
    private TestRecordStuMapper testRecordStuMapper;
    @Autowired
    private TestStuMapper testStuMapper;
    @Autowired
    private TestRecordClassMapper testRecordClassMapper;
    @Autowired
    private CAGMapper cagMapper;
    @Autowired
    private RecordStuRelationMapper recordStuRelationMapper;
    @Autowired
    private RecordStuMapper recordStuMapper;

    /**
     * 查询测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordId 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）ID
     * @return 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
//    @Override
//    public TestRecord selectTestRecordById(Long testRecordId)
//    {
//        return testRecordMapper.selectTestRecordById(testRecordId);
//    }

    @Override
    public TestRecord selectTestRecordById(Long testRecordId)
    {
        return testRecordMapper.selectTestRecordById(testRecordId);
    }

    /**
     * 查询测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）列表
     * 
     * @param testRecord 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @Override
    public List<TestRecord> selectTestRecordList(TestRecord testRecord)
    {
        return testRecordMapper.selectTestRecordList(testRecord);
    }



    /**
     * 新增测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecord 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 结果
     */
    @Override
    public int insertTestRecord(TestRecord testRecord)
    {
        Long[] t1=testRecord.getTestSiteIds();
        for(int i=0;i<t1.length;++i) {
            testRecord.setTestSiteId(t1[i]);
        }
        testRecordMapper.insertTestRecord(testRecord);
        Long [] ids=testRecord.getTestItemIds();
        Long [] idsCopy=testRecord.getPrsnTeacherIds();

        String s=testRecord.getStr1();
        System.out.println(s);
        TestRecordTeacherCopy itemCopy=new TestRecordTeacherCopy();
        TestRecordItemCopy item=new TestRecordItemCopy();
        TestRecordStu trss=new TestRecordStu();
//        RecordStuRelation rsr=new RecordStuRelation();
        TestRecordClass trc=new TestRecordClass();


        for(int i=0;i<ids.length;++i){
            item.setTestRecordId(testRecord.getTestRecordId());
            item.setTestItem(ids[i]);
            testRecordItemCopyMapper.insertTestRecordItem(item);
        }
        for(int j=0;j<idsCopy.length;++j){
            itemCopy.setTestRecordId(testRecord.getTestRecordId());
            itemCopy.setPrsnTeacherId(idsCopy[j]);
            testRecordTeacherCopyMapper.insertTestRecordTeacher(itemCopy);
            System.out.println(idsCopy[j]);
        }
        //往test_stu表里插数据
        Long t2=testRecord.getTestRecordId();
        TestRecordStu trs=new TestRecordStu();
        trs.setTestRecordId(t2);
        testRecordStuMapper.insertTestRecordStu(trs);

        for(int i=0;i<ids.length;++i){
            trss.setTestRecordId(testRecord.getTestRecordId());
            trss.setTestItemId(ids[i]);
            testRecordStuMapper.insertTestRecordStu(trss);
        }


      String[] m=s.split(",");
      Long[] strNum=(Long[]) ConvertUtils.convert(m,Long.class);
      int i=1,flag;
      while(i<strNum.length){
            if(strNum[i]>2000){
                Long tId=testRecord.getTestRecordId();
                trc.setTestRecordId(tId);
                trc.setEnrollYear(strNum[i]);
                trc.setClassNo(strNum[i+1]);
                testRecordClassMapper.insertTestRecordClass(trc);
                flag=i+2;
                while(strNum[flag]<500){
                    trc.setTestRecordId(tId);
                    trc.setEnrollYear(strNum[i]);
                    trc.setClassNo(strNum[flag]);
                    testRecordClassMapper.insertTestRecordClass(trc);
                    flag++;
                }
                i=flag;
            }
        }
        testRecordStuMapper.updateTestRecordStu(trss);


        return 1;
    }

    /**
     * 修改测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecord 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 结果
     */
    @Override
    public int updateTestRecord(TestRecord testRecord)
    {
        return testRecordMapper.updateTestRecord(testRecord);
    }

    /**
     * 删除测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestRecordByIds(String ids)
    {
        return testRecordMapper.deleteTestRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）信息
     * 
     * @param testRecordId 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）ID
     * @return 结果
     */
    @Override
    public int deleteTestRecordById(Long testRecordId)
    {
        return testRecordMapper.deleteTestRecordById(testRecordId);
    }
}
