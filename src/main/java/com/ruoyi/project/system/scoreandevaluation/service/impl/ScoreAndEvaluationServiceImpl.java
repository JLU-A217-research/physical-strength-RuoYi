package com.ruoyi.project.system.scoreandevaluation.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.config.service.IConfigService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ScoreAndEvaluationMapper scoreAndEvaluationMapper;

    @Autowired
    private IConfigService configService;

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

    @Override
    public List<ScoreAndEvaluation> selectStuList(ScoreAndEvaluation score)
    {
        return scoreAndEvaluationMapper.selectStuList(score);
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

    @Override
    public Long selectTgsId(ScoreAndEvaluation score){
        return scoreAndEvaluationMapper.selectTgsId(score);
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

    @Override
    public ScoreAndEvaluation selectStuById(Long stuId){
        return scoreAndEvaluationMapper.selectStuById(stuId);
    }

    @Override
    public String importScore(List<ScoreAndEvaluation> scoreList, Boolean isUpdateSupport)
    {
        if (StringUtils.isNull(scoreList) || scoreList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String operName = ShiroUtils.getLoginName();
        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (ScoreAndEvaluation score : scoreList)
        {
            try
            {
                // 验证是否存在这个用户
//                ScoreAndEvaluation s = scoreAndEvaluationMapper.selectScoreByStuId(score.getStuId());
                if (true)
                {
//                    score.setPassword(password);
//                    score.setCreateBy(operName);
                    this.insertScore(score);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、学生 " + score.getStuId() + " 导入成功");
                }
//                else if (isUpdateSupport)
//                {
//                    user.setUpdateBy(operName);
//                    this.updateUser(user);
//                    successNum++;
//                    successMsg.append("<br/>" + successNum + "、账号 " + score.getStuId() + " 更新成功");
//                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + score.getStuId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + score.getStuId() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
