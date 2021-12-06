package com.ruoyi.project.system.recordCopy.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class TestRecordStuCopy {

    private Long testRecordId;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    private Long stuId;

    public Long getTestRecordId() {
        return testRecordId;
    }

    public void setTestRecordId(Long testRecordId) {
        this.testRecordId = testRecordId;
    }


    public Long getTestItemId() {
        return testItemId;
    }

    public void setTestItemId(Long testItemId) {
        this.testItemId = testItemId;
    }

    private Long testItemId;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    private float score;
    @Override
    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("testRecordId",getTestRecordId())
                .append("testItemId",getTestItemId())
                .append("stuId",getStuId())
                .append("score",getScore())
                .toString();
    }
}