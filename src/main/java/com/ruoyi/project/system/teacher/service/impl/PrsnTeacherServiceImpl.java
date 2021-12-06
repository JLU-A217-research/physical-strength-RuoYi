package com.ruoyi.project.system.teacher.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.recordCopy.mapper.TestRecordTeacherMapper;
import com.ruoyi.project.system.teacher.domain.PrsnTeacher;
import com.ruoyi.project.system.teacher.domain.TeaInfo;
import com.ruoyi.project.system.teacher.mapper.PrsnTeacherMapper;
import com.ruoyi.project.system.teacher.service.IPrsnTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ruoyi.project.system.dict.utils.DictUtils.getDictLabel;

/**
 * 教师信息 Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
@Service
public class PrsnTeacherServiceImpl implements IPrsnTeacherService
{
    @Autowired
    private PrsnTeacherMapper prsnTeacherMapper;
    @Autowired
    private TestRecordTeacherMapper testRecordTeacherMapper;

    /**
     * 查询教师信息 
     * 
     * @param teacherId 教师信息 ID
     * @return 教师信息 
     */
    @Override
    public PrsnTeacher selectPrsnTeacherById(Long teacherId)
    {
        return prsnTeacherMapper.selectPrsnTeacherById(teacherId);
    }

    /**
     * 查询教师信息 列表
     * 
     * @param prsnTeacher 教师信息 
     * @return 教师信息 
     */
    @Override
    public List<PrsnTeacher> selectPrsnTeacherList(PrsnTeacher prsnTeacher)
    {

        return prsnTeacherMapper.selectPrsnTeacherList(prsnTeacher);
    }
    /*
    查询所有教师 列表
     */
    @Override
    public List<PrsnTeacher> selectPrsnTeacherAll(){
        return prsnTeacherMapper.selectPrsnTeacherAll(); }
    /*
    根据测试记录查询教师列表
     */
    @Override
    public List<PrsnTeacher> selectPrsnTeacherByTestRecordId(Long testRecordId)
    {
        List<PrsnTeacher> testRecordTeachers = prsnTeacherMapper.selectPrsnTeacherByTestRecordId(testRecordId);
        List<PrsnTeacher> teachers = prsnTeacherMapper.selectPrsnTeacherAll();
        for (PrsnTeacher prsnTeacher : teachers)
        {
            for (PrsnTeacher testRecordTeacher : testRecordTeachers)
            {
                if (prsnTeacher.getPrsnTeacherId().longValue() == testRecordTeacher.getPrsnTeacherId().longValue())
                {
                    prsnTeacher.setFlag(true);
                    break;
                }
            }
        }
        return teachers;
    }



    /**
     * 新增教师信息 
     * 
     * @param prsnTeacher 教师信息 
     * @return 结果
     */
    @Override
    public int insertPrsnTeacher(PrsnTeacher prsnTeacher)
    {
//        String s=prsnTeacher.getStr1();
//        String[] m=s.split(",");
//        Long[] strNum=(Long[]) ConvertUtils.convert(m,Long.class);
//        int i=1,flag;
//        if(strNum.length==3){
//            Long tId=prsnTeacher.getTestRecordId();
//            trc.setTestRecordId(tId);
//            trc.setEnrollYear(strNum[1]);
//            trc.setClassNo(strNum[2]);
//            testRecordClassMapper.insertTestRecordClass(trc);
//        }
//        else{
//            while(i<strNum.length){
//                if(strNum[i]>2000){
//                    Long tId=testRecord.getTestRecordId();
//                    trc.setTestRecordId(tId);
//                    trc.setEnrollYear(strNum[i]);
//                    trc.setClassNo(strNum[i+1]);
//                    testRecordClassMapper.insertTestRecordClass(trc);
//                    flag=i+2;  //注意会越界
//                    while(strNum[flag]<500){
//                        trc.setTestRecordId(tId);
//                        trc.setEnrollYear(strNum[i]);
//                        trc.setClassNo(strNum[flag]);
//                        testRecordClassMapper.insertTestRecordClass(trc);
//                        flag++;
//                    }
//                    i=flag;
//                }
//            }
//        }

        return prsnTeacherMapper.insertPrsnTeacher(prsnTeacher);
    }

    /**
     * 修改教师信息 
     * 
     * @param prsnTeacher 教师信息 
     * @return 结果
     */
    @Override
    public int updatePrsnTeacher(PrsnTeacher prsnTeacher)
    {
        return prsnTeacherMapper.updatePrsnTeacher(prsnTeacher);
    }

    /**
     * 删除教师信息 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePrsnTeacherByIds(String ids)
    {
        return prsnTeacherMapper.deletePrsnTeacherByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教师信息 信息
     * 
     * @param teacherId 教师信息 ID
     * @return 结果
     */
    @Override
    public int deletePrsnTeacherById(Long teacherId)
    {
        return prsnTeacherMapper.deletePrsnTeacherById(teacherId);
    }

    /**
     * 根据accountId找到stuId
     *
     * @param accountId 教师信息 ID
     * @return 教师信息
     */
    @Override
    public TeaInfo selectteaIdByAccountId(Long accountId){
        List<PrsnTeacher> prsnTeacherk=prsnTeacherMapper.selectteaIdByAccountId(accountId);
        TeaInfo teaInfo = new TeaInfo();
//        Long teacherJobId=prsnStudentk.getStuNationId();
//        String stuNationName=getDictLabel("sys_user_nation",stuNationId.toString());
//
//        prsnStudentk.setstuNationName(stuNationName);

        if(prsnTeacherk.size()>0){
            teaInfo.setTeacherEmail(prsnTeacherk.get(0).getTeacherEmail());
            teaInfo.setTeacherId(prsnTeacherk.get(0).getTeacherId());
            teaInfo.setTeacherJobId(prsnTeacherk.get(0).getTeacherJobId());
            teaInfo.setTeacherName(prsnTeacherk.get(0).getTeacherName());
            teaInfo.setTeacherNid(prsnTeacherk.get(0).getTeacherNid());
            teaInfo.setTeacherNo(prsnTeacherk.get(0).getTeacherNo());
            teaInfo.setTeacherPhone(prsnTeacherk.get(0).getTeacherPhone());
            teaInfo.setTeacherSex(prsnTeacherk.get(0).getTeacherSex());
            teaInfo.setTeacherWechat(prsnTeacherk.get(0).getTeacherWechat());
            int i;
            int len = prsnTeacherk.size();
            StringBuilder enrollYearString = new StringBuilder("");
            for(i=0; i<len ;i++){
                if(Integer.valueOf(prsnTeacherk.get(i).getEnrollYear())!=0){
                    if(i!=0)    enrollYearString.append("、");
                    if(Integer.valueOf(prsnTeacherk.get(i).getEnrollYear())<100000){
                        enrollYearString.append(Integer.valueOf(prsnTeacherk.get(i).getEnrollYear())/10);
                        enrollYearString.append(0);
                        enrollYearString.append(Integer.valueOf(prsnTeacherk.get(i).getEnrollYear())%10);
                    }
                    else    enrollYearString.append(prsnTeacherk.get(i).getEnrollYear());
                }
            }
            teaInfo.setEnrollYearString(enrollYearString.toString());
            Long teacherJobId=teaInfo.getTeacherJobId();
            String teacherJobName=getDictLabel("teacher_job_id",teacherJobId.toString());
            teaInfo.setTeacherJobName(teacherJobName);
        }


        return teaInfo;
    }

    /**
     * 修改教师信息
     *
     * @param prsnTeacher 教师信息
     * @return 结果
     */
    @Override
    public int updatepartPrsnTeacher(PrsnTeacher prsnTeacher)
    {
        return prsnTeacherMapper.updatepartPrsnTeacher(prsnTeacher);
    }

}
