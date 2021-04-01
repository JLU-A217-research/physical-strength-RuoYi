package com.ruoyi.project.system.common.service;

import com.ruoyi.project.system.common.domain.ClassGradeData;
import com.ruoyi.project.system.common.mapper.ClassGradeDataMapper;
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
