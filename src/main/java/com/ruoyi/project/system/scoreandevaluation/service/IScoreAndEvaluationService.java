package com.ruoyi.project.system.scoreandevaluation.service;

import java.util.List;
import com.ruoyi.project.system.scoreandevaluation.domain.ScoreAndEvaluation;

/**
 * 成绩与体质评价Service接口
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
public interface IScoreAndEvaluationService
{
    /**
     * 查询成绩与体质评价
     * 
     * @param scoreRecordId 成绩与体质评价ID
     * @return 成绩与体质评价
     */
    public ScoreAndEvaluation selectScoreById(Long scoreRecordId);

    /**
     * 查询成绩与体质评价列表
     * 
     * @param score 成绩与体质评价
     * @return 成绩与体质评价集合
     */
    public List<ScoreAndEvaluation> selectScoreList(ScoreAndEvaluation score);

    /**
     * 新增成绩与体质评价
     * 
     * @param score 成绩与体质评价
     * @return 结果
     */
    public int insertScore(ScoreAndEvaluation score);

    /**
     * 修改成绩与体质评价
     * 
     * @param score 成绩与体质评价
     * @return 结果
     */
    public int updateScore(ScoreAndEvaluation score);

    /**
     * 批量删除成绩与体质评价
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteScoreByIds(String ids);

    /**
     * 删除成绩与体质评价信息
     * 
     * @param scoreRecordId 成绩与体质评价ID
     * @return 结果
     */
    public int deleteScoreById(Long scoreRecordId);
}
