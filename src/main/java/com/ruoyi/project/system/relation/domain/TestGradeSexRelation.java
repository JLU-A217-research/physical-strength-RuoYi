package com.ruoyi.project.system.relation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 年级-性别-测试项目关系 对象 test_grade_sex_relation
 * 
 * @author ruoyi
 * @date 2021-03-24
 */
public class TestGradeSexRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 年级-性别-项目ID */
    private Long tgsId;

    /** 年级 */
    @Excel(name = "年级")
    private Long grade;



    /** 体测项目ID */
    @Excel(name = "体测项目ID")
    private Long testItemId;

    /** 性别ID(字典) */
    @Excel(name = "性别ID(字典)")
    private Long stuSexId;

    /** 体测项目名称 */
    @Excel(name = "体测项目名称")
    private String testItemName;

    public void setTgsId(Long tgsId)
    {
        this.tgsId = tgsId;
    }

    public Long getTgsId()
    {
        return tgsId;
    }
    public void setGrade(Long grade)
    {
        this.grade = grade;
    }

    public Long getGrade()
    {
        return grade;
    }
    public void setTestItemId(Long testItemId)
    {
        this.testItemId = testItemId;
    }

    public Long getTestItemId()
    {
        return testItemId;
    }
    public void setStuSexId(Long stuSexId)
    {
        this.stuSexId = stuSexId;
    }

    public Long getStuSexId()
    {
        return stuSexId;
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
            .append("tgsId", getTgsId())
            .append("grade", getGrade())
            .append("testItemId", getTestItemId())
            .append("stuSexId", getStuSexId())
                .append("testItemName", getTestItemName())
            .toString();
    }
}
