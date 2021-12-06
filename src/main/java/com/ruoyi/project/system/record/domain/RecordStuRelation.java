package com.ruoyi.project.system.record.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class RecordStuRelation {


    private Long testRecordId;
    private Long stuId;
    private Long enrollYear;
    private Long classNo;
    private Long testItemId;

    public Long getTestRecordId() {
        return testRecordId;
    }

    public void setTestRecordId(Long testRecordId) {
        this.testRecordId = testRecordId;
    }
    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }
    public Long getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(Long enrollYear) {
        this.enrollYear = enrollYear;
    }
    public Long getClassNo() {
        return classNo;
    }

    public void setClassNo(Long classNo) {
        this.classNo = classNo;
    }
    public Long getTestItemId() {
        return testItemId;
    }

    public void setTestItemId(Long testItemId) {
        this.testItemId = testItemId;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("testRecordId",getTestRecordId())
                .append("testItemId",getTestItemId())
                .append("stuId",getStuId())
                .append("enrollYear",getEnrollYear())
                .append("classNo",getClassNo())
                .toString();
    }
}
