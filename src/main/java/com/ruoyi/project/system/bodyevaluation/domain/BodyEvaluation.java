package com.ruoyi.project.system.bodyevaluation.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BodyEvaluation extends BaseEntity {

    private long passNum=0;

    private long goodNum=0;

    private long excellentNum=0;

    private long total=0;

    private long itemId;

    private String itemName;

    private double passRate;
    private double goodRate;
    private double excellentRate;

    public double getPassRate() {
        return passRate;
    }

    public void setPassRate(double passRate) {
        this.passRate = passRate;
    }

    public double getGoodRate() {
        return goodRate;
    }

    public void setGoodRate(double goodRate) {
        this.goodRate = goodRate;
    }

    public double getExcellentRate() {
        return excellentRate;
    }

    public void setExcellentRate(double excellentRate) {
        this.excellentRate = excellentRate;
    }
    public long getPassNum() {
        return passNum;
    }

    public void setPassNum(long passNum) {
        this.passNum = passNum;
    }

    public long getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(long goodNum) {
        this.goodNum = goodNum;
    }

    public long getExcellentNum() {
        return excellentNum;
    }

    public void setExcellentNum(long excellentNum) {
        this.excellentNum = excellentNum;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("passNum",getPassNum())
                .append("goodNum",getGoodNum())
                .append("excellentNum",getExcellentNum())
                .append("total",getTotal())
                .append("itemId",getItemId())
                .append("itemName", getItemName())
                .append("passRate",getPassRate())
                .append("goodRate",getGoodRate())
                .append("excellentRate",getExcellentRate())
                .toString();
    }

}
