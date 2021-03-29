package com.ruoyi.project.system.common.domain;

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

    private Long ClassId;

    public Long getClassId() {
        return ClassId;
    }

    public void setClassId(Long classId) {
        ClassId = classId;
    }

    @Override
    public String toString() {
        return "ClassGradeData{" +
                "classGrade=" + classGrade +
                ", ClassId=" + ClassId +
                '}';
    }

    public Long getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Long classGrade) {
        this.classGrade = classGrade;
    }
}
