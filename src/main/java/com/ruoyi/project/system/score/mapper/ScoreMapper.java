package com.ruoyi.project.system.score.mapper;

import java.util.List;
import com.ruoyi.project.system.score.domain.Score;

/**
 * 学生成绩 Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public interface ScoreMapper 
{
    /**
     * 查询学生成绩 
     * 
     * @param scoreRecordId 学生成绩 ID
     * @return 学生成绩 
     */
    public Score selectScoreById(Long scoreRecordId);

    /**
     * 查询学生成绩 列表
     * 
     * @param score 学生成绩 
     * @return 学生成绩 集合
     */
    public List<Score> selectScoreList(Score score);

    /**
     * 新增学生成绩 
     * 
     * @param score 学生成绩 
     * @return 结果
     */
    public int insertScore(Score score);

    /**
     * 修改学生成绩 
     * 
     * @param score 学生成绩 
     * @return 结果
     */
    public int updateScore(Score score);

    /**
     * 删除学生成绩 
     * 
     * @param scoreRecordId 学生成绩 ID
     * @return 结果
     */
    public int deleteScoreById(Long scoreRecordId);

    /**
     * 批量删除学生成绩 
     * 
     * @param scoreRecordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteScoreByIds(String[] scoreRecordIds);
}
