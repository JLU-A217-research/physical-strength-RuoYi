package com.ruoyi.project.system.item.mapper;

import com.ruoyi.project.system.item.domain.TestItemData;

import java.util.List;

/**
 * 字典表 数据层
 * 
 * @author ruoyi
 */
public interface TestItemDataMapper
{

    public List<TestItemData> selectTestItemDataByType();

}
