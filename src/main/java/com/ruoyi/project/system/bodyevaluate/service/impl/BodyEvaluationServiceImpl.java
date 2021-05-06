package com.ruoyi.project.system.bodyevaluate.service.impl;


import com.ruoyi.project.system.bodyevaluate.mapper.BodyEvaluationMapper;
import com.ruoyi.project.system.bodyevaluate.service.IBodyEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyEvaluationServiceImpl implements IBodyEvaluationService {

    @Autowired
    BodyEvaluationMapper bodyEvaluationMapper;


}
