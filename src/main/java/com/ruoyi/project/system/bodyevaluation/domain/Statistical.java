package com.ruoyi.project.system.bodyevaluation.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Statistical extends BaseEntity {
    private long statisticalInformationId;
    private long testItemId;
    private long testYear;
    private long testClassGrade;
    private long sumPoint;
    private long sumStu;
    private double avePoint;

    public long getStatisticalInformationId() {
        return statisticalInformationId;
    }

    public void setStatisticalInformationId(long statisticalInformationId) {
        this.statisticalInformationId = statisticalInformationId;
    }

    public long getTestItemId() {
        return testItemId;
    }

    public void setTestItemId(long testItemId) {
        this.testItemId = testItemId;
    }

    public long getTestYear() {
        return testYear;
    }

    public void setTestYear(long testYear) {
        this.testYear = testYear;
    }

    public long getTestClassGrade() {
        return testClassGrade;
    }

    public void setTestClassGrade(long testClassGrade) {
        this.testClassGrade = testClassGrade;
    }

    public long getSumPoint() {
        return sumPoint;
    }

    public void setSumPoint(long sumPoint) {
        this.sumPoint = sumPoint;
    }

    public long getSumStu() {
        return sumStu;
    }

    public void setSumStu(long sumStu) {
        this.sumStu = sumStu;
    }

    public double getAvePoint() {
        return avePoint;
    }

    public void setAvePoint(double avePoint) {
        this.avePoint = avePoint;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("statisticalInformationId",getStatisticalInformationId())
                .append("testItemId",getTestItemId())
                .append("testYear",getTestYear())
                .append("testClassGrade",getTestClassGrade())
                .append("sumPoint", getSumPoint())
                .append("sumStu",getSumStu())
                .append("avePoint",getAvePoint())
                .toString();
    }
}
