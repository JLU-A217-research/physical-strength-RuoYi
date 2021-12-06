package com.ruoyi.project.system.standard.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.standard.domain.TestStandard;
import com.ruoyi.project.system.standard.mapper.TestStandardMapper;
import com.ruoyi.project.system.standard.service.ITestStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 测试指标 Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-29
 */
@Service
public class TestStandardServiceImpl implements ITestStandardService 
{
    @Autowired
    private TestStandardMapper testStandardMapper;

    /**
     * 查询测试指标 
     * 
     * @param testStandardId 测试指标 ID
     * @return 测试指标 
     */
    @Override
    public TestStandard selectTestStandardById(Long testStandardId)
    {
        return testStandardMapper.selectTestStandardById(testStandardId);
    }

    /**
     * 查询测试指标 列表
     * 
     * @param testStandard 测试指标 
     * @return 测试指标 
     */
    @Override
    public List<TestStandard> selectTestStandardList(TestStandard testStandard)
    {

        return testStandardMapper.selectTestStandardList(testStandard);
    }

    /**
     * 新增测试指标 
     * 
     * @param testStandard 测试指标 
     * @return 结果
     */
    @Override
    public int insertTestStandard(TestStandard testStandard)
    {

        TestStandard testStandardk1=testStandardMapper.selectTgsId(testStandard);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+testStandardk1.getTgsId());
        testStandard.setTgsId(testStandardk1.getTgsId());
        return testStandardMapper.insertTestStandard(testStandard);
    }

    /**
     * 修改测试指标 
     * 
     * @param testStandard 测试指标 
     * @return 结果
     */
    @Override
    public int updateTestStandard(TestStandard testStandard)
    {
        return testStandardMapper.updateTestStandard(testStandard);
    }

    /**
     * 删除测试指标 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestStandardByIds(String ids)
    {
        return testStandardMapper.deleteTestStandardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试指标 信息
     * 
     * @param testStandardId 测试指标 ID
     * @return 结果
     */
    @Override
    public int deleteTestStandardById(Long testStandardId)
    {
        return testStandardMapper.deleteTestStandardById(testStandardId);
    }



}
