package com.ruoyi.project.classmanagement.classmanage.mapper;

import java.util.List;
import com.ruoyi.project.classmanagement.classmanage.domain.ClassGradeInfo;

/**
 * 年班信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
public interface ClassGradeInfoMapper 
{
    /**
     * 查询年班信息
     * 
     * @param gradeClassId 年班信息ID
     * @return 年班信息
     */
    public ClassGradeInfo selectClassGradeInfoById(Long gradeClassId);

    /**
     * 查询年班信息列表
     * 
     * @param classGradeInfo 年班信息
     * @return 年班信息集合
     */
    public List<ClassGradeInfo> selectClassGradeInfoList(ClassGradeInfo classGradeInfo);

    /**
     * 新增年班信息
     * 
     * @param classGradeInfo 年班信息
     * @return 结果
     */
    public int insertClassGradeInfo(ClassGradeInfo classGradeInfo);

    /**
     * 修改年班信息
     * 
     * @param classGradeInfo 年班信息
     * @return 结果
     */
    public int updateClassGradeInfo(ClassGradeInfo classGradeInfo);

    /**
     * 删除年班信息
     * 
     * @param gradeClassId 年班信息ID
     * @return 结果
     */
    public int deleteClassGradeInfoById(Long gradeClassId);

    /**
     * 批量删除年班信息
     * 
     * @param gradeClassIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteClassGradeInfoByIds(String[] gradeClassIds);
}
