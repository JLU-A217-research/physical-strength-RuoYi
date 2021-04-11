package com.ruoyi.project.system.item.mapper;

import java.util.List;
import com.ruoyi.project.system.item.domain.TestItem;

/**
 * 体测项目 Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
public interface TestItemMapper 
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
     * 删除体测项目 
     * 
     * @param testItemId 体测项目 ID
     * @return 结果
     */
    public int deleteTestItemById(Long testItemId);

    /**
     * 批量删除体测项目 
     * 
     * @param testItemIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestItemByIds(String[] testItemIds);
}
