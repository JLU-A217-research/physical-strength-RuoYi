package com.ruoyi.project.system.recordCopy.mapper;

import com.ruoyi.project.system.recordCopy.domain.TestRecordItem;

import java.util.List;

/*
测试记录与体测项目关联表 数据层
 */
public interface TestRecordItemMapper {

    /*通过测试记录的id删除相应的体测项目*/
    public int deleteTestRecordItemByTestRecordId(long testRecordId);

    /*批量删除测试记录项目关联信息
    * ids:需要删除的数据Id
    * */
    public int deleteTestRecordItem(long[] ids);
    public int insertTestRecordItem(TestRecordItem testRecordItem);
    /*批量新增体测记录和对应项目列表
    testRecordItemList:体测记录项目列表
     */
    public int batchTestRecordItem(List<TestRecordItem> testRecordItemList);

    /*查询体测项目的使用数量*/
    public int selectCountTestRecordItemByTestRecordId(long testRecordId);

    public int countTestRecordItemById(long testItemId);

}
