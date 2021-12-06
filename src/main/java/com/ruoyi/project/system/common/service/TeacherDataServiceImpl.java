package com.ruoyi.project.system.common.service;

import com.ruoyi.project.system.common.domain.TeacherData;
import com.ruoyi.project.system.common.mapper.TeacherDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherId")
public class TeacherDataServiceImpl implements TeacherDataService {
    @Autowired
    TeacherDataMapper teacherDataMapper;

    @Override
    public List<TeacherData> selectTeacherDataList(){
        return teacherDataMapper.selectTeacherDataByNo();
    }
}
