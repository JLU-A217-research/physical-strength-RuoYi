package com.ruoyi.project.system.scoreandevaluation.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 成绩与体质评价对象 score
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
public class ScoreAndEvaluation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 成绩记录ID */
    private Long scoreRecordId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long stuId;

    /** 年级-性别-项目ID */
    @Excel(name = "年级-性别-项目ID")
    private Long tgsId;

    /** 测试时间 */
    @Excel(name = "测试时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testTime;

    /** 测试成绩 */
    @Excel(name = "测试成绩")
    private BigDecimal testScore;

    public void setScoreRecordId(Long scoreRecordId)
    {
        this.scoreRecordId = scoreRecordId;
    }

    public Long getScoreRecordId()
    {
        return scoreRecordId;
    }
    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }
    public void setTgsId(Long tgsId)
    {
        this.tgsId = tgsId;
    }

    public Long getTgsId()
    {
        return tgsId;
    }
    public void setTestTime(Date testTime)
    {
        this.testTime = testTime;
    }

    public Date getTestTime()
    {
        return testTime;
    }
    public void setTestScore(BigDecimal testScore)
    {
        this.testScore = testScore;
    }

    public BigDecimal getTestScore()
    {
        return testScore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scoreRecordId", getScoreRecordId())
            .append("stuId", getStuId())
            .append("tgsId", getTgsId())
            .append("testTime", getTestTime())
            .append("testScore", getTestScore())
            .toString();
    }
}
