package com.ruoyi.project.system.student.service;

import java.util.List;
import com.ruoyi.project.system.student.domain.PrsnStudent;

/**
 * 学生信息 Service接口
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public interface IPrsnStudentService 
{
    /**
     * 查询学生信息 
     * 
     * @param stuId 学生信息 ID
     * @return 学生信息 
     */
    public PrsnStudent selectPrsnStudentById(Long stuId);

    /**
     * 查询学生信息 列表
     * 
     * @param prsnStudent 学生信息 
     * @return 学生信息 集合
     */
    public List<PrsnStudent> selectPrsnStudentList(PrsnStudent prsnStudent);

    /**
     * 新增学生信息 
     * 
     * @param prsnStudent 学生信息 
     * @return 结果
     */
    public int insertPrsnStudent(PrsnStudent prsnStudent);

    /**
     * 修改学生信息 
     * 
     * @param prsnStudent 学生信息 
     * @return 结果
     */
    public int updatePrsnStudent(PrsnStudent prsnStudent);

    /**
     * 批量删除学生信息 
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePrsnStudentByIds(String ids);

    /**
     * 删除学生信息 信息
     * 
     * @param stuId 学生信息 ID
     * @return 结果
     */
    public int deletePrsnStudentById(Long stuId);
}
