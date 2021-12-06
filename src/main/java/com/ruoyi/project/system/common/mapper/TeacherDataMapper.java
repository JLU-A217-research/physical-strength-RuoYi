package com.ruoyi.project.system.common.mapper;

/*
下拉菜单
教师表 数据层
 */

import com.ruoyi.project.system.common.domain.TeacherData;

import java.util.List;

public interface TeacherDataMapper {
    public List<TeacherData> selectTeacherDataByNo();
}
