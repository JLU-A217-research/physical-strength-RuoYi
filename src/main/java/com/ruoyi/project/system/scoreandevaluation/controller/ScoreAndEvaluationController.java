package com.ruoyi.project.system.scoreandevaluation.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluation;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationBar;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationLine;
import com.ruoyi.project.system.bodyevaluation.domain.BodyScore;
import com.ruoyi.project.system.bodyevaluation.service.IBodyEvaluationService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.scoreandevaluation.domain.ScoreAndEvaluation;
import com.ruoyi.project.system.scoreandevaluation.service.IScoreAndEvaluationService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 成绩与体质评价Controller
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
@Controller
@RequestMapping("/system/scoreandevaluation")
public class ScoreAndEvaluationController extends BaseController
{
    private String prefix = "system/scoreandevaluation";

    @Autowired
    private IScoreAndEvaluationService scoreAndEvaluationService;

    @Autowired
    private IBodyEvaluationService bodyEvaluationService;

    @RequiresPermissions("system:scoreandevaluation:view")
    @GetMapping("")
    public String scoreandevaluation()
    {
        return prefix + "/scoreandevaluation";
    }

    /**
     * 查询成绩与体质评价列表
     */
    @RequiresPermissions("system:scoreandevaluation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ScoreAndEvaluation score)
    {
        startPage();
        List<ScoreAndEvaluation> list = scoreAndEvaluationService.selectStuList(score);
        return getDataTable(list);
    }

    @RequiresPermissions("system:scoreandevaluation:importList")
    @PostMapping("/importList")
    @ResponseBody
    public TableDataInfo importList(ScoreAndEvaluation score)
    {
        startPage();
        List<ScoreAndEvaluation> list = scoreAndEvaluationService.selectScoreList(score);
        return getDataTable(list);
    }

    @RequiresPermissions("system:user:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ScoreAndEvaluation> util = new ExcelUtil<ScoreAndEvaluation>(ScoreAndEvaluation.class);
        List<ScoreAndEvaluation> userList = util.importExcel(file.getInputStream());
        String message = scoreAndEvaluationService.importScore(userList, updateSupport);
        return AjaxResult.success(message);
    }


    /**
     * 导出成绩与体质评价列表
     */
    @RequiresPermissions("system:scoreandevaluation:export")
    @Log(title = "成绩与体质评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ScoreAndEvaluation score)
    {
        List<ScoreAndEvaluation> list = scoreAndEvaluationService.selectScoreList(score);
        ExcelUtil<ScoreAndEvaluation> util = new ExcelUtil<ScoreAndEvaluation>(ScoreAndEvaluation.class);
        return util.exportExcel(list, "scoreandevaluation");
    }

    /**
     * 新增成绩与体质评价
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存成绩与体质评价
     */
    @RequiresPermissions("system:scoreandevaluation:add")
    @Log(title = "成绩与体质评价", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ScoreAndEvaluation score)
    {
        score.setTgsId(scoreAndEvaluationService.selectTgsId(score));
        return toAjax(scoreAndEvaluationService.insertScore(score));

    }

    /**
     * 修改成绩与体质评价
     */
    @GetMapping("/edit/{scoreRecordId}")
    public String edit(@PathVariable("scoreRecordId") Long scoreRecordId, ModelMap mmap)
    {
        ScoreAndEvaluation score = scoreAndEvaluationService.selectScoreById(scoreRecordId);
        mmap.put("score", score);
        return prefix + "/edit";
    }

    /**
     * 导入保存学生成绩
     */
    @GetMapping("/scoreimport")
    public String scoreimport(){return prefix + "/scoreimport";}

    @GetMapping("/bodyEvaluate/bodyEvaluate/{year}")
    public String bodyEvaluate(@PathVariable("year")Long year, ModelMap mmap){//score里传过来的应该是年级
        //barchart 数据
        List<String> itemNameList = new ArrayList<>();
        List<Double> aveNowList = new ArrayList<>();
        List<Double> aveLastList = new ArrayList<>();


        BodyEvaluationBar bodyEvaluationBar = new BodyEvaluationBar();
        Calendar calendar = Calendar.getInstance();
        long nowYear = calendar.get(Calendar.YEAR);
        bodyEvaluationBar.setYear(nowYear);
        long classGrade = nowYear - year + 7;
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

        //linechart数据
        List<String> itemNameListLine = new ArrayList<>();
        List<Long> yearList = new ArrayList<>();
        for(int i=4;i>=0;i--){
            yearList.add(nowYear - i);
        }
        mmap.put("yearList", yearList);
        if(bodyEvaluationBar.getClassGrade() != null){
            bodyEvaluationBar.setYear(null);
            List<BodyEvaluation> itemName = bodyEvaluationService.selectItemList();
            List<BodyEvaluationBar> lineList = bodyEvaluationService.generateDataForBar(bodyEvaluationBar);
            int i,len = itemName.size();
            for(i=0;i<itemName.size();i++){
                if(itemName.get(i).getItemId()!=8&&itemName.get(i).getItemId()!=9)
                    itemNameListLine.add(itemName.get(i).getItemName());
            }
            mmap.put("itemNameListLine", itemNameListLine);
            ArrayList<ArrayList<Double>> aveListLine = new ArrayList<ArrayList<Double>>();
            for(i=0;i<20;i++){
                ArrayList<Double> d = new ArrayList<Double>();
                aveListLine.add(d);
            }
            len = lineList.size();
            for(i=0;i<len;i++){
                int iyear = Integer.parseInt(lineList.get(i).getYear() + "");
                if(iyear >= yearList.get(0) && iyear <= yearList.get(4)){
                    int idx = Integer.parseInt(lineList.get(i).getItemId() + "");
                    aveListLine.get(idx).add(lineList.get(i).getAve());
                }
            }
            mmap.put("aveListLine", aveListLine);
        }

        return prefix + "/bodyEvaluate/bodyEvaluate";
    }

    /**
     * 个人成绩管理
     */

     @GetMapping("/studentscoremanage/studentscoremanage/{stuId}")
     public String personalscoremanage(@PathVariable("stuId") Long stuId, ModelMap mmap){
          ScoreAndEvaluation score = scoreAndEvaluationService.selectStuById(stuId);//功能错误
          mmap.put("score", score);
          return prefix + "/studentscoremanage/studentscoremanage";
     }


    /**
     * 修改保存成绩与体质评价
     */
    @RequiresPermissions("system:scoreandevaluation:edit")
    @Log(title = "成绩与体质评价", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ScoreAndEvaluation score)
    {
        return toAjax(scoreAndEvaluationService.updateScore(score));
    }

    /**
     * 删除成绩与体质评价
     */
    @RequiresPermissions("system:scoreandevaluation:remove")
    @Log(title = "成绩与体质评价", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(scoreAndEvaluationService.deleteScoreByIds(ids));
    }


}
