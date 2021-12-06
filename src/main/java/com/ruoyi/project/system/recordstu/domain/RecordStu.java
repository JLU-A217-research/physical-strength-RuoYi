package com.ruoyi.project.system.recordstu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 record_stu
 * 
 * @author ruoyi
 * @date 2021-07-26
 */
public class RecordStu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 体测记录Id */
    @Excel(name = "体测记录Id")
    private Long testRecordId;

    /** 学生Id */
    @Excel(name = "学生Id")
    private Long stuId;

    /** 学生年级 */
    @Excel(name = "学生年级")
    private Long enrollYear;

    /** 学生班级 */
    @Excel(name = "学生班级")
    private Long classNo;

    /** 体测项目 */
    @Excel(name = "体测项目")
    private Long testItemId;

    public Long getTestStuId() {
        return testStuId;
    }

    public void setTestStuId(Long testStuId) {
        this.testStuId = testStuId;
    }

    /** 总编号 */
    private Long testStuId;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    /** flag用来表示该条数据是否在数据库中，如果0则insert ，如果1则update */
    private int flag=0;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    private float score;

    public String getTestItemName() {
        return testItemName;
    }

    public void setTestItemName(String testItemName) {
        this.testItemName = testItemName;
    }

    private String testItemName;

    public  Long getTestRecordIds() {
        return testRecordIds;
    }

    public void setTestRecordIds(Long testRecordIds) {
        this.testRecordIds = testRecordIds;
    }

    private Long testRecordIds;

    public Long getPassOrNot() {
        return passOrNot;
    }

    public void setPassOrNot(Long passOrNot) {
        this.passOrNot = passOrNot;
    }

    private Long passOrNot;

    public void setTestRecordId(Long testRecordId)
    {
        this.testRecordId = testRecordId;
    }

    public Long getTestRecordId()
    {
        return testRecordId;
    }
    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }
    public void setEnrollYear(Long enrollYear)
    {
        this.enrollYear = enrollYear;
    }

    public Long getEnrollYear()
    {
        return enrollYear;
    }
    public void setClassNo(Long classNo)
    {
        this.classNo = classNo;
    }

    public Long getClassNo()
    {
        return classNo;
    }
    public void setTestItemId(Long testItemId)
    {
        this.testItemId = testItemId;
    }

    public Long getTestItemId()
    {
        return testItemId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("testRecordId", getTestRecordId())
            .append("stuId", getStuId())
            .append("enrollYear", getEnrollYear())
            .append("classNo", getClassNo())
            .append("testItemId", getTestItemId())
            .append("passOrNot",getPassOrNot())
            .append("testRecordIds",getTestRecordIds())
            .append("testItemName" ,getTestItemName())
            .append("score",getScore())
            .append("flag",getFlag())
            .append("testStuId",getTestStuId())
            .toString();
    }
}
