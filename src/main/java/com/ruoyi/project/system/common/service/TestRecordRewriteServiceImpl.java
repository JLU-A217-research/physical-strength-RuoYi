package com.ruoyi.project.system.common.service;
import com.ruoyi.project.system.common.domain.TestRecordRewrite;
import com.ruoyi.project.system.common.mapper.TestRecordRewriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testRecordId")
public class TestRecordRewriteServiceImpl implements TestRecordRewriteService{
    @Autowired
    TestRecordRewriteMapper testRecordRewriteMapper;

    @Override
    public List<TestRecordRewrite> selectTestRecordRewriteList(){
        return testRecordRewriteMapper.selectTestRecordRewriteByNo();
    }
}
