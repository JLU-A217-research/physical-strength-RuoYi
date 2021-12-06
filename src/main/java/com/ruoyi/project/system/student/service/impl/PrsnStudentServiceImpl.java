package com.ruoyi.project.system.student.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.student.domain.PrsnStudent;
import com.ruoyi.project.system.student.domain.StuInfo;
import com.ruoyi.project.system.student.mapper.PrsnStudentMapper;
import com.ruoyi.project.system.student.service.IPrsnStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

import static com.ruoyi.project.system.dict.utils.DictUtils.getDictLabel;

/**
 * 学生信息 Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
@Service
public class PrsnStudentServiceImpl implements IPrsnStudentService 
{
    @Autowired
    private PrsnStudentMapper prsnStudentMapper;

    /**
     * 查询学生信息 
     * 
     * @param stuId 学生信息 ID
     * @return 学生信息 
     */
    @Override
    public PrsnStudent selectPrsnStudentById(Long stuId)
    {
        return prsnStudentMapper.selectPrsnStudentById(stuId);
    }

    /**
     * 查询学生信息 列表
     * 
     * @param prsnStudent 学生信息 
     * @return 学生信息 
     */
    @Override
    public List<PrsnStudent> selectPrsnStudentList(PrsnStudent prsnStudent)
    {
        return prsnStudentMapper.selectPrsnStudentList(prsnStudent);
    }

    /**
     * 新增学生信息 
     * 
     * @param prsnStudent 学生信息 
     * @return 结果
     */
    @Override
    public int insertPrsnStudent(PrsnStudent prsnStudent)
    {
        return prsnStudentMapper.insertPrsnStudent(prsnStudent);
    }

    /**
     * 修改学生信息 
     * 
     * @param prsnStudent 学生信息 
     * @return 结果
     */
    @Override
    public int updatePrsnStudent(PrsnStudent prsnStudent)
    {
        return prsnStudentMapper.updatePrsnStudent(prsnStudent);
    }

    /**
     * 修改学生信息
     *
     * @param prsnStudent 学生信息
     * @return 结果
     */
    @Override
    public int updatepartPrsnStudent(PrsnStudent prsnStudent)
    {
        return prsnStudentMapper.updatepartPrsnStudent(prsnStudent);
    }

    /**
     * 找到班级ID
     *
     * @param gradeClassId 根据年班ID
     * @return 结果
     */
    @Override
    public Long selectclassById(Long gradeClassId){
        return prsnStudentMapper.selectclassById(gradeClassId);
    }

    /**章荣荣
     *
     *
     * @param accountId 需要删除的数据ID
     * @return 结果
     */
    @Override
    public StuInfo selectstuIdByAccountId(Long accountId) {

        PrsnStudent prsnStudentk = prsnStudentMapper.selectstuIdByAccountId(accountId);
        Long stuNationId=prsnStudentk.getStuNationId();
        String stuNationName=getDictLabel("sys_user_nation",stuNationId.toString());

        prsnStudentk.setStuNationName(stuNationName);
        StuInfo stuInfo=new StuInfo();
        stuInfo.setAccountId(prsnStudentk.getAccountId());
        stuInfo.setGradeClassId(prsnStudentk.getGradeClassId());
        stuInfo.setPsw(prsnStudentk.getPsw());
        stuInfo.setStuBirth(prsnStudentk.getStuBirth());
        stuInfo.setStuEnrollYear(prsnStudentk.getStuEnrollYear());
        stuInfo.setStuBirth(prsnStudentk.getStuBirth());
        stuInfo.setstuNationName(prsnStudentk.getStuNationName());
        stuInfo.setStuNid(prsnStudentk.getStuNid());
        stuInfo.setStuNationId(prsnStudentk.getStuNationId());
        stuInfo.setStuPhone(prsnStudentk.getStuPhone());
        stuInfo.setStuSex(prsnStudentk.getStuSex());
        stuInfo.setStuId(prsnStudentk.getStuId());
        stuInfo.setStuSexId(prsnStudentk.getStuSexId());
        stuInfo.setStuName(prsnStudentk.getStuName());
        stuInfo.setStuNo(prsnStudentk.getStuNo());
        stuInfo.setStuWechat(prsnStudentk.getStuWechat());
        Calendar c= Calendar.getInstance();
        long nowyear=c.get(Calendar.YEAR);
        String dt=String.format("%tY",prsnStudentk.getStuBirth());
        long birthyear=Long.parseLong(dt);
        long year=nowyear-birthyear;
        stuInfo.setStuYear(year);
        long gradeClassId=stuInfo.getGradeClassId();
        //long enrollyear=prsnStudentMapper.selectenrollYearById(gradeClassId);
        Long classId=prsnStudentMapper.selectclassById(gradeClassId);
//        stuInfo.setStuEnrollYear((int) enrollyear);
        stuInfo.setClassId(classId);


        return stuInfo;
    }

    /**
     * 删除学生信息 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePrsnStudentByIds(String ids)
    {
        return prsnStudentMapper.deletePrsnStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生信息 信息
     * 
     * @param stuId 学生信息 ID
     * @return 结果
     */
    @Override
    public int deletePrsnStudentById(Long stuId)
    {
        return prsnStudentMapper.deletePrsnStudentById(stuId);
    }
}
