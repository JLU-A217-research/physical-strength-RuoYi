package com.ruoyi.project.system.info.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.info.domain.AbsenceInfo;
import com.ruoyi.project.system.info.mapper.AbsenceInfoMapper;
import com.ruoyi.project.system.info.service.IAbsenceInfoService;
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
public class AbsenceInfoServiceImpl implements IAbsenceInfoService 
{
    @Autowired
    private AbsenceInfoMapper absenceInfoMapper;

    /**
     * 查询请假信息 
     * 
     * @param absenceInfoId 请假信息 ID
     * @return 请假信息 
     */
    @Override
    public AbsenceInfo selectAbsenceInfoById(Long absenceInfoId)
    {
        return absenceInfoMapper.selectAbsenceInfoById(absenceInfoId);
    }

    /**
     * 查询请假信息 列表
     * 
     * @param absenceInfo 请假信息 
     * @return 请假信息 
     */
    @Override
    public List<AbsenceInfo> selectAbsenceInfoList(AbsenceInfo absenceInfo)
    {
        return absenceInfoMapper.selectAbsenceInfoList(absenceInfo);
    }

    /**
     * 新增请假信息 
     * 
     * @param absenceInfo 请假信息 
     * @return 结果
     */
    @Override
    public int insertAbsenceInfo(AbsenceInfo absenceInfo)
    {
        return absenceInfoMapper.insertAbsenceInfo(absenceInfo);
    }

    /**
     * 修改请假信息 
     * 
     * @param absenceInfo 请假信息 
     * @return 结果
     */
    @Override
    public int updateAbsenceInfo(AbsenceInfo absenceInfo)
    {
        return absenceInfoMapper.updateAbsenceInfo(absenceInfo);
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
        return absenceInfoMapper.deleteAbsenceInfoByIds(Convert.toStrArray(ids));
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
        return absenceInfoMapper.deleteAbsenceInfoById(absenceInfoId);
    }
}
