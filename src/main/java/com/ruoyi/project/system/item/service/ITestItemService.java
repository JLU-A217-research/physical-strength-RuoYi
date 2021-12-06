package com.ruoyi.project.system.item.service;

import com.ruoyi.project.system.item.domain.TestItem;

import java.util.List;

/**
 * 体测项目 Service接口
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
public interface ITestItemService 
{
    /**
     * 查询体测项目 
     * 
     * @param testItemId 体测项目 ID
     * @return 体测项目 
     */
    public TestItem selectTestItemById(Long testItemId);

    /**
     * 查询体测项目 列表
     * 
     * @param testItem 体测项目 
     * @return 体测项目 集合
     */
    public List<TestItem> selectTestItemList(TestItem testItem);

    /*
    通过体测记录id查询体测项目 列表
     */
    public List<TestItem> selectTestItemByTestRecordId(Long testRecordId);

    /*
    查询所有体测项目 列表
     */
    public List<TestItem> selectTestItemAll();

    /**
     * 新增体测项目 
     * 
     * @param testItem 体测项目 
     * @return 结果
     */
    public int insertTestItem(TestItem testItem);

    /**
     * 修改体测项目 
     * 
     * @param testItem 体测项目 
     * @return 结果
     */
    public int updateTestItem(TestItem testItem);

    /**
     * 批量删除体测项目 
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestItemByIds(String ids);

    /**
     * 删除体测项目 信息
     * 
     * @param testItemId 体测项目 ID
     * @return 结果
     */
    public int deleteTestItemById(Long testItemId);

    /*
    通过项目id查询项目使用数量
     */
    public int countTestRecordItemById(Long testItemId);
}
