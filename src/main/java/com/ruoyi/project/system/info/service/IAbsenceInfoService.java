package com.ruoyi.project.system.info.service;

import com.ruoyi.project.system.info.domain.AbsenceInfo;

import java.util.List;

/**
 * 请假信息 Service接口
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public interface IAbsenceInfoService 
{
    /**
     * 查询请假信息 
     * 
     * @param absenceInfoId 请假信息 ID
     * @return 请假信息 
     */
    public AbsenceInfo selectAbsenceInfoById(Long absenceInfoId);

    /**
     * 查询请假信息 列表
     * 
     * @param absenceInfo 请假信息 
     * @return 请假信息 集合
     */
    public List<AbsenceInfo> selectAbsenceInfoList(AbsenceInfo absenceInfo);

    /**
     * 新增请假信息 
     * 
     * @param absenceInfo 请假信息 
     * @return 结果
     */
    public int insertAbsenceInfo(AbsenceInfo absenceInfo);

    /**
     * 修改请假信息 
     * 
     * @param absenceInfo 请假信息 
     * @return 结果
     */
    public int updateAbsenceInfo(AbsenceInfo absenceInfo);

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
}
