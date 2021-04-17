package com.ruoyi.project.system.studentscoremanage.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 学生成绩管理对象 score
 * 
 * @author ruoyi
 * @date 2021-04-02
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

    /** 学号 */
    @Excel(name = "学号")
    private Long stuNo;

    /** 年级 */
    @Excel(name = "年级")
    private Long classGrade;

    /**测试项目ID*/
    @Excel(name = "测试项目Id")
    private Long itemId;

    /** 测试项目名称 */
    @Excel(name = "测试项目")
    private String itemName;

    /** 测试项目单位 */
    @Excel(name = "项目单位")
    private String itemUnit;

    /** 测试得分 */
    @Excel(name = "测试得分")
    private Long testPoint;

    /** 测试等级 */
    @Excel(name = "测试等级")
    private Long testGradeId;

    /** 性别Id */
    @Excel(name = "性别ID")
    private Long sexId;

    /** 成绩相关性 */
    @Excel(name = "成绩相关性")
    private Long scoreRelation;

    public Long getScoreRelation() {
        return scoreRelation;
    }

    public void setScoreRelation(Long scoreRelation) {
        this.scoreRelation = scoreRelation;
    }
    public Long getSexId() {
        return sexId;
    }

    public void setSexId(Long sexId) {
        this.sexId = sexId;
    }

    public Long getTestPoint() {
        return testPoint;
    }

    public void setTestPoint(Long testPoint) {
        this.testPoint = testPoint;
    }

    public Long getTestGradeId() {
        return testGradeId;
    }

    public void setTestGradeId(Long testGradeId) {
        this.testGradeId = testGradeId;
    }

    public Long getStuNo() {
        return stuNo;
    }

    public void setStuNo(Long stuNo) {
        this.stuNo = stuNo;
    }

    public Long getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Long classGrade) {
        this.classGrade = classGrade;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
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
            .append("testScore", getTestScore())
            .append("stuNo", getStuNo())
            .append("classGrade", getClassGrade())
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("itemUnit", getItemUnit())
            .append("testPoint", getTestPoint())
            .append("testGradeId", getTestGradeId())
            .append("sexId", getSexId())
            .append("scoreRelation", getScoreRelation())
            .toString();
    }
}
