package com.ruoyi.project.system.teacher.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 教师信息 对象 prsn_teacher
 *
 * @author ruoyi
 * @date 2021-03-22
 */
public class TeaInfo  extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教师ID */
    private Long  teacherId;

    /** 教师号 */
    @Excel(name = "教师号")
    private Long teacherNo;

    /** 教师姓名 */
    @Excel(name = "教师姓名")
    private String teacherName;

    /** 教师性别ID（字典） */
    @Excel(name = "教师性别ID", readConverterExp = "字=典")
    private String teacherSex;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String teacherNid;

    /** 职务ID（字典） */
    @Excel(name = "职务ID", readConverterExp = "字=典")
    private Long teacherJobId;

    public String getTeacherJobName() {
        return teacherJobName;
    }

    public void setTeacherJobName(String teacherJobName) {
        this.teacherJobName = teacherJobName;
    }

    /** 职务名字（字典） */
    @Excel(name = "职务名称")
    private String teacherJobName;

    //章荣荣添加的getEycg和setEycg
    public int getEycg() {
        return eycg;
    }

    public void setEycg(int eycg) {
        this.eycg = eycg;
    }

    private String eycgstring;

    public String getEycgstring() {
        return eycgstring;
    }

    public void setEycgstring(String eycgstring) {
        this.eycgstring = eycgstring;
    }

    /** 管理班级 **/
    @Excel(name="管理班级")
    private int eycg;

    public int getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(int enrollYear) {
        this.enrollYear = enrollYear;
    }

    private int enrollYear;

    public String getEnrollYearString() {
        return enrollYearString;
    }

    public void setEnrollYearString(String enrollYearString) {
        this.enrollYearString = enrollYearString;
    }

    //    private List classGrade;
    private String enrollYearString;

    /** 教师电话 */
    @Excel(name = "教师电话")
    private String teacherPhone;

    /** 教师邮箱 */
    @Excel(name = "教师邮箱")
    private String teacherEmail;

    /** 教师微信 */
    @Excel(name = "教师微信")
    private String teacherWechat;

    public void setTeacherId(Long teacherId)
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId()
    {
        return teacherId;
    }
    public void setTeacherNo(Long teacherNo)
    {
        this.teacherNo = teacherNo;
    }

    public Long getTeacherNo()
    {
        return teacherNo;
    }
    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName()
    {
        return teacherName;
    }
    public void setTeacherSex(String teacherSex)
    {
        this.teacherSex = teacherSex;
    }

    public String getTeacherSex()
    {
        return teacherSex;
    }
    public void setTeacherNid(String teacherNid)
    {
        this.teacherNid = teacherNid;
    }

    public String getTeacherNid()
    {
        return teacherNid;
    }
    public void setTeacherJobId(Long teacherJobId)
    {
        this.teacherJobId = teacherJobId;
    }

    public Long getTeacherJobId()
    {
        return teacherJobId;
    }
    public void setTeacherPhone(String teacherPhone)
    {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherPhone()
    {
        return teacherPhone;
    }
    public void setTeacherEmail(String teacherEmail)
    {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherEmail()
    {
        return teacherEmail;
    }
    public void setTeacherWechat(String teacherWechat)
    {
        this.teacherWechat = teacherWechat;
    }

    public String getTeacherWechat()
    {
        return teacherWechat;
    }
    public int  getClassGrade() {
        return eycg;
    }

    public void setClassGrade(int eycg) {
        this.eycg = eycg;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("teacherId", getTeacherId())
                .append("teacherNo", getTeacherNo())
                .append("teacherName", getTeacherName())
                .append("teacherSex", getTeacherSex())
                .append("teacherNid", getTeacherNid())
                .append("teacherJobId", getTeacherJobId())
                .append("eycg",getClassGrade())
                .append("eycgstring",getEycgstring())
                .append("teacherPhone", getTeacherPhone())
                .append("teacherEmail", getTeacherEmail())
                .append("teacherWechat", getTeacherWechat())
                .append("enrollYear",getEnrollYear())
                .append("enrollYearString",getEnrollYearString())
                .toString();
    }


}
