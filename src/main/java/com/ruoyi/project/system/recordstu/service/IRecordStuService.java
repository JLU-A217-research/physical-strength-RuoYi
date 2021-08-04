package com.ruoyi.project.system.recordstu.service;

import com.ruoyi.project.system.recordstu.domain.RecordStu;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-07-26
 */
public interface IRecordStuService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param testRecordId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public RecordStu selectRecordStuById(String testRecordId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param recordStu 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RecordStu> selectRecordStuList(RecordStu recordStu);

    /**
     * 新增【请填写功能名称】
     * 
     * @param recordStu 【请填写功能名称】
     * @return 结果
     */
    public int insertRecordStu(RecordStu recordStu);

    /**
     * 修改【请填写功能名称】
     * 
     * @param recordStu 【请填写功能名称】
     * @return 结果
     */
    public int updateRecordStu(RecordStu recordStu);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecordStuByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param testRecordId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRecordStuById(String testRecordId);
}
