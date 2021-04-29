package com.ruoyi.project.system.item.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 字典数据表 test_item_data
 * 
 * @author ruoyi
 */
public class TestItemData extends BaseEntity
{
    private static final long serialVersionUID = 1L;//序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
    private Long testItemId;
    private String testItemName;



    public Long getTestItemId() {
        return testItemId;
    }



    public void setTestItemId(Long testItemId) {
        this.testItemId = testItemId;
    }

    public String getTestItemName() {
        return testItemName;
    }

    public void setTestItemName(String testItemName) {
        this.testItemName = testItemName;
    }


    @Override
    public String toString() {
        return "TestItemData{" +
                "testItemId=" + testItemId +
                ", testItemName='" + testItemName + '\'' +
                '}';
    }
}
