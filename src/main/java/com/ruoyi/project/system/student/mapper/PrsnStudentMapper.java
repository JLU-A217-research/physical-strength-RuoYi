package com.ruoyi.project.system.student.mapper;

import com.ruoyi.project.system.student.domain.PrsnStudent;

import java.util.List;

/**
 * 学生信息 Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public interface PrsnStudentMapper 
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
     * 修改学生信息
     *
     * @param prsnStudent 学生信息
     * @return 结果
     */
    public int updatepartPrsnStudent(PrsnStudent prsnStudent);

    /**
     * 删除学生信息 
     * 
     * @param stuId 学生信息 ID
     * @return 结果
     */
    public int deletePrsnStudentById(Long stuId);

    /**
     * 批量删除学生信息 
     * 
     * @param stuIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePrsnStudentByIds(String[] stuIds);

    /**
     * 校验手机号码是否唯一
     *
     * @param accountId 手机号码
     * @return 结果
     */
    public PrsnStudent selectstuIdByAccountId(Long accountId);


    /**
     * 校验手机号码是否唯一
     *
     * @param gradeClassId 手机号码
     * @return 结果
     */
    public Long selectclassById(Long gradeClassId);
}
