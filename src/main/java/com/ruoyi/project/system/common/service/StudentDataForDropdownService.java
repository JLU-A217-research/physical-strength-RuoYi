package com.ruoyi.project.system.common.service;


import com.ruoyi.project.system.common.domain.StudentDataForDropdown;

import java.util.List;


/**
 * 下拉菜单
 * 学生信息 业务层
 *
 * @author ruoyi
 */
public interface StudentDataForDropdownService {

    public List<StudentDataForDropdown> selectStudentDataForDropdownList();
}
