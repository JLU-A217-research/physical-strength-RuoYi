package com.ruoyi.project.classmanagement.classmanage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 年班信息对象 class_grade_info
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
public class ClassGradeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 年班ID */
    private Long gradeClassId;

    /** 入学年份 */
    @Excel(name = "入学年份")
    private Integer enrollYear;

    /** 年级（计算） 由入学年份和年级范围计算 */
    @Excel(name = "年级", readConverterExp = "计=算")
    private Long classGrade;

    /** 班级号 */
    @Excel(name = "班级号 ")
    private Long classNo;

    /** 班主任ID */
    @Excel(name = "班主任ID")
    private Long mainTeacherId;

    /** 班主任 */
    @Excel(name = "班主任")
    private String mainTeacherName;

    /** 体育老师ID */
    @Excel(name = "体育老师ID")
    private Long phyTeacherId;

    /** 体育老师 */
    @Excel(name = "体育老师")
    private String phyTeacherName;

    /** 班级学生人数 */
    @Excel(name = "班级学生人数")
    private Long classStuCnt;

    public void setGradeClassId(Long gradeClassId)
    {
        this.gradeClassId = gradeClassId;
    }

    public Long getGradeClassId()
    {
        return gradeClassId;
    }
    public void setEnrollYear(Integer enrollYear)
    {
        this.enrollYear = enrollYear;
    }

    public Integer getEnrollYear()
    {
        return enrollYear;
    }
    public void setClassGrade(Long classGrade)
    {
        this.classGrade = classGrade;
    }

    public Long getClassGrade()
    {
        return classGrade;
    }
    public void setClassNo(Long classNo)
    {
        this.classNo = classNo;
    }

    public Long getClassNo()
    {
        return classNo;
    }
    public void setMainTeacherId(Long mainTeacherId)
    {
        this.mainTeacherId = mainTeacherId;
    }

    public Long getMainTeacherId()
    {
        return mainTeacherId;
    }
    public String getMainTeacherName() {
        return mainTeacherName;
    }

    public void setMainTeacherName(String mainTeacherName) {
        this.mainTeacherName = mainTeacherName;
    }

    public String getPhyTeacherName() {
        return phyTeacherName;
    }

    public void setPhyTeacherName(String phyTeacherName) {
        this.phyTeacherName = phyTeacherName;
    }
    public void setPhyTeacherId(Long phyTeacherId)
    {
        this.phyTeacherId = phyTeacherId;
    }


    public Long getPhyTeacherId()
    {
        return phyTeacherId;
    }
    public void setClassStuCnt(Long classStuCnt)
    {
        this.classStuCnt = classStuCnt;
    }

    public Long getClassStuCnt()
    {
        return classStuCnt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gradeClassId", getGradeClassId())
            .append("enrollYear", getEnrollYear())
            .append("classGrade", getClassGrade())
            .append("classNo",getClassNo())
            .append("mainTeacherId", getMainTeacherId())
            .append("mainTeacherName", getMainTeacherName())
            .append("phyTeacherId", getPhyTeacherId())
            .append("phyTeacherName", getPhyTeacherName())
            .append("classStuCnt", getClassStuCnt())
            .toString();
    }
}
