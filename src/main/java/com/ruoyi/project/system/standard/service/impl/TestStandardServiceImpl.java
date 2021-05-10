package com.ruoyi.project.system.standard.service.impl;

import java.util.List;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.standard.controller.TestStandardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.standard.mapper.TestStandardMapper;
import com.ruoyi.project.system.standard.domain.TestStandard;
import com.ruoyi.project.system.standard.service.ITestStandardService;
import com.ruoyi.common.utils.text.Convert;

import javax.annotation.PostConstruct;


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
     * @param testPoint 测试指标 ID
     * @return 测试指标 
     */
    @Override
    public TestStandard selectTestStandardById(String testPoint)
    {
        return testStandardMapper.selectTestStandardById(testPoint);
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

    public List<TestStandard> sellctAllStandar(){
        return testStandardMapper.selectAllTestStandard();
    }


    public void setAllStandarCache(){

        List<TestStandard> list = sellctAllStandar();
        long[][][][] testStandar = new long[15][20][2][50];
        int grade;
        int itemId;
        int sexId;
        int idex;
        TestStandard ts;
        for(int i=0;i<list.size();i++){
            ts = list.get(i);
            grade = Integer.parseInt(ts.getGrade()+"");
            itemId = Integer.parseInt(ts.getTestItemId()+"");
            sexId = Integer.parseInt(ts.getStuSexId()+"");
            idex = Integer.parseInt(++testStandar[grade][itemId][sexId][0]+"");
            long point = ts.getTestPoint();
            testStandar[grade][itemId][sexId][idex] = point;
        }
        CacheUtils.put(Constants.Test_Standar, Constants.Test_Standar_Key, testStandar);
    }

    public List<TestStandard> getAllStandarCache()
    {
        Object cacheObj = CacheUtils.get(Constants.Test_Standar, Constants.Test_Standar_Key);
        if (StringUtils.isNotNull(cacheObj))
        {
            List<TestStandard> TestStandards = StringUtils.cast(cacheObj);
            return TestStandards;
        }
        return null;
    }

    @PostConstruct
    public void init()
    {
        setAllStandarCache();
        System.out.println("？？？？？？？？？？？？？？？？？？？？？？？？？？？");
    }

}
