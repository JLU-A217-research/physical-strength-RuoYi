package com.ruoyi.project.system.absence_submit.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 请假信息 对象 absence_info
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public class AbsenceSubmit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 请假信息ID */
    private Long absenceInfoId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long stuId;

    /** 申请请假时间 */
    @Excel(name = "申请请假时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date absenceRequestTime;

    /** 请假日期 */
    @Excel(name = "请假日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date absenceDate;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String handleStatus;

    @Override
    public String toString() {
        return "AbsenceSubmit{" +
                "absenceInfoId=" + absenceInfoId +
                ", stuId=" + stuId +
                ", absenceRequestTime=" + absenceRequestTime +
                ", absenceDate=" + absenceDate +
                ", handleStatus='" + handleStatus + '\'' +
                ", absenceReason='" + absenceReason + '\'' +
                '}';
    }


    /** 请假理由 */
    @Excel(name = "请假理由")
    private String absenceReason;

    public void setAbsenceInfoId(Long absenceInfoId)
    {
        this.absenceInfoId = absenceInfoId;
    }

    public Long getAbsenceInfoId()
    {
        return absenceInfoId;
    }
    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }
    public void setAbsenceRequestTime(Date absenceRequestTime)
    {
        this.absenceRequestTime = absenceRequestTime;
    }

    public Date getAbsenceRequestTime()
    {
        return absenceRequestTime;
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
    public void setAbsenceReason(String absenceReason)
    {
        this.absenceReason = absenceReason;
    }

    public String getAbsenceReason()
    {
        return absenceReason;
    }

}
