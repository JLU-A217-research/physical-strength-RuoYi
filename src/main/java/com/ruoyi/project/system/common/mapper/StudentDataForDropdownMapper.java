package com.ruoyi.project.system.common.mapper;

import com.ruoyi.project.system.common.domain.StudentDataForDropdown;

import java.util.List;

/**
 * 下拉菜单
 * 学生信息表 数据层
 *
 * @author ruoyi
 */

public interface StudentDataForDropdownMapper {

    public List<StudentDataForDropdown> selectStudentDataForDropdownByNo();
}
