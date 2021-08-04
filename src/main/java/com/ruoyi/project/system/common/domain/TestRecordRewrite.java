package com.ruoyi.project.system.common.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/*
下拉菜单
体测记录表 test_record
 */
public class TestRecordRewrite extends BaseEntity {
    private static final long serialVersionUID = 1L;


    /*体测记录ID*/
    private Long testRecordId;


    /*体测记录名称*/
    private String testRecordName;

    public Long getTestRecordId() {
        return testRecordId;
    }

    public void setTestRecordId(Long testRecordId) {
        this.testRecordId = testRecordId;
    }

    public String getTestRecordName() {
        return testRecordName;
    }

    public void setTestRecordName(String testRecordName) {
        this.testRecordName = testRecordName;
    }


    @Override
    public String toString(){
        return "TestRecordRewrite{"+
                "testRecordId='"+ testRecordId+'\''+
                ", testRecordName" + testRecordName+
                '}';
    }

}
