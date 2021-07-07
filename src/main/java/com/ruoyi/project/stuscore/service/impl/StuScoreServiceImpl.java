package com.ruoyi.project.stuscore.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.stuscore.mapper.StuScoreMapper;
import com.ruoyi.project.stuscore.domain.StuScore;
import com.ruoyi.project.stuscore.service.IStuScoreService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 我的成绩Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
@Service
public class StuScoreServiceImpl implements IStuScoreService 
{
    @Autowired
    private StuScoreMapper stuScoreMapper;

    /**
     * 查询我的成绩
     * 
     * @param scoreRecordId 我的成绩ID
     * @return 我的成绩
     */
    @Override
    public StuScore selectStuScoreById(Long scoreRecordId)
    {
        return stuScoreMapper.selectStuScoreById(scoreRecordId);
    }

    /**
     * 查询我的成绩列表
     * 
     * @param stuScore 我的成绩
     * @return 我的成绩
     */
    @Override
    public List<StuScore> selectStuScoreList(StuScore stuScore)
    {
        return stuScoreMapper.selectStuScoreList(stuScore);
    }

    /**
     * 新增我的成绩
     * 
     * @param stuScore 我的成绩
     * @return 结果
     */
    @Override
    public int insertStuScore(StuScore stuScore)
    {
        return stuScoreMapper.insertStuScore(stuScore);
    }

    /**
     * 修改我的成绩
     * 
     * @param stuScore 我的成绩
     * @return 结果
     */
    @Override
    public int updateStuScore(StuScore stuScore)
    {
        return stuScoreMapper.updateStuScore(stuScore);
    }

    /**
     * 删除我的成绩对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStuScoreByIds(String ids)
    {
        return stuScoreMapper.deleteStuScoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除我的成绩信息
     * 
     * @param scoreRecordId 我的成绩ID
     * @return 结果
     */
    @Override
    public int deleteStuScoreById(Long scoreRecordId)
    {
        return stuScoreMapper.deleteStuScoreById(scoreRecordId);
    }
}
