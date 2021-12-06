package com.ruoyi.project.system.scoreandevaluation.studentscoremanage.service;

import java.util.List;
import com.ruoyi.project.system.scoreandevaluation.studentscoremanage.domain.Score;

/**
 * 学生成绩管理Service接口
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
public interface IScoreService 
{
    /**
     * 查询学生成绩管理
     * 
     * @param scoreRecordId 学生成绩管理ID
     * @return 学生成绩管理
     */
    public Score selectScoreById(Long scoreRecordId);

    /**
     * 查询学生信息
     *
     * @param stuNo 学号
     * @return 学生成绩管理
     */
    public Score selectStudentByNo(Long stuNo);

    /**
     * 查询学生成绩管理列表
     * 
     * @param score 学生成绩管理
     * @return 学生成绩管理集合
     */
    public List<Score> selectScoreListByStu(Score score);

    /**
     * 新增学生成绩管理
     * 
     * @param score 学生成绩管理
     * @return 结果
     */
    public int insertScore(Score score);

    public Score selectItemId(Score score);

    /**
     * 修改学生成绩管理
     * 
     * @param score 学生成绩管理
     * @return 结果
     */
    public int updateScore(Score score);

    /**
     * 批量删除学生成绩管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteScoreByIds(String ids);

    /**
     * 删除学生成绩管理信息
     * 
     * @param scoreRecordId 学生成绩管理ID
     * @return 结果
     */
    public int deleteScoreById(Long scoreRecordId);

    public long creatPoint(Score s);

    public long creatTestGrade(Score s);

    public void updateBMI();

}
