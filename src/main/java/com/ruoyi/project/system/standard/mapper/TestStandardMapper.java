package com.ruoyi.project.system.standard.mapper;

import java.util.List;
import com.ruoyi.project.system.standard.domain.TestStandard;

/**
 * 测试指标 Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-29
 */
public interface TestStandardMapper 
{
    /**
     * 查询测试指标 
     * 
     * @param testPoint 测试指标 ID
     * @return 测试指标 
     */
    public TestStandard selectTestStandardById(String testPoint);

    /**
     * 查询测试指标 列表
     * 
     * @param testStandard 测试指标 
     * @return 测试指标 集合
     */
    public List<TestStandard> selectTestStandardList(TestStandard testStandard);

    /**
     * 新增测试指标 
     * 
     * @param testStandard 测试指标 
     * @return 结果
     */
    public int insertTestStandard(TestStandard testStandard);

    /**
     * 修改测试指标 
     * 
     * @param testStandard 测试指标 
     * @return 结果
     */
    public int updateTestStandard(TestStandard testStandard);

    /**
     * 删除测试指标 
     * 
     * @param testStandardId 测试指标 ID
     * @return 结果
     */
    public int deleteTestStandardById(Long testStandardId);

    /**
     * 批量删除测试指标 
     * 
     * @param testStandardIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestStandardByIds(String[] testStandardIds);
}
