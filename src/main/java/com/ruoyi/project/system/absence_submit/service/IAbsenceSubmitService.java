package com.ruoyi.project.system.absence_submit.service;

import com.ruoyi.project.system.absence_submit.domain.AbsenceSubmit;
import com.ruoyi.project.system.info.domain.ClassGradeData;

import java.util.List;

/**
 * 请假申请信息 Service接口
 * 
 * @author wyf
 * @date 2021-03-21
 */
public interface IAbsenceSubmitService
{
    /**
     * 查询请假申请信息
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
     * 批量删除请假信息 
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAbsenceInfoByIds(String ids);

    /**
     * 删除请假信息 信息
     * 
     * @param absenceInfoId 请假信息 ID
     * @return 结果
     */
    public int deleteAbsenceInfoById(Long absenceInfoId);


    public int changeStatus(AbsenceSubmit absenceSubmit);

    public List<ClassGradeData> getClass(ClassGradeData classGradeData);
}
