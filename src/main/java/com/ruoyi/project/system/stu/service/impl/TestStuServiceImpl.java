package com.ruoyi.project.system.stu.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.stu.domain.TestStu;
import com.ruoyi.project.system.stu.mapper.TestStuMapper;
import com.ruoyi.project.system.stu.service.ITestStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试学生列 Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-16
 */
@Service
public class TestStuServiceImpl implements ITestStuService 
{
    @Autowired
    private TestStuMapper testStuMapper;

    /**
     * 查询测试学生列 
     * 
     * @param testStuId 测试学生列 ID
     * @return 测试学生列 
     */
    @Override
    public TestStu selectTestStuById(Long testStuId)
    {
        return testStuMapper.selectTestStuById(testStuId);
    }

    /**
     * 查询测试学生列 列表
     * 
     * @param testStu 测试学生列 
     * @return 测试学生列 
     */
    @Override
    public List<TestStu> selectTestStuList(TestStu testStu)
    {
        return testStuMapper.selectTestStuList(testStu);
    }

    /**
     * 新增测试学生列 
     * 
     * @param testStu 测试学生列 
     * @return 结果
     */
    @Override
    public int insertTestStu(TestStu testStu)
    {
        return testStuMapper.insertTestStu(testStu);
    }

    /**
     * 修改测试学生列 
     * 
     * @param testStu 测试学生列 
     * @return 结果
     */
    @Override
    public int updateTestStu(TestStu testStu)
    {
        return testStuMapper.updateTestStu(testStu);
    }

    /**
     * 删除测试学生列 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestStuByIds(String ids)
    {
        return testStuMapper.deleteTestStuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试学生列 信息
     * 
     * @param testStuId 测试学生列 ID
     * @return 结果
     */
    @Override
    public int deleteTestStuById(Long testStuId)
    {
        return testStuMapper.deleteTestStuById(testStuId);
    }
}
