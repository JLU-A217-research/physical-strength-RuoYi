package com.ruoyi.project.system.record.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TestRecordClass {


    private Long testRecordId;
    private Long classNo;
    private Long enrollYear;


    public Long getTestRecordId() {
        return testRecordId;
    }

    public void setTestRecordId(Long testRecordId) {
        this.testRecordId = testRecordId;
    }

    public Long getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(Long enrollYear) {
        this.enrollYear = enrollYear;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    private String str1;


    public Long getClassNo() {
        return classNo;
    }

    public void setClassNo(Long classNo) {
        this.classNo = classNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("testRecordId", getTestRecordId())
                .append("enrollYear", getEnrollYear())
                .append("classNo",getClassNo())
                .append("str1",getStr1())
                .toString();
    }



}
