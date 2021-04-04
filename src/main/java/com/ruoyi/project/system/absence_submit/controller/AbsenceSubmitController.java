package com.ruoyi.project.system.absence_submit.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.absence_submit.domain.AbsenceSubmit;
import com.ruoyi.project.system.absence_submit.service.IAbsenceSubmitService;
import com.ruoyi.project.system.common.domain.ClassGradeData;
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
@RequestMapping("/system/absence_submit")
public class AbsenceSubmitController extends BaseController
{
    private String prefix = "system/absence_submit";

    @Autowired
    private IAbsenceSubmitService absenceSubmitService;

    @RequiresPermissions("system:absence_submit:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/absence_submit";
    }

    /**
     * 查询请假信息 列表
     */
    @RequiresPermissions("system:absence_submit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AbsenceSubmit absenceSubmit)
    {
        startPage();
        List<AbsenceSubmit> list = absenceSubmitService.selectAbsenceInfoList(absenceSubmit);
        return getDataTable(list);
    }

    /**
     * 导出请假信息 列表
     */
    @RequiresPermissions("system:absence_submit:export")
    @Log(title = "请假信息 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AbsenceSubmit absenceSubmit)
    {
        List<AbsenceSubmit> list = absenceSubmitService.selectAbsenceInfoList(absenceSubmit);
        ExcelUtil<AbsenceSubmit> util = new ExcelUtil<AbsenceSubmit>(AbsenceSubmit.class);
        return util.exportExcel(list, "absence_submit");
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
    @RequiresPermissions("system:absence_submit:add")
    @Log(title = "请假信息 ", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AbsenceSubmit absenceSubmit)
    {
        return toAjax(absenceSubmitService.insertAbsenceSubmit(absenceSubmit));
    }

    /**
     * 修改请假信息
     */
    @GetMapping("/edit/{absenceInfoId}")
    public String edit(@PathVariable("absenceInfoId") Long absenceInfoId, ModelMap mmap)
    {
        AbsenceSubmit absenceSubmit = absenceSubmitService.selectAbsenceInfoById(absenceInfoId);
        mmap.put("absenceSubmit", absenceSubmit);
        return prefix + "/edit";
    }

    /**
     * 修改保存请假信息
     */
    @RequiresPermissions("system:absence_submit:edit")
    @Log(title = "请假信息 ", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AbsenceSubmit absenceSubmit)
    {
        return toAjax(absenceSubmitService.updateAbsenceSubmit(absenceSubmit));
    }

    /**
     * 删除请假信息
     */
    @RequiresPermissions("system:absence_submit:remove")
    @Log(title = "请假信息 ", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(absenceSubmitService.deleteAbsenceInfoByIds(ids));
    }


    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(AbsenceSubmit absenceSubmit)
    {
        return toAjax(absenceSubmitService.changeStatus(absenceSubmit));
    }

    @PostMapping("/getClass")
    @ResponseBody
    public List<ClassGradeData> getClass(ClassGradeData classGradeData){
        return absenceSubmitService.getClass(classGradeData);
    }
}
