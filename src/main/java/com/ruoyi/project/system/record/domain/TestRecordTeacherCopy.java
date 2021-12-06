package com.ruoyi.project.system.record.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class TestRecordTeacherCopy {

    /*测试记录ID*/
    private Long testRecordId;

    /*教师ID*/
    private Long prsnTeacherId;

    public Long getTestRecordId() {
        return testRecordId;
    }

    public void setTestRecordId(Long testRecordId) {
        this.testRecordId = testRecordId;
    }

    public Long getPrsnTeacherId() {
        return prsnTeacherId;
    }

    public void setPrsnTeacherId(Long prsnTeacherId) {
        this.prsnTeacherId = prsnTeacherId;
    }
    @Override
    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("testRecordId",getTestRecordId())
                .append("prsnTeacherId",getPrsnTeacherId())
                .toString();
    }

}
