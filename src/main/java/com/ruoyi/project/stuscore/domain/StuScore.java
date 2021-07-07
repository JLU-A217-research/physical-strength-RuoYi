package com.ruoyi.project.stuscore.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.shiro.session.Session;

/**
 * 我的成绩对象 score
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
public class StuScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 成绩记录ID */
    private Long scoreRecordId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long stuId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String stuName;

    /** 年级-性别-项目ID */
    @Excel(name = "年级-性别-项目ID")
    private Long tgsId;

    /** 测试年级 */
    @Excel(name = "测试年级")
    private Long testGrade;

    /** 测试项目ID */
    @Excel(name = "测试项目ID")
    private Long testItemId;

    /** 测试项目 */
    @Excel(name = "测试项目")
    private String testItemName;

    /** 测试时间 */
    @Excel(name = "测试时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testTime;

    /** 测试成绩 */
    @Excel(name = "测试成绩")
    private BigDecimal testScore;

    /** 成绩单位 */
    @Excel(name = "成绩单位")
    private String testItemUnit;


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
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public void setTgsId(Long tgsId)
    {
        this.tgsId = tgsId;
    }

    public Long getTgsId()
    {
        return tgsId;
    }
    public Long getTestGrade() {
        return testGrade;
    }

    public void setTestGrade(Long testGrade) {
        this.testGrade = testGrade;
    }
    public Long getTestItemId() {
        return testItemId;
    }

    public void setTestItemId(Long testItemId) {
        this.testItemId = testItemId;
    }
    public String getTestItemName() {
        return testItemName;
    }

    public void setTestItemName(String testItemName) {
        this.testItemName = testItemName;
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
    public String getTestItemUnit() {
        return testItemUnit;
    }

    public void setTestItemUnit(String testItemUnit) {
        this.testItemUnit = testItemUnit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scoreRecordId", getScoreRecordId())
            .append("stuId", getStuId()).append("scoreRecordId", getScoreRecordId())
            .append("stuName", getStuName())
            .append("testGrade", getTestGrade())
            .append("testItemId", getTestItemId())
            .append("testItemName", getTestItemName())
            .append("testTime", getTestTime())
            .append("testScore", getTestScore())
            .toString();
    }
}
