package com.ruoyi.project.system.bodyevaluation.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationBar;
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
@RequestMapping("/system/scoreandevaluation/barevaluate")
public class BarEvaluateController extends BaseController {
    private String prefix = "system/scoreandevaluation/barevaluate";

    @Autowired
    private IBodyEvaluationService bodyEvaluationService;

    @RequiresPermissions("system:scoreandevaluation:barevaluate:list")
    @PostMapping("/list")
    public String list(BodyScore score, ModelMap mmap){
        List<String> itemNameList = new ArrayList<>();
        List<Double> aveNowList = new ArrayList<>();
        List<Double> aveLastList = new ArrayList<>();


        BodyEvaluationBar bodyEvaluationBar = new BodyEvaluationBar();
        Calendar calendar = Calendar.getInstance();
        long nowYear = calendar.get(Calendar.YEAR);
        bodyEvaluationBar.setYear(nowYear);
        long classGrade = 7;
        if(classGrade>9)    classGrade=9;//年级最高等于9
        bodyEvaluationBar.setClassGrade(classGrade);

        //获得指定年级当前年份的成绩均值
        if(bodyEvaluationBar.getClassGrade() != null && bodyEvaluationBar.getYear() != null){
            List<BodyEvaluationBar> barlist = bodyEvaluationService.generateDataForBar(bodyEvaluationBar);
            int i,len = barlist.size();
            for(i=0;i<len;i++){
                itemNameList.add(barlist.get(i).getItemName());
                aveNowList.add(barlist.get(i).getAve());
            }
            mmap.put("itemNameList", itemNameList);
            mmap.put("aveNowList",aveNowList);

            //获取指定年级往年的成绩均值
            if(bodyEvaluationBar.getClassGrade()>7){
                bodyEvaluationBar.setClassGrade(bodyEvaluationBar.getClassGrade()-1);
                bodyEvaluationBar.setYear(bodyEvaluationBar.getYear()-1);
                barlist = bodyEvaluationService.generateDataForBar(bodyEvaluationBar);
                for(i=0;i<barlist.size();i++){
                    aveLastList.add(barlist.get(i).getAve());
                }
                mmap.put("aveLastList",aveLastList);
            }
        }
        return "system/scoreandevaluation"+"/bodyevaluate/bodyevaluate";
    }

}
