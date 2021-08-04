package com.ruoyi.project.system.recordCopy.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.item.domain.TestItem;
import com.ruoyi.project.system.item.mapper.TestItemMapper;
import com.ruoyi.project.system.recordCopy.domain.TestRecordClassCopy;
import com.ruoyi.project.system.recordCopy.domain.TestRecordCopy;
import com.ruoyi.project.system.recordCopy.domain.TestRecordItem;
import com.ruoyi.project.system.recordCopy.domain.TestRecordTeacher;
import com.ruoyi.project.system.recordCopy.mapper.TestRecordClassCopyMapper;
import com.ruoyi.project.system.recordCopy.mapper.TestRecordCopyMapper;
import com.ruoyi.project.system.recordCopy.mapper.TestRecordItemMapper;
import com.ruoyi.project.system.recordCopy.mapper.TestRecordTeacherMapper;
import com.ruoyi.project.system.recordCopy.service.ITestRecordCopyService;
import com.ruoyi.project.system.teacher.domain.PrsnTeacher;
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
public class TestRecordCopyServiceImpl implements ITestRecordCopyService
{
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private TestRecordCopyMapper testRecordCopyMapper;
    @Autowired
    private TestRecordItemMapper testRecordItemMapper;
    @Autowired
    private TestItemMapper testItemMapper;
    @Autowired
    private PrsnTeacherMapper prsnTeacherMapper;
    @Autowired
    private TestRecordTeacherMapper testRecordTeacherMapper;
    @Autowired
    private TestRecordClassCopyMapper testRecordClassCopyMapper;

    /**
     * 查询测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordId 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）ID
     * @return 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @Override
    public TestRecordCopy selectTestRecordCopyById(Long testRecordId)
    {
        return testRecordCopyMapper.selectTestRecordCopyById(testRecordId);
    }

    /**
     * 查询测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）列表
     * 
     * @param testRecordCopy 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @Override
    public List<TestRecordCopy> selectTestRecordCopyList(TestRecordCopy testRecordCopy)
    {
        return testRecordCopyMapper.selectTestRecordCopyList(testRecordCopy);
    }



    /**
     * 新增测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordCopy 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 结果
     */
    @Override
    public int insertTestRecordCopy(TestRecordCopy testRecordCopy)
    {
        Long[] t1=testRecordCopy.getTestSiteIds();
        Long tempID=testRecordCopy.getTestRecordId();
        for(int i=0;i<t1.length;++i) {
            testRecordCopy.setTestRecordId(tempID);
            testRecordCopy.setTestSiteId(t1[i]);
            testRecordCopyMapper.insertTestRecordCopy(testRecordCopy);
        }
//        testRecordCopyMapper.insertTestRecordCopy(testRecordCopy);
        Long [] ids=testRecordCopy.getTestItemIds();
        Long [] idsCopy=testRecordCopy.getPrsnTeacherIds();

        String s=testRecordCopy.getStr1();
        System.out.println(s);

        TestRecordItem item=new TestRecordItem();
        TestRecordTeacher itemCopy=new TestRecordTeacher();
        TestRecordClassCopy trc=new TestRecordClassCopy();

        for(int i=0;i<ids.length;++i){
            item.setTestRecordId(testRecordCopy.getTestRecordId());
            item.setTestItem(ids[i]);
            testRecordItemMapper.insertTestRecordItem(item);
//            System.out.println(ids[i]);
        }

        for(int j=0;j<idsCopy.length;++j){
            itemCopy.setTestRecordId(testRecordCopy.getTestRecordId());
            itemCopy.setPrsnTeacherId(idsCopy[j]);
            testRecordTeacherMapper.insertTestRecordTeacher(itemCopy);
            System.out.println(idsCopy[j]);
        }
//
//        Long t2=testRecordCopy.getTestRecordId();
//        TestRecordStu trs=new TestRecordStu();
//        trs.setTestRecordId(t2);
//        testRecordStuMapper.insertTestRecordStu(trs);
//
//        for(int i=0;i<ids.length;++i){
//            trss.setTestRecordId(testRecord.getTestRecordId());
//            trss.setTestItemId(ids[i]);
//            testRecordStuMapper.insertTestRecordStu(trss);
//        }

        String[] m=s.split(",");
        Long[] strNum=(Long[]) ConvertUtils.convert(m,Long.class);
        int i=1,flag;
        while(i<strNum.length){
            if(strNum[i]>2000){
                Long tId=testRecordCopy.getTestRecordId();
                trc.setTestRecordId(tId);
                trc.setEnrollYear(strNum[i]);
                trc.setClassNo(strNum[i+1]);
                testRecordClassCopyMapper.insertTestRecordClassCopy(trc);
                flag=i+2;
                while(strNum[flag]<500){
                    trc.setTestRecordId(tId);
                    trc.setEnrollYear(strNum[i]);
                    trc.setClassNo(strNum[flag]);
                    testRecordClassCopyMapper.insertTestRecordClassCopy(trc);
                    flag++;
                }
                i=flag;
            }
        }

        return 1;
    }

    /**
     * 修改测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordCopy 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 结果
     */
    @Override
    public int updateTestRecordCopy(TestRecordCopy testRecordCopy)
    {
        return testRecordCopyMapper.updateTestRecordCopy(testRecordCopy);
    }

    /**
     * 删除测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestRecordCopyByIds(String ids)
    {
        return testRecordCopyMapper.deleteTestRecordCopyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）信息
     * 
     * @param testRecordId 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）ID
     * @return 结果
     */
    @Override
    public int deleteTestRecordCopyById(Long testRecordId)
    {
        testRecordItemMapper.deleteTestRecordItemByTestRecordId(testRecordId);
        testRecordTeacherMapper.deleteTestRecordTeacherByTestRecordId(testRecordId);
        return testRecordCopyMapper.deleteTestRecordCopyById(testRecordId);
    }

    /*
    新增体测记录
     */
    public int inserttestRecord(TestRecordCopy testRecordCopy)
    {
//        inserttestRecordItem(testRecordCopy);
        return testRecordCopyMapper.insertTestRecordCopy(testRecordCopy);
    }



    /*
    新增体测记录项目信息
     */
//    public int inserttestRecordItem(TestRecordCopy testrc)
//    {
//        int rows = 1;
//        List<TestRecordItem> list = new ArrayList<TestRecordItem>();
//        for (Long testItemId : testrc.getTestItem())
//        {
//            TestRecordItem tri = new TestRecordItem();
//            tri.setTestRecordId(testrc.getTestRecordId());
//            tri.setTestItem(testItemId);
//            list.add(tri);
//        }
//        if (list.size() > 0)
//        {
//            rows = testRecordItemMapper.batchTestRecordItem(list);
//        }
//        return rows;
//    }
//    public void insertUserPost(TestRecordCopy trc)
//    {
//        long[] items = trc.getTestItem();
//        if (StringUtils.isNotNull(items))
//        {
//            // 新增用户与岗位管理
//            List<TestRecordItem> list = new ArrayList<TestRecordItem>();
//            for (Long itemId : trc.getTestItem())
//            {
//                TestRecordItem up = new TestRecordItem();
//                up.setTestRecordId(trc.getTestRecordId());
//                up.setTestItem(itemId);
//                list.add(up);
//            }
//            if (list.size() > 0)
//            {
//                testRecordItemMapper.batchTestRecordItem(list);
//            }
//        }
//    }




    /*
    查询体测记录所属体测项目组
     */

    @Override
    public String selectTestRecordItemGroup(Long testRecordId)
    {
        List<TestItem> list = testItemMapper.selectTestItemByTestRecordId(testRecordId);
        StringBuffer idsStr = new StringBuffer();
        for (TestItem testItem : list)
        {
            idsStr.append(testItem.getTestItemName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString()))
        {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }

    /*
    查询体测记录所属的教师组
     */

    @Override
    public String selectTestRecordTeacherGroup(Long testRecordId)
    {
        List<PrsnTeacher> list = prsnTeacherMapper.selectPrsnTeacherByTestRecordId(testRecordId);
        StringBuffer idsStr = new StringBuffer();
        for (PrsnTeacher prsnTeacher : list)
        {
            idsStr.append(prsnTeacher.getTeacherName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString()))
        {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }


}
