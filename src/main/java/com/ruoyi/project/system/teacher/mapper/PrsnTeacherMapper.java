package com.ruoyi.project.system.teacher.mapper;

import java.util.List;
import com.ruoyi.project.system.teacher.domain.PrsnTeacher;

/**
 * 教师信息 Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
public interface PrsnTeacherMapper 
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


    /**
     * 根据accountId找到stuId
     *
     * @param accountId 教师信息 ID
     * @return 教师信息
     */

    public PrsnTeacher selectteaIdByAccountId(Long accountId);
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
     * 删除教师信息 
     * 
     * @param teacherId 教师信息 ID
     * @return 结果
     */
    public int deletePrsnTeacherById(Long teacherId);

    /**
     * 批量删除教师信息 
     * 
     * @param teacherIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePrsnTeacherByIds(String[] teacherIds);
}
