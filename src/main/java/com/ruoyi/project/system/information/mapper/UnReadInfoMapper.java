package com.ruoyi.project.system.information.mapper;

import com.ruoyi.project.system.information.domain.UnReadInfo;
import com.ruoyi.project.system.user.domain.User;

public interface UnReadInfoMapper {
    public UnReadInfo getUnReadInfoCnt(User user);
}
