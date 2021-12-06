package com.ruoyi.project.stuscore.mapper;

import java.util.List;
import com.ruoyi.project.stuscore.domain.StuScore;

/**
 * 我的成绩Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
public interface StuScoreMapper 
{
    /**
     * 查询我的成绩
     * 
     * @param scoreRecordId 我的成绩ID
     * @return 我的成绩
     */
    public StuScore selectStuScoreById(Long scoreRecordId);

    /**
     * 查询我的成绩列表
     * 
     * @param stuScore 我的成绩
     * @return 我的成绩集合
     */
    public List<StuScore> selectStuScoreList(StuScore stuScore);

    /**
     * 新增我的成绩
     * 
     * @param stuScore 我的成绩
     * @return 结果
     */
    public int insertStuScore(StuScore stuScore);

    /**
     * 修改我的成绩
     * 
     * @param stuScore 我的成绩
     * @return 结果
     */
    public int updateStuScore(StuScore stuScore);

    /**
     * 删除我的成绩
     * 
     * @param scoreRecordId 我的成绩ID
     * @return 结果
     */
    public int deleteStuScoreById(Long scoreRecordId);

    /**
     * 批量删除我的成绩
     * 
     * @param scoreRecordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteStuScoreByIds(String[] scoreRecordIds);
}
