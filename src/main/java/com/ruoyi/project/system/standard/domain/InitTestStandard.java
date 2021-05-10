package com.ruoyi.project.system.standard.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 测试指标 对象 test_standard
 *
 * @author ruoyi
 * @date 2021-03-29
 */
public class InitTestStandard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 测试指标项ID */
    private Long testStandardId;


    /** 测试基准 */
    @Excel(name = "测试基准")
    private double testBase;

    /** 得分 */
    @Excel(name = "得分")
    private long testPoint;

    /** 等级ID（字典） */
    @Excel(name = "等级ID", readConverterExp = "字=典")
    private Long testGradeId;

    /** 体测项目ID */
    @Excel(name = "体测项目ID")
    private Long testItemId;

    /** 年级 */
    @Excel(name = "年级")
    private Long grade;

    /** 性别ID */
    @Excel(name = "性别ID")
    private Long stuSexId;




    public void setTestStandardId(Long testStandardId)
    {
        this.testStandardId = testStandardId;
    }

    public Long getTestStandardId()
    {
        return testStandardId;
    }

    public void setTestBase(double testBase)
    {
        this.testBase = testBase;
    }

    public Double getTestBase()
    {
        return testBase;
    }


    public void setTestPoint(long testPoint)
    {
        this.testPoint = testPoint;
    }

    public long getTestPoint()
    {
        return testPoint;
    }
    public void setTestGradeId(Long testGradeId)
    {
        this.testGradeId = testGradeId;
    }

    public Long getTestGradeId()
    {
        return testGradeId;
    }

    public Long getTestItemId()
    {
        return testItemId;
    }
    public void setTestItemId(Long testItemId)
    {
        this.testItemId = testItemId;
    }

    public Long getGrade()
    {
        return grade;
    }
    public void setGrade(Long grade)
    {
        this.grade = grade;
    }

    public Long getStuSexId()
    {
        return stuSexId;
    }
    public void setStuSexId(Long stuSexId)
    {
        this.stuSexId = stuSexId;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("testStandardId", getTestStandardId())
                .append("testBase", getTestBase())
                .append("testPoint", getTestPoint())
                .append("testGradeId", getTestGradeId())
                .append("testItemId", getTestItemId())
                .append("grade", getGrade())
                .append("stuSexId", getStuSexId())
                .toString();
    }
}
