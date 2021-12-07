package com.ruoyi.project.system.bodyevaluation.controller;


import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluation;
import com.ruoyi.project.system.bodyevaluation.domain.BodyScore;
import com.ruoyi.project.system.bodyevaluation.service.IBodyEvaluationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    /*
     *  查询体质评价等级占比
     */
    @RequiresPermissions("system:scoreandevaluation:bodyevaluate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BodyScore score)
    {
        List<BodyScore> scoreList = bodyEvaluationService.selectScoreList(score);
        List<BodyEvaluation> list = bodyEvaluationService.selectItemList();//list的下标代表的意义的项目Id-1

        int i;
        BodyScore s;
        int len = scoreList.size();
        for(i=0;i<len;i++){
            s = scoreList.get(i);
            long gradeId = s.getTestGradeId();
            int itemId = Integer.parseInt(scoreList.get(i).getItemId()+"");
            if(gradeId == 0) {
                list.get(itemId-1).setExcellentNum(list.get(itemId-1).getExcellentNum()+1);
            }
            else if(gradeId == 1) {
                list.get(itemId-1).setGoodNum(list.get(itemId-1).getGoodNum()+1);
            }
            else if(gradeId == 2) {
                list.get(itemId-1).setPassNum(list.get(itemId-1).getPassNum()+1);
            }
            list.get(itemId-1).setTotal(list.get(itemId-1).getTotal()+1);
        }
        for(i=0;i<list.size();i++){
            if(list.get(i).getTotal()!=0){
                list.get(i).setPassRate(1.0*list.get(i).getPassNum()/list.get(i).getTotal());
                list.get(i).setGoodRate(1.0*list.get(i).getGoodNum()/list.get(i).getTotal());
                list.get(i).setExcellentRate(1.0*list.get(i).getExcellentNum()/list.get(i).getTotal());
            }
            else{
                list.get(i).setPassRate(0);
                list.get(i).setGoodRate(0);
                list.get(i).setExcellentRate(0);
            }
        }
        list.remove(7);
        list.remove(7);
        return getDataTable(list);
    }

    long creatPoint(BodyScore s){
        return bodyEvaluationService.creatPoint(s);
    }
    long creatTestGrade(BodyScore s){
        return bodyEvaluationService.creatTestGrade(s);
    }

    //统计数据更新
    public void updateStatistical(){
        bodyEvaluationService.updateStatistical();
    }
}
