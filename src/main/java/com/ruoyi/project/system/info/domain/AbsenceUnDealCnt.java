package com.ruoyi.project.system.info.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class AbsenceUnDealCnt extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long unDealCnt;

    public Long getUnDealCnt() {
        return unDealCnt;
    }

    public void setUnDealCnt(Long unDealCnt) {
        this.unDealCnt = unDealCnt;
    }

    @Override
    public String toString() {
        return "AbsenceCnt{" +
                "unDealCnt=" + unDealCnt +
                '}';
    }
}
