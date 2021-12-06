package com.ruoyi.project.system.bodyevaluation.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BodyEvaluationBar extends BaseEntity {
    private long itemId;
    private String itemName;
    private Long year;
    private double ave;
    private Long classGrade;
    private Long classNo;
    private Long sumStu;

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

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public double getAve() {
        return ave;
    }

    public void setAve(double ave) {
        this.ave = ave;
    }

    public Long getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Long classGrade) {
        this.classGrade = classGrade;
    }

    //以下属性的都要删除
    long sumPointNow;
    long numNow;
    double aveNow;
    long sumPointLast;
    long numLast;
    double aveLast;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getSumPointNow() {
        return sumPointNow;
    }

    public void setSumPointNow(long sumPointNow) {
        this.sumPointNow = sumPointNow;
    }

    public long getNumNow() {
        return numNow;
    }

    public void setNumNow(long numNow) {
        this.numNow = numNow;
    }

    public double getAveNow() {
        return aveNow;
    }

    public void setAveNow(double aveNow) {
        this.aveNow = aveNow;
    }

    public long getSumPointLast() {
        return sumPointLast;
    }

    public void setSumPointLast(long sumPointLast) {
        this.sumPointLast = sumPointLast;
    }

    public long getNumLast() {
        return numLast;
    }

    public void setNumLast(long numLast) {
        this.numLast = numLast;
    }

    public double getAveLast() {
        return aveLast;
    }

    public void setAveLast(double aveLast) {
        this.aveLast = aveLast;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("itemId",getItemId())
                .append("itemName",getItemName())
                .append("sumPointNow",getSumPointNow())
                .append("numNow",getNumNow())
                .append("aveNow",getAveNow())
                .append("sumPointLast", getSumPointLast())
                .append("numLast",getNumLast())
                .append("aveLast",getAveLast())
                .toString();
    }
}
