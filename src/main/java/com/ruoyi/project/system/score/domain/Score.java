package com.ruoyi.project.system.score.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 学生成绩 对象 score
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public class Score extends BaseEntity
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

    /** 年级 */
    @Excel(name = "年级")
    private Long classGrade;

    /** 测试项目 */
    @Excel(name = "测试项目")
    private String testItemName;

    /** 单位 */
    @Excel(name = "单位")
    private String testItemUnit;

    /** 得分 */
    @Excel(name = "得分")
    private String testPoint;

    /** 等级 */
    @Excel(name = "等级")
    private String testgrade;


    public String getTestgrade() {
        return testgrade;
    }
    public void setTestgrade(String testgrade) {
        this.testgrade = testgrade;
    }

    public String getTestPoint() {
        return testPoint;
    }
    public void setTestPoint(String testPoint) {
        this.testPoint = testPoint;
    }

    public String getTestItemUnit() {
        return testItemUnit;
    }
    public void setTestItemUnit(String testItemUnit) {
        this.testItemUnit = testItemUnit;
    }


    public String getTestItemName() {
        return testItemName;
    }

    public void setTestItemName(String testItemName) {
        this.testItemName = testItemName;
    }

    public Long getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Long classGrade) {
        this.classGrade = classGrade;
    }




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
            .append("classGrade", getClassGrade())
            .append("testItemName", getTestItemName())
            .append("testItemUnit", getTestItemUnit())
            .append("testPoint", getTestPoint())
            .append("testgrade", getTestgrade())
            .append("testScore", getTestScore())
            .toString();
    }
}
