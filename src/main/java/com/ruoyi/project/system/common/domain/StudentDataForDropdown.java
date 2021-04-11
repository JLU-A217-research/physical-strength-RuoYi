package com.ruoyi.project.system.common.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 下拉菜单
 * 学生信息数据表 prsn_student
 *
 * @author ruoyi
 */
public class StudentDataForDropdown extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 学生ID */
    private Long stuId;

    /** 学生号 */
    private Long stuNo;

    /** 学生姓名 */
    private String stuName;

    /** 学生性别ID（字典） */
    private String stuSex;

    /** 入学年份 */
    private Integer stuEnrollYear;

    /** 年班ID */
    private Long gradeClassId;


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
    public void setStuSex(String stuSex)
    {
        this.stuSex = stuSex;
    }

    public String getStuSex()
    {
        return stuSex;
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

    @Override
    public String toString() {
        return "StudentDataForDropdown{" +
                "stuId=" + stuId +
                ", stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuEnrollYear=" + stuEnrollYear +
                ", gradeClassId=" + gradeClassId +
                '}';
    }
}
