package com.ruoyi.project.system.teacher.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 教师信息 对象 prsn_teacher
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
public class PrsnTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private boolean flag=false;

    public Long getPrsnTeacherId() {
        return prsnTeacherId;
    }

    public void setPrsnTeacherId(Long prsnTeacherId) {
        this.prsnTeacherId = prsnTeacherId;
    }

    /** 教师ID */
    private Long  prsnTeacherId;
    private Long teacherId;

    public Long getTeacherId() {
        return teacherId;
    }

    @Override
    public String toString() {
        return "PrsnTeacher{" +
                "flag=" + flag +
                ", prsnTeacherId=" + prsnTeacherId +
                ", teacherId=" + teacherId +
                ", teacherNo=" + teacherNo +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", teacherNid='" + teacherNid + '\'' +
                ", teacherJobId=" + teacherJobId +
                ", classGrade=" + classGrade +
                ", classId=" + classId +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", teacherWechat='" + teacherWechat + '\'' +
                '}';
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

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
    private Long classGrade;
//    private List classGrade;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @Excel(name = "班级ID")
    private Long classId;

    @Excel(name = "教师电话")
    private String teacherPhone;

    /** 教师邮箱 */
    @Excel(name = "教师邮箱")
    private String teacherEmail;

    /** 教师微信 */
    @Excel(name = "教师微信")
    private String teacherWechat;


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
    public Long  getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Long classGrade) {
        this.classGrade = classGrade;
    }
    public void setFlag(boolean flag){
        this.flag=flag;
    }


}
