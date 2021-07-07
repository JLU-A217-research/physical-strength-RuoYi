package com.ruoyi.project.system.common.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 字典数据表 sys_dict_data
 * 
 * @author ruoyi
 */
public class TeacherData extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    private Long teacherId;

    private String teacherName;


    public Long getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }



    @Override
    public String toString() {
        return "TeacherData{" +
                "Name: " + teacherName +
                ", ID: " + teacherId +
                '}';
    }
}
