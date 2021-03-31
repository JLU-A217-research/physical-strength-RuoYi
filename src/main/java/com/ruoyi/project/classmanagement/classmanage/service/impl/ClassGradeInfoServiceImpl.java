package com.ruoyi.project.classmanagement.classmanage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.classmanagement.classmanage.mapper.ClassGradeInfoMapper;
import com.ruoyi.project.classmanagement.classmanage.domain.ClassGradeInfo;
import com.ruoyi.project.classmanagement.classmanage.service.IClassGradeInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 年班信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
@Service
public class ClassGradeInfoServiceImpl implements IClassGradeInfoService 
{
    @Autowired
    private ClassGradeInfoMapper classGradeInfoMapper;

    /**
     * 查询年班信息
     * 
     * @param gradeClassId 年班信息ID
     * @return 年班信息
     */
    @Override
    public ClassGradeInfo selectClassGradeInfoById(Long gradeClassId)
    {
        return classGradeInfoMapper.selectClassGradeInfoById(gradeClassId);
    }

    /**
     * 查询年班信息列表
     * 
     * @param classGradeInfo 年班信息
     * @return 年班信息
     */
    @Override
    public List<ClassGradeInfo> selectClassGradeInfoList(ClassGradeInfo classGradeInfo)
    {
        return classGradeInfoMapper.selectClassGradeInfoList(classGradeInfo);
    }

    /**
     * 新增年班信息
     * 
     * @param classGradeInfo 年班信息
     * @return 结果
     */
    @Override
    public int insertClassGradeInfo(ClassGradeInfo classGradeInfo)
    {
        return classGradeInfoMapper.insertClassGradeInfo(classGradeInfo);
    }

    /**
     * 修改年班信息
     * 
     * @param classGradeInfo 年班信息
     * @return 结果
     */
    @Override
    public int updateClassGradeInfo(ClassGradeInfo classGradeInfo)
    {
        return classGradeInfoMapper.updateClassGradeInfo(classGradeInfo);
    }

    /**
     * 删除年班信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteClassGradeInfoByIds(String ids)
    {
        return classGradeInfoMapper.deleteClassGradeInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除年班信息信息
     * 
     * @param gradeClassId 年班信息ID
     * @return 结果
     */
    @Override
    public int deleteClassGradeInfoById(Long gradeClassId)
    {
        return classGradeInfoMapper.deleteClassGradeInfoById(gradeClassId);
    }
}
