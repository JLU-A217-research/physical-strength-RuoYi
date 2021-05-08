package com.ruoyi.project.system.studentscoremanage.controller;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.project.system.standard.domain.InitTestStandard;
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
import com.ruoyi.project.system.studentscoremanage.domain.Score;
import com.ruoyi.project.system.studentscoremanage.service.IScoreService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 学生成绩管理Controller
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
@Controller
@RequestMapping("/system/scoreandevaluation/personscore")
public class ScoreController extends BaseController
{
    private String prefix = "system/scoreandevaluation/personscore";

    @Autowired
    private IScoreService scoreService;

    @RequiresPermissions("system:scoreandevaluation:personscore:view")
    @GetMapping()
    public String studentscoremanage()
    {
        return prefix + "/studentscoremanage";
    }

    /**
     * 查询学生成绩管理列表
     */
    @RequiresPermissions("system:scoreandevaluation:personscore:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Score score)
    {
        startPage();
        List<Score> list = scoreService.selectScoreListByStu(score);
        int i;
        Score s;
        for(i=0;i<list.size();i++){
            s = list.get(i);
            list.get(i).setTestPoint(creatPoint(s));
            long gradeId = creatTestGrade(s);
            list.get(i).setTestGradeId(gradeId);
            if(gradeId == 0)    list.get(i).setTestGrade("优");
            else if(gradeId == 1)    list.get(i).setTestGrade("良");
            else if(gradeId == 2)    list.get(i).setTestGrade("中");
            else    list.get(i).setTestGrade("差");
        }
        return getDataTable(list);
    }

    long creatPoint(Score s){
        return scoreService.creatPoint(s);
    }
    long creatTestGrade(Score s){
        return scoreService.creatTestGrade(s);
    }


    /**
     * 导出学生成绩管理列表
     */
    @RequiresPermissions("system:scoreandevaluation:personscore:export")
    @Log(title = "学生成绩管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Score score)
    {
        List<Score> list = scoreService.selectScoreListByStu(score);
        ExcelUtil<Score> util = new ExcelUtil<Score>(Score.class);
        return util.exportExcel(list, "personscore");
    }

    /**
     * 新增学生成绩管理
     */
    @GetMapping("/add{stuNo}")
    public String add(@PathVariable("stuNo") Long stuNo, ModelMap mmap)
    {
        Score score = scoreService.selectStudentByNo(stuNo);
        mmap.put("score", score);
        return prefix + "/add";
    }

    /**
     * 新增保存学生成绩管理
     */
    @RequiresPermissions("system:scoreandevaluation:personscore:add")
    @Log(title = "学生成绩管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Score score)
    {
        return toAjax(scoreService.insertScore(score));
    }

    /**
     * 修改学生成绩管理
     */
    @GetMapping("/edit/{scoreRecordId}")
    public String edit(@PathVariable("scoreRecordId") Long scoreRecordId, ModelMap mmap)
    {
        Score score = scoreService.selectScoreById(scoreRecordId);
        mmap.put("score", score);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生成绩管理
     */
    @RequiresPermissions("system:scoreandevaluation:personscore:edit")
    @Log(title = "学生成绩管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Score score)
    {
        return toAjax(scoreService.updateScore(score));
    }

    /**
     * 删除学生成绩管理
     */
    @RequiresPermissions("system:scoreandevaluation:personscore:remove")
    @Log(title = "学生成绩管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(scoreService.deleteScoreByIds(ids));
    }
}
