package com.ruoyi.project.system.bodyevaluation.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BodyEvaluationLine extends BaseEntity {
    //这个类里面存放的是每一个测试项目近六年来的成绩均值
    private long itemId;
    private String itemName;
    long[] sumPoint = new long[10];
    long[] num = new long[10];
    double[] ave = new double[10];

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

    public long getSumPoint(int i) {
        return sumPoint[i];
    }

    public void setSumPoint(long sumPoint, int i) {
        this.sumPoint[i] = sumPoint;
    }

    public long getNum(int i) {
        return num[i];
    }

    public void setNum(long num, int i) {
        this.num[i] = num;
    }

    public double getAve(int i) {
        return ave[i];
    }

    public void setAve(double ave,int i) {
        this.ave[i] = ave;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("itemId",getItemId())
                .append("itemName",getItemName())
//                .append("sumPoint",getSumPoint())
//                .append("num",getNum())
//                .append("ave",getAve())
                .toString();
    }
}
