package com.ruoyi.project.system.info.service.impl;

import com.ruoyi.project.system.info.mapper.AbsenceUnDealCntMapper;
import com.ruoyi.project.system.info.service.AbsenceUnDealCntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("GetAbsenceUnDealCnt")
public class AbsenceUnDealCntServiceImpl implements AbsenceUnDealCntService {

    @Autowired
    AbsenceUnDealCntMapper absenceUnDealCntMapper;

    @Override
    public Long getAbsenceUnDealCnt() {
        return absenceUnDealCntMapper.getAbsenceUnDealCnt().getUnDealCnt();
    }
}
