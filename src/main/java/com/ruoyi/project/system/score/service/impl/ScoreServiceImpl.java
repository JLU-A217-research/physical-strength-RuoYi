package com.ruoyi.project.system.score.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.score.mapper.ScoreMapper;
import com.ruoyi.project.system.score.domain.Score;
import com.ruoyi.project.system.score.service.IScoreService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 学生成绩 Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
@Service
public class ScoreServiceImpl implements IScoreService 
{
    @Autowired
    private ScoreMapper scoreMapper;

    /**
     * 查询学生成绩 
     * 
     * @param scoreRecordId 学生成绩 ID
     * @return 学生成绩 
     */
    @Override
    public Score selectScoreById(Long scoreRecordId)
    {
        return scoreMapper.selectScoreById(scoreRecordId);
    }

    /**
     * 查询学生成绩 列表
     * 
     * @param score 学生成绩 
     * @return 学生成绩 
     */
    @Override
    public List<Score> selectScoreList(Score score)
    {
        return scoreMapper.selectScoreList(score);
    }

    /**
     * 新增学生成绩 
     * 
     * @param score 学生成绩 
     * @return 结果
     */
    @Override
    public int insertScore(Score score)
    {
        return scoreMapper.insertScore(score);
    }

    /**
     * 修改学生成绩 
     * 
     * @param score 学生成绩 
     * @return 结果
     */
    @Override
    public int updateScore(Score score)
    {
        return scoreMapper.updateScore(score);
    }

    /**
     * 删除学生成绩 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteScoreByIds(String ids)
    {
        return scoreMapper.deleteScoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生成绩 信息
     * 
     * @param scoreRecordId 学生成绩 ID
     * @return 结果
     */
    @Override
    public int deleteScoreById(Long scoreRecordId)
    {
        return scoreMapper.deleteScoreById(scoreRecordId);
    }
}
