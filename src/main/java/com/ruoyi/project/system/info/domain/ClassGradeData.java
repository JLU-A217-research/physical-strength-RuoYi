package com.ruoyi.project.system.info.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 字典数据表 sys_dict_data
 * 
 * @author ruoyi
 */
public class ClassGradeData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long classGrade;

    private Long ClassNo;

    public Long getClassNo() {
        return ClassNo;
    }

    @Override
    public String toString() {
        return "ClassGradeData{" +
                "classGrade=" + classGrade +
                ", ClassNo=" + ClassNo +
                '}';
    }

    public void setClassNo(Long classNo) {
        ClassNo = classNo;
    }

    public Long getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Long classGrade) {
        this.classGrade = classGrade;
    }
}
