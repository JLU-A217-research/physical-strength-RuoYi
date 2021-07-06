package com.ruoyi.project.system.information.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class UnReadInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long unReadInfoCnt;

    public Long getUnReadInfoCnt() {
        return unReadInfoCnt;
    }

    public void setUnReadInfoCnt(Long unReadInfoCnt) {
        this.unReadInfoCnt = unReadInfoCnt;
    }

    @Override
    public String toString() {
        return "UnReadInfo{" +
                "unReadInfoCnt=" + unReadInfoCnt +
                '}';
    }
}
