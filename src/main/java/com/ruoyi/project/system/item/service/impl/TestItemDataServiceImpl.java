package com.ruoyi.project.system.item.service.impl;

import com.ruoyi.project.system.item.domain.TestItemData;
import com.ruoyi.project.system.item.mapper.TestItemDataMapper;
import com.ruoyi.project.system.item.service.TestItemDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testItemId")
public class TestItemDataServiceImpl implements TestItemDataService {

    @Autowired
    TestItemDataMapper testItemDataMapper;

    @Override
    public List<TestItemData> selectTestItemDataList() {
        return testItemDataMapper.selectTestItemDataByType();
    }
}
