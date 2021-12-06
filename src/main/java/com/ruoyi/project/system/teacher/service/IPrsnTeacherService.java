package com.ruoyi.project.system.teacher.service;

import com.ruoyi.project.system.teacher.domain.PrsnTeacher;
import com.ruoyi.project.system.teacher.domain.TeaInfo;

import java.util.List;

/**
 * 教师信息 Service接口
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
public interface IPrsnTeacherService 
{
    /**
     * 查询教师信息 
     * 
     * @param teacherId 教师信息 ID
     * @return 教师信息 
     */
    public PrsnTeacher selectPrsnTeacherById(Long teacherId);

    /**
     * 查询教师信息 列表
     * 
     * @param prsnTeacher 教师信息 
     * @return 教师信息 集合
     */
    public List<PrsnTeacher> selectPrsnTeacherList(PrsnTeacher prsnTeacher);

    /*
    根据测试记录id查询教师 列表
     */
    public List<PrsnTeacher> selectPrsnTeacherByTestRecordId(Long testRecordId);

    /*
    查询所有教师 列表
     */
    public List<PrsnTeacher> selectPrsnTeacherAll();

    /**
     * 新增教师信息 
     * 
     * @param prsnTeacher 教师信息 
     * @return 结果
     */
    public int insertPrsnTeacher(PrsnTeacher prsnTeacher);

    /**
     * 修改教师信息 
     * 
     * @param prsnTeacher 教师信息 
     * @return 结果
     */
    public int updatePrsnTeacher(PrsnTeacher prsnTeacher);

    /**
     * 批量删除教师信息 
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePrsnTeacherByIds(String ids);

    /**
     * 删除教师信息 信息
     * 
     * @param teacherId 教师信息 ID
     * @return 结果
     */
    public int deletePrsnTeacherById(Long teacherId);

//    public int countTestRecordTeacherById(Long prsnTeacherId);
    /**章荣荣
     * 根据accountId找到stuId
     *
     * @param accountId 教师信息 ID
     * @return 教师信息
     */
    public TeaInfo selectteaIdByAccountId(Long accountId);

    /**
     * 修改教师信息
     *
     * @param prsnTeacher 教师信息
     * @return 结果
     */
    public int updatepartPrsnTeacher(PrsnTeacher prsnTeacher);


}
