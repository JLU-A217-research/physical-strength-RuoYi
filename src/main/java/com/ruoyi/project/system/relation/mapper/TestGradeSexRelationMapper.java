package com.ruoyi.project.system.relation.mapper;

import java.util.List;
import com.ruoyi.project.system.relation.domain.TestGradeSexRelation;

/**
 * 年级-性别-测试项目关系 Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-24
 */
public interface TestGradeSexRelationMapper 
{
    /**
     * 查询年级-性别-测试项目关系 
     * 
     * @param tgsId 年级-性别-测试项目关系 ID
     * @return 年级-性别-测试项目关系 
     */
    public TestGradeSexRelation selectTestGradeSexRelationById(Long tgsId);

    /**
     * 查询年级-性别-测试项目关系 列表
     * 
     * @param testGradeSexRelation 年级-性别-测试项目关系 
     * @return 年级-性别-测试项目关系 集合
     */
    public List<TestGradeSexRelation> selectTestGradeSexRelationList(TestGradeSexRelation testGradeSexRelation);

    /**
     * 新增年级-性别-测试项目关系 
     * 
     * @param testGradeSexRelation 年级-性别-测试项目关系 
     * @return 结果
     */
    public int insertTestGradeSexRelation(TestGradeSexRelation testGradeSexRelation);

    /**
     * 修改年级-性别-测试项目关系 
     * 
     * @param testGradeSexRelation 年级-性别-测试项目关系 
     * @return 结果
     */
    public int updateTestGradeSexRelation(TestGradeSexRelation testGradeSexRelation);

    /**
     * 删除年级-性别-测试项目关系 
     * 
     * @param tgsId 年级-性别-测试项目关系 ID
     * @return 结果
     */
    public int deleteTestGradeSexRelationById(Long tgsId);

    /**
     * 批量删除年级-性别-测试项目关系 
     * 
     * @param tgsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTestGradeSexRelationByIds(String[] tgsIds);
}