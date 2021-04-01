package com.ruoyi.project.system.info.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.info.domain.AbsenceInfo;
import com.ruoyi.project.system.info.service.IAbsenceInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请假信息 Controller
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
@Controller
@RequestMapping("/system/info")
public class AbsenceInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private IAbsenceInfoService absenceInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询请假信息 列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AbsenceInfo absenceInfo)
    {
        startPage();
        List<AbsenceInfo> list = absenceInfoService.selectAbsenceInfoList(absenceInfo);
        return getDataTable(list);
    }

    /**
     * 导出请假信息 列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "请假信息 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AbsenceInfo absenceInfo)
    {
        List<AbsenceInfo> list = absenceInfoService.selectAbsenceInfoList(absenceInfo);
        ExcelUtil<AbsenceInfo> util = new ExcelUtil<AbsenceInfo>(AbsenceInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增请假信息 
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存请假信息 
     */
    @RequiresPermissions("system:info:add")
    @Log(title = "请假信息 ", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AbsenceInfo absenceInfo)
    {
        return toAjax(absenceInfoService.insertAbsenceInfo(absenceInfo));
    }

    /**
     * 修改请假信息 
     */
    @GetMapping("/edit/{absenceInfoId}")
    public String edit(@PathVariable("absenceInfoId") Long absenceInfoId, ModelMap mmap)
    {
        AbsenceInfo absenceInfo = absenceInfoService.selectAbsenceInfoById(absenceInfoId);
        mmap.put("absenceInfo", absenceInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存请假信息 
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "请假信息 ", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AbsenceInfo absenceInfo)
    {
        return toAjax(absenceInfoService.updateAbsenceInfo(absenceInfo));
    }

    /**
     * 删除请假信息 
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "请假信息 ", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(absenceInfoService.deleteAbsenceInfoByIds(ids));
    }




}
