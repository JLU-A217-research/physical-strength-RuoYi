package com.ruoyi.project.system.recordCopy.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/*
体测记录与体测项目关联 test_item_relation
 */
public class TestRecordItem {

    /*测试记录ID*/
    private Long testRecordId;

    /*体测项目ID*/
    private Long testItemId;

    public Long getTestRecordId() {
        return testRecordId;
    }

    public void setTestRecordId(Long testRecordId) {
        this.testRecordId = testRecordId;
    }

    public Long getTestItem() {
        return testItemId;
    }

    public void setTestItem(Long testItem) {
        this.testItemId = testItem;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("testRecordId", getTestRecordId())
                .append("testItemId", getTestItem())
                .toString();
    }



}
