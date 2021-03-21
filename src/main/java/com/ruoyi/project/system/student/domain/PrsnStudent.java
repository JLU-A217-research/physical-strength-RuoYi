package com.ruoyi.project.system.student.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 学生信息 对象 prsn_student
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public class PrsnStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生ID */
    private Long stuId;

    /** 学生号 */
    @Excel(name = "学生号")
    private Long stuNo;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String stuName;

    /** 学生性别ID（字典） */
    @Excel(name = "学生性别ID", readConverterExp = "字=典")
    private Integer stuSex;

    /** 出生日期 */
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date stuBirth;

    /** 民族ID（字典） */
    @Excel(name = "民族ID", readConverterExp = "字=典")
    private Long stuNationId;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String stuNid;

    /** 入学年份 */
    @Excel(name = "入学年份")
    private Integer stuEnrollYear;

    /** 年班ID */
    @Excel(name = "年班ID")
    private Long gradeClassId;

    /** 学生电话 */
    @Excel(name = "学生电话")
    private String stuPhone;

    /** 学生微信 */
    @Excel(name = "学生微信")
    private String stuWechat;

    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }
    public void setStuNo(Long stuNo)
    {
        this.stuNo = stuNo;
    }

    public Long getStuNo()
    {
        return stuNo;
    }
    public void setStuName(String stuName)
    {
        this.stuName = stuName;
    }

    public String getStuName()
    {
        return stuName;
    }
    public void setStuSex(Integer stuSex)
    {
        this.stuSex = stuSex;
    }

    public Integer getStuSex()
    {
        return stuSex;
    }
    public void setStuBirth(Date stuBirth)
    {
        this.stuBirth = stuBirth;
    }

    public Date getStuBirth()
    {
        return stuBirth;
    }
    public void setStuNationId(Long stuNationId)
    {
        this.stuNationId = stuNationId;
    }

    public Long getStuNationId()
    {
        return stuNationId;
    }
    public void setStuNid(String stuNid)
    {
        this.stuNid = stuNid;
    }

    public String getStuNid()
    {
        return stuNid;
    }
    public void setStuEnrollYear(Integer stuEnrollYear)
    {
        this.stuEnrollYear = stuEnrollYear;
    }

    public Integer getStuEnrollYear()
    {
        return stuEnrollYear;
    }
    public void setGradeClassId(Long gradeClassId)
    {
        this.gradeClassId = gradeClassId;
    }

    public Long getGradeClassId()
    {
        return gradeClassId;
    }
    public void setStuPhone(String stuPhone)
    {
        this.stuPhone = stuPhone;
    }

    public String getStuPhone()
    {
        return stuPhone;
    }
    public void setStuWechat(String stuWechat)
    {
        this.stuWechat = stuWechat;
    }

    public String getStuWechat()
    {
        return stuWechat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stuId", getStuId())
            .append("stuNo", getStuNo())
            .append("stuName", getStuName())
            .append("stuSex", getStuSex())
            .append("stuBirth", getStuBirth())
            .append("stuNationId", getStuNationId())
            .append("stuNid", getStuNid())
            .append("stuEnrollYear", getStuEnrollYear())
            .append("gradeClassId", getGradeClassId())
            .append("stuPhone", getStuPhone())
            .append("stuWechat", getStuWechat())
            .toString();
    }
}
