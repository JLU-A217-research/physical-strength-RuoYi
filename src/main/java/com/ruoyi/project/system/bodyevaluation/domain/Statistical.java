package com.ruoyi.project.system.bodyevaluation.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Statistical extends BaseEntity {
    private Long statisticalInformationId;
    private Long testItemId;
    private Long testYear;
    private Long testClassGrade;
    private Long sumPoint;
    private Long sumStu;
    private Long classNo;
    private Double avePoint;

    public Long getStatisticalInformationId() {
        return statisticalInformationId;
    }

    public void setStatisticalInformationId(Long statisticalInformationId) {
        this.statisticalInformationId = statisticalInformationId;
    }

    public Long getTestItemId() {
        return testItemId;
    }

    public void setTestItemId(Long testItemId) {
        this.testItemId = testItemId;
    }

    public Long getTestYear() {
        return testYear;
    }

    public void setTestYear(Long testYear) {
        this.testYear = testYear;
    }

    public Long getTestClassGrade() {
        return testClassGrade;
    }

    public void setTestClassGrade(Long testClassGrade) {
        this.testClassGrade = testClassGrade;
    }

    public Long getSumPoint() {
        return sumPoint;
    }

    public void setSumPoint(Long sumPoint) {
        this.sumPoint = sumPoint;
    }

    public Long getSumStu() {
        return sumStu;
    }

    public void setSumStu(Long sumStu) {
        this.sumStu = sumStu;
    }

    public Long getClassNo() {
        return classNo;
    }

    public void setClassNo(Long classNo) {
        this.classNo = classNo;
    }

    public Double getAvePoint() {
        return avePoint;
    }

    public void setAvePoint(Double avePoint) {
        this.avePoint = avePoint;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("statisticalInformationId",getStatisticalInformationId())
                .append("testItemId",getTestItemId())
                .append("testYear",getTestYear())
                .append("testClassGrade",getTestClassGrade())
                .append("classNo", getClassNo())
                .append("sumPoint", getSumPoint())
                .append("sumStu",getSumStu())
                .append("avePoint",getAvePoint())
                .toString();
    }
}
