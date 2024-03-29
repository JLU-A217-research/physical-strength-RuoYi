package com.ruoyi.project.system.item.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.item.domain.TestItem;
import com.ruoyi.project.system.item.mapper.TestItemMapper;
import com.ruoyi.project.system.item.service.ITestItemService;
import com.ruoyi.project.system.recordCopy.mapper.TestRecordItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 体测项目 Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
@Service
public class TestItemServiceImpl implements ITestItemService 
{
    @Autowired
    private TestItemMapper testItemMapper;
    @Autowired
    private TestRecordItemMapper testRecordItemMapper;

    /**
     * 查询体测项目 
     * 
     * @param testItemId 体测项目 ID
     * @return 体测项目 
     */
    @Override
    public TestItem selectTestItemById(Long testItemId)
    {
        return testItemMapper.selectTestItemById(testItemId);
    }

    /**
     * 查询体测项目 列表
     * 
     * @param testItem 体测项目 
     * @return 体测项目 
     */
    @Override
    public List<TestItem> selectTestItemList(TestItem testItem)
    {
        return testItemMapper.selectTestItemList(testItem);
    }

    /*
    查询所有体测项目 列表
     */
    @Override
    public List<TestItem> selectTestItemAll(){
        return testItemMapper.selectTestItemAll();
    }

    /*
    根据测试记录id查询测试项目 列表
     */
    @Override
    public List<TestItem> selectTestItemByTestRecordId(Long testRecordId)
    {
        List<TestItem> testRecordItems = testItemMapper.selectTestItemByTestRecordId(testRecordId);
        List<TestItem> testItems = testItemMapper.selectTestItemAll();
        for (TestItem testItem : testItems)
        {
            for (TestItem testRecordItem : testRecordItems)
            {
                if (testItem.getTestItemId().longValue() == testRecordItem.getTestItemId().longValue())
                {
                    testItem.setFlag(true);
                    break;
                }
            }
        }
        return testItems;
    }

    /*
    通过项目id查询项目的使用数量
     */
    @Override
    public int countTestRecordItemById(Long testItemId){return testRecordItemMapper.countTestRecordItemById(testItemId);}



    /**
     * 新增体测项目 
     * 
     * @param testItem 体测项目 
     * @return 结果
     */
    @Override
    public int insertTestItem(TestItem testItem)
    {
        return testItemMapper.insertTestItem(testItem);
    }

    /**
     * 修改体测项目 
     * 
     * @param testItem 体测项目 
     * @return 结果
     */
    @Override
    public int updateTestItem(TestItem testItem)
    {
        return testItemMapper.updateTestItem(testItem);
    }

    /**
     * 删除体测项目 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestItemByIds(String ids)
    {
        return testItemMapper.deleteTestItemByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除体测项目 信息
     * 
     * @param testItemId 体测项目 ID
     * @return 结果
     */
    @Override
    public int deleteTestItemById(Long testItemId)
    {
        return testItemMapper.deleteTestItemById(testItemId);
    }

}
