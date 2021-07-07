package com.ruoyi.project.stuscore.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.shiro.session.OnlineSessionDAO;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
import com.ruoyi.project.stuscore.domain.StuScore;
import com.ruoyi.project.stuscore.service.IStuScoreService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.web.filter.AccessControlFilter;

/**
 * 我的成绩Controller
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
@Controller
@RequestMapping("/stuscore/stuscore")
public class StuScoreController extends BaseController
{
    private String prefix = "stuscore/stuscore";

    @Autowired
    private IStuScoreService stuScoreService;

    @Autowired
    private OnlineSessionDAO onlineSessionDAO;

    @RequiresPermissions("stuscore:stuscore:view")
    @GetMapping()
    public String stuscore()
    {
        return prefix + "/stuscore";
    }


    /**
     * 查询我的成绩列表
     */
    @RequiresPermissions("stuscore:stuscore:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StuScore stuScore)
    {
        User user = ShiroUtils.getSysUser();
        Long stuId= user.getUserId();
        startPage();
        stuScore.setStuId(stuId);
        List<StuScore> list = stuScoreService.selectStuScoreList(stuScore);
        return getDataTable(list);
    }

    /**
     * 导出我的成绩列表
     */
    @RequiresPermissions("stuscore:stuscore:export")
    @Log(title = "我的成绩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StuScore stuScore)
    {
        List<StuScore> list = stuScoreService.selectStuScoreList(stuScore);
        ExcelUtil<StuScore> util = new ExcelUtil<StuScore>(StuScore.class);
        return util.exportExcel(list, "stuscore");
    }

    /**
     * 新增我的成绩
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存我的成绩
     */
    @RequiresPermissions("stuscore:stuscore:add")
    @Log(title = "我的成绩", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StuScore stuScore)
    {
        return toAjax(stuScoreService.insertStuScore(stuScore));
    }

    /**
     * 修改我的成绩
     */
    @GetMapping("/edit/{scoreRecordId}")
    public String edit(@PathVariable("scoreRecordId") Long scoreRecordId, ModelMap mmap)
    {
        StuScore stuScore = stuScoreService.selectStuScoreById(scoreRecordId);
        mmap.put("stuScore", stuScore);
        return prefix + "/edit";
    }

    /**
     * 修改保存我的成绩
     */
    @RequiresPermissions("stuscore:stuscore:edit")
    @Log(title = "我的成绩", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StuScore stuScore)
    {
        return toAjax(stuScoreService.updateStuScore(stuScore));
    }

    /**
     * 删除我的成绩
     */
    @RequiresPermissions("stuscore:stuscore:remove")
    @Log(title = "我的成绩", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(stuScoreService.deleteStuScoreByIds(ids));
    }
}
