package com.ruoyi.project.system.common.service;

import com.ruoyi.project.system.common.domain.TestData;
import com.ruoyi.project.system.common.mapper.TestDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("itemId")
public class TestDataServiceImpl implements TestDataService{
    @Autowired
    TestDataMapper testDataMapper;

    @Override
    public List<TestData> selectTestDataList(){
        return testDataMapper.selectTestDataByNo();
    }


}
