package com.ruoyi.project.system.info.mapper;

import com.ruoyi.project.system.info.domain.ClassGradeData;

import java.util.List;

/**
 * 字典表 数据层
 * 
 * @author ruoyi
 */
public interface ClassGradeDataMapper
{

    public List<ClassGradeData> selectClassGradeDataByType();

}
