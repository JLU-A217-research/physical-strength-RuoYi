package com.ruoyi.project.system.info.service.impl;

import com.ruoyi.project.system.info.domain.ClassGradeData;
import com.ruoyi.project.system.info.mapper.ClassGradeDataMapper;
import com.ruoyi.project.system.info.service.ClassGradeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("classGrade")
public class ClassGradeDataServiceImpl implements ClassGradeDataService {

    @Autowired
    ClassGradeDataMapper classGradeDataMapper;

    @Override
    public List<ClassGradeData> selectClassGradeDataList() {
        return classGradeDataMapper.selectClassGradeDataByType();
    }
}
