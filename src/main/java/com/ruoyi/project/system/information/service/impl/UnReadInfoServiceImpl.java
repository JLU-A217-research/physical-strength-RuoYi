package com.ruoyi.project.system.information.service.impl;

import com.ruoyi.project.system.information.mapper.UnReadInfoMapper;
import com.ruoyi.project.system.information.service.UnReadInfoService;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ruoyi.common.utils.security.ShiroUtils.getSysUser;

@Service("GetUnReadInfoCnt")
public class UnReadInfoServiceImpl implements UnReadInfoService {

    @Autowired
    UnReadInfoMapper unReadInfoMapper;

    @Override
    public Long getUnReadInfoCnt() {
        User user = getSysUser();
        return unReadInfoMapper.getUnReadInfoCnt(user).getUnReadInfoCnt();
    }
}
