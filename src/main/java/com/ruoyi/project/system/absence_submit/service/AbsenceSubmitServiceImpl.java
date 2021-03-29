package com.ruoyi.project.system.absence_submit.service;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.absence_submit.domain.AbsenceSubmit;
import com.ruoyi.project.system.absence_submit.mapper.AbsenceSubmitMapper;
import com.ruoyi.project.system.common.domain.ClassGradeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 请假信息 Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
@Service
public class AbsenceSubmitServiceImpl implements IAbsenceSubmitService
{
    @Autowired
    private AbsenceSubmitMapper absenceSubmitMapper;

    /**
     * 查询请假信息 
     * 
     * @param absenceInfoId 请假信息 ID
     * @return 请假信息 
     */
    @Override
    public AbsenceSubmit selectAbsenceInfoById(Long absenceInfoId)
    {
        return absenceSubmitMapper.selectAbsenceInfoById(absenceInfoId);
    }

    /**
     * 查询请假信息 列表
     * 
     * @param absenceSubmit 请假信息
     * @return 请假信息 
     */
    @Override
    public List<AbsenceSubmit> selectAbsenceInfoList(AbsenceSubmit absenceSubmit)
    {
        return absenceSubmitMapper.selectAbsenceInfoList(absenceSubmit);
    }

    /**
     * 新增请假信息 
     * 
     * @param absenceSubmit 请假信息
     * @return 结果
     */
    @Override
    public int insertAbsenceSubmit(AbsenceSubmit absenceSubmit)
    {
        return absenceSubmitMapper.insertAbsenceSubmit(absenceSubmit);
    }

    /**
     * 修改请假信息 
     * 
     * @param absenceSubmit 请假信息
     * @return 结果
     */
    @Override
    public int updateAbsenceSubmit(AbsenceSubmit absenceSubmit)
    {
        return absenceSubmitMapper.updateAbsenceSubmit(absenceSubmit);
    }

    /**
     * 删除请假信息 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAbsenceInfoByIds(String ids)
    {
        return absenceSubmitMapper.deleteAbsenceInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除请假信息 信息
     * 
     * @param absenceInfoId 请假信息 ID
     * @return 结果
     */
    @Override
    public int deleteAbsenceInfoById(Long absenceInfoId)
    {
        return absenceSubmitMapper.deleteAbsenceInfoById(absenceInfoId);
    }


    public int changeStatus(AbsenceSubmit absenceSubmit)
    {
        return absenceSubmitMapper.updateAbsenceSubmit(absenceSubmit);
    }

    public List<ClassGradeData> getClass(ClassGradeData classGradeData){
        return absenceSubmitMapper.getClass(classGradeData);
    }
}
