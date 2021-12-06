package com.ruoyi.project.system.common.domain;

/*
下拉菜单
体测项目表 test_item
 */

import com.ruoyi.framework.web.domain.BaseEntity;

public class TestData extends BaseEntity{
    private static final long serialVersionUID = 1L;



    /*体测项目*/
    private String testItem;


    /*体测项目ID*/
    private Long itemId;



    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "testItem='" + testItem + '\'' +
                ", itemId=" + itemId +
                '}';
    }
}
