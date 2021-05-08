package com.ruoyi.project.system.bodyevaluate.controller;


import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.bodyevaluate.domian.BodyEvaluation;
import com.ruoyi.project.system.bodyevaluate.service.IBodyEvaluationService;
import com.ruoyi.project.system.studentscoremanage.domain.Score;
import com.ruoyi.project.system.studentscoremanage.service.IScoreService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/system/scoreandevaluation/bodyevaluate")
public class BodyEvaluationController extends BaseController {

    private String prefix = "system/scoreandevaluation/bodyevaluate";

    @Autowired
    private IBodyEvaluationService bodyEvaluationService;

    @Autowired
    private IScoreService scoreService;

    /*
     *  查询体质评价等级占比
     */
    @RequiresPermissions("system:scoreandevaluation:bodyevaluate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Score score)
    {
        startPage();
        List<Score> scoreList = scoreService.selectScoreListByStu(score);
        int i;
        Score s;
        for(i=0;i<scoreList.size();i++){
            s = scoreList.get(i);
            scoreList.get(i).setTestPoint(creatPoint(s));
            long gradeId = creatTestGrade(s);
            scoreList.get(i).setTestGradeId(gradeId);
            if(gradeId == 0)    scoreList.get(i).setTestGrade("优");
            else if(gradeId == 1)    scoreList.get(i).setTestGrade("良");
            else if(gradeId == 2)    scoreList.get(i).setTestGrade("中");
            else    scoreList.get(i).setTestGrade("差");
        }
//        List<BodyEvaluation> list;
        return getDataTable(scoreList);
    }

    long creatPoint(Score s){
        return scoreService.creatPoint(s);
    }
    long creatTestGrade(Score s){
        return scoreService.creatTestGrade(s);
    }

}
