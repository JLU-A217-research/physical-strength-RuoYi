package com.ruoyi.project.system.info.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 请假信息 对象 absence_info
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public class AbsenceSelect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生号 */
    @Excel(name = "学生号")
    private Long stuNo;

    private Long classNo;

    public Long getClassNo() {
        return classNo;
    }

    public void setClassNo(Long classNo) {
        this.classNo = classNo;
    }

    private Long classGrade;

    @Override
    public String toString() {
        return "AbsenceSelect{" +
                "stuNo=" + stuNo +
                ", classNo=" + classNo +
                ", classGrade=" + classGrade +
                ", absenceDate=" + absenceDate +
                ", handleStatus='" + handleStatus + '\'' +
                '}';
    }

    public Long getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Long classGrade) {
        this.classGrade = classGrade;
    }

    /** 请假日期 */
    @Excel(name = "请假日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date absenceDate;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String handleStatus;

    public Long getStuNo() {
        return stuNo;
    }

    public void setStuNo(Long stuNo) {
        this.stuNo = stuNo;
    }




    public void setAbsenceDate(Date absenceDate)
    {
        this.absenceDate = absenceDate;
    }

    public Date getAbsenceDate()
    {
        return absenceDate;
    }
    public void setHandleStatus(String handleStatus)
    {
        this.handleStatus = handleStatus;
    }

    public String getHandleStatus()
    {
        return handleStatus;
    }

}
