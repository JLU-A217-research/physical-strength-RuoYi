package com.ruoyi.project.system.CAG.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 部门表 sys_dept
 * 
 * @author ruoyi
 */
public class CAG extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门ID */
    private Long gradeClassId;

    /** 父部门ID */
    private Long classGrade;

    private Long enrollYear;

    public Long getEnrollYear() {
        return enrollYear;
    }

    @Override
    public String toString() {
        return "CAG{" +
                "gradeClassId=" + gradeClassId +
                ", classGrade=" + classGrade +
                ", enrollYear=" + enrollYear +
                ", ancestors='" + ancestors + '\'' +
                ", classNo=" + classNo +
                ", orderNum='" + orderNum + '\'' +
                ", leader='" + leader + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", parentName='" + parentName + '\'' +
                '}';
    }

    public void setEnrollYear(Long enrollYear) {
        this.enrollYear = enrollYear;
    }

    /** 祖级列表 */
    private String ancestors;

    /** 部门名称 */
    private Long classNo;

    public Long getGradeClassId() {
        return gradeClassId;
    }

    public void setGradeClassId(Long gradeClassId) {
        this.gradeClassId = gradeClassId;
    }

    public Long getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Long classGrade) {
        this.classGrade = classGrade;
    }

    public Long getClassNo() {
        return classNo;
    }

    public void setClassNo(Long classNo) {
        this.classNo = classNo;
    }

    /** 显示顺序 */
    private String orderNum;

    /** 负责人 */
    private String leader;

    /** 联系电话 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 部门状态:0正常,1停用 */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 父部门名称 */
    private String parentName;



    public String getAncestors()
    {
        return ancestors;
    }

    public void setAncestors(String ancestors)
    {
        this.ancestors = ancestors;
    }



    @NotBlank(message = "显示顺序不能为空")
    public String getOrderNum()
    {
        return orderNum;
    }

    public void setOrderNum(String orderNum)
    {
        this.orderNum = orderNum;
    }

    public String getLeader()
    {
        return leader;
    }

    public void setLeader(String leader)
    {
        this.leader = leader;
    }

    @Size(min = 0, max = 11, message = "联系电话长度不能超过11个字符")
    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getParentName()
    {
        return parentName;
    }

    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }

}
