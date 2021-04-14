package com.ruoyi.project.system.teacher.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.List;

/**
 * 教师信息 对象 prsn_teacher
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
public class PrsnTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教师ID */
    private long  teacherId;

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

    /** 管理班级 **/
    @Excel(name="管理班级")
    private int eycg;
//    private List classGrade;

    /** 教师电话 */
    @Excel(name = "教师电话")
    private String teacherPhone;

    /** 教师邮箱 */
    @Excel(name = "教师邮箱")
    private String teacherEmail;

    /** 教师微信 */
    @Excel(name = "教师微信")
    private String teacherWechat;

    public void setTeacherId(int teacherId)
    {
        this.teacherId = teacherId;
    }

    public long getTeacherId()
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

            .append("teacherPhone", getTeacherPhone())
            .append("teacherEmail", getTeacherEmail())
            .append("teacherWechat", getTeacherWechat())
            .toString();
    }


}
