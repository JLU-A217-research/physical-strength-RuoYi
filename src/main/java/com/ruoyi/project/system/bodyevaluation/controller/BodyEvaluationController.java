package com.ruoyi.project.system.bodyevaluation.controller;


import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluation;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationBar;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationLine;
import com.ruoyi.project.system.bodyevaluation.domain.BodyScore;
import com.ruoyi.project.system.bodyevaluation.service.IBodyEvaluationService;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.Calendar;
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
        startPage();
        List<BodyEvaluation> list = bodyEvaluationService.selectItemList();//list的下标代表的意义的项目Id-1
        List<BodyScore> scoreList = bodyEvaluationService.selectScoreList(score);
        int i;
        BodyScore s;
        for(i=0;i<scoreList.size();i++){
            s = scoreList.get(i);
            scoreList.get(i).setTestPoint(creatPoint(s));
            long gradeId = creatTestGrade(s);
            scoreList.get(i).setTestGradeId(gradeId);
            int itemId = Integer.parseInt(scoreList.get(i).getItemId()+"");
            if(gradeId == 0) {
                scoreList.get(i).setTestGrade("优");
                list.get(itemId-1).setExcellentNum(list.get(itemId-1).getExcellentNum()+1);
            }
            else if(gradeId == 1) {
                scoreList.get(i).setTestGrade("良");
                list.get(itemId-1).setGoodNum(list.get(itemId-1).getGoodNum()+1);
            }
            else if(gradeId == 2) {
                scoreList.get(i).setTestGrade("中");
                list.get(itemId-1).setPassNum(list.get(itemId-1).getPassNum()+1);
            }
            else    scoreList.get(i).setTestGrade("差");
            list.get(itemId-1).setTotal(list.get(itemId-1).getTotal()+1);
        }
        for(i=0;i<list.size();i++){
//            System.out.println("itemId="+list.get(i).getItemId()+"total"+list.get(i).getTotal());
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


//    @RequiresPermissions("system:scoreandevaluation:bodyevaluate:lineList")
//    @PostMapping("/lineList")
//    @ResponseBody
//    public String lineList(BodyScore score, ModelMap mmap){
//        startPage();
//        List<BodyEvaluationLine> list = bodyEvaluationService.generateDataForLine(score);
//        mmap.put("lineList", list);
//        return prefix + "/lineList";
//    }




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
