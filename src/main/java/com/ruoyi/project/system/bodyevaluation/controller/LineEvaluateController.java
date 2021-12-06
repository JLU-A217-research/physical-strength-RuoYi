package com.ruoyi.project.system.bodyevaluation.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluation;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationBar;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationLine;
import com.ruoyi.project.system.bodyevaluation.domain.BodyScore;
import com.ruoyi.project.system.bodyevaluation.service.IBodyEvaluationService;
import com.ruoyi.project.system.scoreandevaluation.studentscoremanage.domain.Score;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Controller
@RequestMapping("/system/scoreandevaluation/lineevaluate")
public class LineEvaluateController extends BaseController {
    private String prefix = "system/scoreandevaluation/lineevaluate";

    @Autowired
    private IBodyEvaluationService bodyEvaluationService;

    @RequiresPermissions("system:scoreandevaluation:lineevaluate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BodyScore score, ModelMap mmap){
        //linechart数据

        BodyEvaluationBar bodyEvaluationBar = new BodyEvaluationBar();
        Calendar calendar = Calendar.getInstance();
        long nowYear = calendar.get(Calendar.YEAR);
        if(score.getClassGrade() == null)   score.setClassGrade(9L);
        bodyEvaluationBar.setClassGrade(score.getClassGrade());
        List<String> itemNameListLine = new ArrayList<>();
        List<BodyEvaluationLine> bodyEvaluationLineList = new ArrayList<>();
        if(bodyEvaluationBar.getClassGrade() != null){
            bodyEvaluationBar.setYear(null);
            List<BodyEvaluation> itemName = bodyEvaluationService.selectItemList();
            List<BodyEvaluationBar> lineList = bodyEvaluationService.generateDataForBar(bodyEvaluationBar);
            int i,len = itemName.size();
            for(i=0;i<len;i++){
                if(itemName.get(i).getItemId()!=8&&itemName.get(i).getItemId()!=9) {
                    BodyEvaluationLine bodyEvaluationLine = new BodyEvaluationLine();
                    bodyEvaluationLine.setItemName(itemName.get(i).getItemName());
                    bodyEvaluationLine.setItemId(itemName.get(i).getItemId());
                    bodyEvaluationLineList.add(bodyEvaluationLine);
                }
            }
            ArrayList<ArrayList<Double>> aveListLine = new ArrayList<ArrayList<Double>>();
            for(i=0;i<20;i++){
                ArrayList<Double> d = new ArrayList<Double>();
                aveListLine.add(d);
            }
            len = lineList.size();
            for(i=0;i<len;i++){
                int iyear = Integer.parseInt(lineList.get(i).getYear() + "");
                if(iyear >= nowYear-4 && iyear <= nowYear){
                    int idx = Integer.parseInt(lineList.get(i).getItemId() + "");
                    aveListLine.get(idx).add(lineList.get(i).getAve());
                }
            }
            mmap.put("aveListLine", aveListLine);
        }
        return getDataTable(bodyEvaluationLineList);
    }
}
