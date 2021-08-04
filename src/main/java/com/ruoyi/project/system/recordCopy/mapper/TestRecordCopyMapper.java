package com.ruoyi.project.system.recordCopy.mapper;

import com.ruoyi.project.system.recordCopy.domain.TestRecordCopy;

import java.util.List;

/**
 * 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public interface TestRecordCopyMapper
{
    /**
     * 查询测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordId 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）ID
     * @return 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    public TestRecordCopy selectTestRecordCopyById(Long testRecordId);

    /**
     * 查询测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）列表
     * 
     * @param testRecordCopy 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）集合
     */
    public List<TestRecordCopy> selectTestRecordCopyList(TestRecordCopy testRecordCopy);

    /**
     * 新增测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordCopy 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 结果
     */
    public int insertTestRecordCopy(TestRecordCopy testRecordCopy);

    /**
     * 修改测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordCopy 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 结果
     */
    public int updateTestRecordCopy(TestRecordCopy testRecordCopy);

    /**
     * 删除测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordId 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）ID
     * @return 结果
     */
    public int deleteTestRecordCopyById(Long testRecordId);

    /**
     * 批量删除测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestRecordCopyByIds(String[] testRecordIds);
}
