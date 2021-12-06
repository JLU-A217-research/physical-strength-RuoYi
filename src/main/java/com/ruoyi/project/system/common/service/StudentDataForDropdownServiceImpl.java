package com.ruoyi.project.system.common.service;


import com.ruoyi.project.system.common.domain.StudentDataForDropdown;
import com.ruoyi.project.system.common.mapper.StudentDataForDropdownMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stuId")
public class StudentDataForDropdownServiceImpl implements StudentDataForDropdownService{

    @Autowired
    StudentDataForDropdownMapper studentDataForDropdownMapper;

    @Override
    public List<StudentDataForDropdown> selectStudentDataForDropdownList(){

        return studentDataForDropdownMapper.selectStudentDataForDropdownByNo();

    }
}
