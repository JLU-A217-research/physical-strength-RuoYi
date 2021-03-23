package com.ruoyi.project.system.score.controller;

import java.util.List;
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
import com.ruoyi.project.system.score.domain.Score;
import com.ruoyi.project.system.score.service.IScoreService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 学生成绩 Controller
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
@Controller
@RequestMapping("/system/score")
public class ScoreController extends BaseController
{
    private String prefix = "system/score";

    @Autowired
    private IScoreService scoreService;

    @RequiresPermissions("system:score:view")
    @GetMapping()
    public String score()
    {
        return prefix + "/score";
    }

    /**
     * 查询学生成绩 列表
     */
    @RequiresPermissions("system:score:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Score score)
    {
        startPage();
        List<Score> list = scoreService.selectScoreList(score);
        return getDataTable(list);
    }

    /**
     * 导出学生成绩 列表
     */
    @RequiresPermissions("system:score:export")
    @Log(title = "学生成绩 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Score score)
    {
        List<Score> list = scoreService.selectScoreList(score);
        ExcelUtil<Score> util = new ExcelUtil<Score>(Score.class);
        return util.exportExcel(list, "score");
    }

    /**
     * 新增学生成绩 
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生成绩 
     */
    @RequiresPermissions("system:score:add")
    @Log(title = "学生成绩 ", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Score score)
    {
        return toAjax(scoreService.insertScore(score));
    }

    /**
     * 修改学生成绩 
     */
    @GetMapping("/edit/{scoreRecordId}")
    public String edit(@PathVariable("scoreRecordId") Long scoreRecordId, ModelMap mmap)
    {
        Score score = scoreService.selectScoreById(scoreRecordId);
        mmap.put("score", score);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生成绩 
     */
    @RequiresPermissions("system:score:edit")
    @Log(title = "学生成绩 ", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Score score)
    {
        return toAjax(scoreService.updateScore(score));
    }

    /**
     * 删除学生成绩 
     */
    @RequiresPermissions("system:score:remove")
    @Log(title = "学生成绩 ", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(scoreService.deleteScoreByIds(ids));
    }
}
