package com.ruoyi.project.system.bodyevaluation.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class BodyScore extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 成绩记录ID */
    private Long scoreRecordId;

    /** 年级-性别-项目ID */
    @Excel(name = "年级-性别-项目ID")
    private Long tgsId;

    /** 测试时间 */
    @Excel(name = "测试时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testTime;

    /** 测试成绩 */
    @Excel(name = "测试成绩")
    private double testScore;

    /** 年级 */
    @Excel(name = "年级")
    private Long classGrade;

    public Long getClassNo() {
        return classNo;
    }

    public void setClassNo(Long classNo) {
        this.classNo = classNo;
    }

    /** 班级 */
    @Excel(name = "班级")
    private Long classNo;

    /** 测试项目名称 */
    @Excel(name = "测试项目")
    private String itemName;

    /** 测试得分 */
    @Excel(name = "测试得分")
    private Long testPoint;

    /** 测试等级Id */
    @Excel(name = "测试等级Id")
    private Long testGradeId;

    public String getTestGrade() { return testGrade; }

    public void setTestGrade(String testGrade) { this.testGrade = testGrade; }

    /** 测试等级 */
    @Excel(name = "测试等级")
    private String testGrade;

    /** 性别Id */
    @Excel(name = "性别ID")
    private Long sexId;

    /** 成绩相关性 */
    @Excel(name = "成绩相关性")
    private Long scoreRelation;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Excel(name = "项目ID")
    private Long itemId;



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

    public Long getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Long classGrade) {
        this.classGrade = classGrade;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setScoreRecordId(Long scoreRecordId)
    {
        this.scoreRecordId = scoreRecordId;
    }

    public Long getScoreRecordId()
    {
        return scoreRecordId;
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
    public void setTestScore(double testScore)
    {
        this.testScore = testScore;
    }

    public double getTestScore()
    {
        return testScore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("scoreRecordId", getScoreRecordId())
                .append("tgsId", getTgsId())
                .append("testTime", getTestTime())
                .append("testScore", getTestScore())
                .append("classGrade", getClassGrade())
                .append("classNo", getClassNo())
                .append("itemName", getItemName())
                .append("testPoint", getTestPoint())
                .append("testGradeId", getTestGradeId())
                .append("testGrade",getTestGrade())
                .append("sexId", getSexId())
                .append("scoreRelation", getScoreRelation())
                .append("itemId",getItemId())
                .toString();
    }

}
