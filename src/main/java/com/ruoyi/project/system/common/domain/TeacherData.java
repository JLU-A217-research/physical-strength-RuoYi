package com.ruoyi.project.system.common.domain;

/*
下拉菜单
教师表 prsn_teacher
 */

import com.ruoyi.framework.web.domain.BaseEntity;

public class TeacherData extends BaseEntity {
    private static final long serialVersionUID = 1L;



    /*教师Id*/
    private long teacherId;


    /*教师姓名*/
    private String teacherName;


    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString(){
        return "TeacherData{"+
                "teacherId='" + teacherId + '\'' +
                ", teacherName=" + teacherName +
                '}';
    }
}
