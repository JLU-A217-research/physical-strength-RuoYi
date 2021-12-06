package com.ruoyi.project.system.stu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 测试学生列 对象 test_stu
 * 
 * @author ruoyi
 * @date 2021-07-16
 */
public class TestStu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 测试学生列表ID */
    private Long testStuId;

    /** 测试学生ID */
    @Excel(name = "测试学生ID")
    private Long stuId;

    /** 测试记录ID */
    @Excel(name = "测试记录ID")
    private Long testRecordId;

    /** 测试项目ID */
    @Excel(name = "测试项目ID")
    private Long testItemId;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    private float score;

    /** 是否通过 0-否，1-是 */
    @Excel(name = "是否通过 0-否，1-是")
    private Integer passOrNot;

    public void setTestStuId(Long testStuId)
    {
        this.testStuId = testStuId;
    }

    public Long getTestStuId()
    {
        return testStuId;
    }
    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }
    public void setTestRecordId(Long testRecordId)
    {
        this.testRecordId = testRecordId;
    }

    public Long getTestRecordId()
    {
        return testRecordId;
    }
    public void setTestItemId(Long testItemId)
    {
        this.testItemId = testItemId;
    }

    public Long getTestItemId()
    {
        return testItemId;
    }
    public void setPassOrNot(Integer passOrNot)
    {
        this.passOrNot = passOrNot;
    }

    public Integer getPassOrNot()
    {
        return passOrNot;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("testStuId", getTestStuId())
            .append("stuId", getStuId())
            .append("testRecordId", getTestRecordId())
            .append("testItemId", getTestItemId())
            .append("passOrNot", getPassOrNot())
             .append("score",getScore())
            .toString();
    }
}
