package com.ruoyi.project.system.record.mapper;

import com.ruoyi.project.system.record.domain.TestRecord;

import java.util.List;

/**
 * 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public interface TestRecordMapper 
{
    /**
     * 查询测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordId 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）ID
     * @return 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
//    public TestRecord selectTestRecordById(Long testRecordId);
    public TestRecord selectTestRecordById(Long testRecordId);

    /**
     * 查询测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）列表
     * 
     * @param testRecord 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）集合
     */
    public List<TestRecord> selectTestRecordList(TestRecord testRecord);

    /**
     * 新增测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecord 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 结果
     */
    public int insertTestRecord(TestRecord testRecord);

    /**
     * 修改测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecord 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * @return 结果
     */
    public int updateTestRecord(TestRecord testRecord);

    /**
     * 删除测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordId 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）ID
     * @return 结果
     */
    public int deleteTestRecordById(Long testRecordId);

    /**
     * 批量删除测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     * 
     * @param testRecordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestRecordByIds(String[] testRecordIds);
}
