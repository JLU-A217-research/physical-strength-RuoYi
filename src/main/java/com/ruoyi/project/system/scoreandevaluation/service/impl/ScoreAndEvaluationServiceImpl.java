package com.ruoyi.project.system.scoreandevaluation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.scoreandevaluation.mapper.ScoreAndEvaluationMapper;
import com.ruoyi.project.system.scoreandevaluation.domain.ScoreAndEvaluation;
import com.ruoyi.project.system.scoreandevaluation.service.IScoreAndEvaluationService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 成绩与体质评价Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
@Service
public class ScoreAndEvaluationServiceImpl implements IScoreAndEvaluationService
{
    @Autowired
    private ScoreAndEvaluationMapper scoreAndEvaluationMapper;

    /**
     * 查询成绩与体质评价
     * 
     * @param scoreRecordId 成绩与体质评价ID
     * @return 成绩与体质评价
     */
    @Override
    public ScoreAndEvaluation selectScoreById(Long scoreRecordId)
    {
        return scoreAndEvaluationMapper.selectScoreById(scoreRecordId);
    }

    /**
     * 查询成绩与体质评价列表
     * 
     * @param score 成绩与体质评价
     * @return 成绩与体质评价
     */
    @Override
    public List<ScoreAndEvaluation> selectScoreList(ScoreAndEvaluation score)
    {
        return scoreAndEvaluationMapper.selectScoreList(score);
    }

    /**
     * 新增成绩与体质评价
     * 
     * @param score 成绩与体质评价
     * @return 结果
     */
    @Override
    public int insertScore(ScoreAndEvaluation score)
    {
        return scoreAndEvaluationMapper.insertScore(score);
    }

    /**
     * 修改成绩与体质评价
     * 
     * @param score 成绩与体质评价
     * @return 结果
     */
    @Override
    public int updateScore(ScoreAndEvaluation score)
    {
        return scoreAndEvaluationMapper.updateScore(score);
    }

    /**
     * 删除成绩与体质评价对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteScoreByIds(String ids)
    {
        return scoreAndEvaluationMapper.deleteScoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除成绩与体质评价信息
     * 
     * @param scoreRecordId 成绩与体质评价ID
     * @return 结果
     */
    @Override
    public int deleteScoreById(Long scoreRecordId)
    {
        return scoreAndEvaluationMapper.deleteScoreById(scoreRecordId);
    }
}
