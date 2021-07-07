package com.ruoyi.project.system.common.mapper;

import com.ruoyi.project.system.common.domain.TestData;

import java.util.List;

/*
下拉菜单
体测项目表 数据层
 */
public interface TestDataMapper {
    public  List<TestData> selectTestDataByNo();
}
