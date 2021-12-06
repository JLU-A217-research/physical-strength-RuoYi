package com.ruoyi.project.system.bodyevaluation.service.impl;

import com.ruoyi.project.system.bodyevaluation.service.IBodyEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UpdateStatisticalOnTime {
    @Autowired
    private IBodyEvaluationService bodyEvaluationService;
    @Scheduled(cron = "0 3 9 ? * *")
    public void updateStatistical(){
        bodyEvaluationService.updateStatistical();
    }
}
