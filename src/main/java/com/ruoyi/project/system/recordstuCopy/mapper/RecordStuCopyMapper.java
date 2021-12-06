package com.ruoyi.project.system.recordstuCopy.mapper;

import com.ruoyi.project.system.recordstuCopy.domain.RecordStuCopy;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-26
 */
public interface RecordStuCopyMapper
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param testRecordId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public RecordStuCopy selectRecordStuById(Long testStuId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param recordStuCopy 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RecordStuCopy> selectRecordStuList(RecordStuCopy recordStuCopy);

    /**
     * 新增【请填写功能名称】
     * 
     * @param recordStu 【请填写功能名称】
     * @return 结果
     */
    public int insertRecordStu(RecordStuCopy recordStuCopy);

    /**
     * 修改【请填写功能名称】
     * 
     * @param recordStu 【请填写功能名称】
     * @return 结果
     */
    public int updateRecordStu(RecordStuCopy recordStuCopy);

    /**
     * 删除【请填写功能名称】
     * 
     * @param testRecordId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRecordStuById(String testRecordId,String stuId,String testItemId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param testRecordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecordStuByIds(String[] testRecordIds);

    public int updateTestStu(RecordStuCopy recordStuCopy);
}
