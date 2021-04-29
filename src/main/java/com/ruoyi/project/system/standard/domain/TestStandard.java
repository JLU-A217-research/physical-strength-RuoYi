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
public class TestStandard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 测试指标项ID */
    private Long testStandardId;

    /** 年级-性别-项目ID */
    @Excel(name = "年级-性别-项目ID")
    private Long tgsId;

    /** 七年级测试基准 */
    @Excel(name = "七年级测试基准")
    private double testBase7;

    /** 八年级测试基准 */
    @Excel(name = "八年级测试基准")
    private double testBase8;

    /** 九年级测试基准 */
    @Excel(name = "九年级测试基准")
    private double testBase9;

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

    /** 体测项目名称 */
    @Excel(name = "体测项目名称")
    private String testItemName;




    public void setTestStandardId(Long testStandardId)
    {
        this.testStandardId = testStandardId;
    }

    public Long getTestStandardId()
    {
        return testStandardId;
    }
    public void setTgsId(Long tgsId)
    {
        this.tgsId = tgsId;
    }

    public Long getTgsId()
    {
        return tgsId;
    }
    public void setTestBase7(double testBase7)
    {
        this.testBase7 = testBase7;
    }

    public Double getTestBase7()
    {
        return testBase7;
    }

    public void setTestBase8(double testBase8)
    {
        this.testBase8 = testBase8;
    }

    public Double getTestBase8()
    {
        return testBase8;
    }

    public void setTestBase9(double testBase9)
    {
        this.testBase9 = testBase9;
    }

    public Double getTestBase9()
    {
        return testBase9;
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

    public String getTestItemName()
    {
        return testItemName;
    }
    public void setTestItemName(String testItemName)
    {
        this.testItemName = testItemName;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("testStandardId", getTestStandardId())
            .append("tgsId", getTgsId())
            .append("testBase7", getTestBase7())
                .append("testBase8", getTestBase8())
                .append("testBase9", getTestBase9())
            .append("testPoint", getTestPoint())
            .append("testGradeId", getTestGradeId())
                .append("testItemId", getTestItemId())
                .append("grade", getGrade())
                .append("stuSexId", getStuSexId())
                .append("testItemName", getTestItemName())

                .toString();
    }
    public class TestStandardALL{

    }
}
