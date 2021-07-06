package com.ruoyi.project.system.absence_submit.mapper;

import com.ruoyi.project.system.absence_submit.domain.AbsenceSubmit;
import com.ruoyi.project.system.info.domain.ClassGradeData;

import java.util.List;

/**
 * 请假申请 Mapper接口
 * 
 * @author wyf
 * @date 2021-03-21
 */
public interface AbsenceSubmitMapper
{
    /**
     * 查询请假信息 
     * 
     * @param absenceInfoId 请假信息 ID
     * @return 请假信息 
     */
    public AbsenceSubmit selectAbsenceInfoById(Long absenceInfoId);

    /**
     * 查询请假信息 列表
     * 
     * @param absenceSubmit 请假信息
     * @return 请假信息 集合
     */
    public List<AbsenceSubmit> selectAbsenceInfoList(AbsenceSubmit absenceSubmit);

    /**
     * 新增请假信息 
     * 
     * @param absenceSubmit 请假信息
     * @return 结果
     */
    public int insertAbsenceSubmit(AbsenceSubmit absenceSubmit);

    /**
     * 修改请假信息 
     * 
     * @param absenceSubmit 请假信息
     * @return 结果
     */
    public int updateAbsenceSubmit(AbsenceSubmit absenceSubmit);

    /**
     * 删除请假信息 
     * 
     * @param absenceInfoId 请假信息 ID
     * @return 结果
     */
    public int deleteAbsenceInfoById(Long absenceInfoId);

    /**
     * 批量删除请假信息 
     * 
     * @param absenceInfoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAbsenceInfoByIds(String[] absenceInfoIds);


    public List<ClassGradeData> getClass(ClassGradeData classGradeData);
}
