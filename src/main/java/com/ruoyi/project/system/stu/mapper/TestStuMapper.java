package com.ruoyi.project.system.stu.mapper;

import com.ruoyi.project.system.stu.domain.TestStu;

import java.util.List;

/**
 * 测试学生列 Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-16
 */
public interface TestStuMapper 
{
    /**
     * 查询测试学生列 
     * 
     * @param testStuId 测试学生列 ID
     * @return 测试学生列 
     */
    public TestStu selectTestStuById(Long testStuId);

    /**
     * 查询测试学生列 列表
     * 
     * @param testStu 测试学生列 
     * @return 测试学生列 集合
     */
    public List<TestStu> selectTestStuList(TestStu testStu);

    /**
     * 新增测试学生列 
     * 
     * @param testStu 测试学生列 
     * @return 结果
     */
    public int insertTestStu(TestStu testStu);

    /**
     * 修改测试学生列 
     * 
     * @param testStu 测试学生列 
     * @return 结果
     */
    public int updateTestStu(TestStu testStu);

    /**
     * 删除测试学生列 
     * 
     * @param testStuId 测试学生列 ID
     * @return 结果
     */
    public int deleteTestStuById(Long testStuId);

    /**
     * 批量删除测试学生列 
     * 
     * @param testStuIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestStuByIds(String[] testStuIds);
}
