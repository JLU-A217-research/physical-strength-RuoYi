package com.ruoyi.project.system.relation.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.relation.domain.TestGradeSexRelation;
import com.ruoyi.project.system.relation.mapper.TestGradeSexRelationMapper;
import com.ruoyi.project.system.relation.service.ITestGradeSexRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 年级-性别-测试项目关系 Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-12
 */
@Service
public class TestGradeSexRelationServiceImpl implements ITestGradeSexRelationService 
{
    @Autowired
    private TestGradeSexRelationMapper testGradeSexRelationMapper;

    /**
     * 查询年级-性别-测试项目关系 
     * 
     * @param tgsId 年级-性别-测试项目关系 ID
     * @return 年级-性别-测试项目关系 
     */
    @Override
    public TestGradeSexRelation selectTestGradeSexRelationById(Long tgsId)
    {
        return testGradeSexRelationMapper.selectTestGradeSexRelationById(tgsId);
    }

    /**
     * 查询年级-性别-测试项目关系 列表
     * 
     * @param testGradeSexRelation 年级-性别-测试项目关系 
     * @return 年级-性别-测试项目关系 
     */
    @Override
    public List<TestGradeSexRelation> selectTestGradeSexRelationList(TestGradeSexRelation testGradeSexRelation)
    {
        return testGradeSexRelationMapper.selectTestGradeSexRelationList(testGradeSexRelation);
    }

    /**
     * 新增年级-性别-测试项目关系 
     * 
     * @param testGradeSexRelation 年级-性别-测试项目关系 
     * @return 结果
     */
    @Override
    public int insertTestGradeSexRelation(TestGradeSexRelation testGradeSexRelation)
    {
        return testGradeSexRelationMapper.insertTestGradeSexRelation(testGradeSexRelation);
    }

    /**
     * 修改年级-性别-测试项目关系 
     * 
     * @param testGradeSexRelation 年级-性别-测试项目关系 
     * @return 结果
     */
    @Override
    public int updateTestGradeSexRelation(TestGradeSexRelation testGradeSexRelation)
    {
        return testGradeSexRelationMapper.updateTestGradeSexRelation(testGradeSexRelation);
    }

    /**
     * 删除年级-性别-测试项目关系 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestGradeSexRelationByIds(String ids)
    {
        return testGradeSexRelationMapper.deleteTestGradeSexRelationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除年级-性别-测试项目关系 信息
     * 
     * @param tgsId 年级-性别-测试项目关系 ID
     * @return 结果
     */
    @Override
    public int deleteTestGradeSexRelationById(Long tgsId)
    {
        return testGradeSexRelationMapper.deleteTestGradeSexRelationById(tgsId);
    }
}
