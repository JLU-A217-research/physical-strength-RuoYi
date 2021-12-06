package com.ruoyi.project.system.teacher.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.teacher.domain.PrsnTeacher;
import com.ruoyi.project.system.teacher.service.IPrsnTeacherService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教师信息 Controller
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
@Controller
@RequestMapping("/system/teacher")
public class PrsnTeacherController extends BaseController
{
    private String prefix = "system/teacher";

    @Autowired
    private IPrsnTeacherService prsnTeacherService;

    @RequiresPermissions("system:teacher:view")
    @GetMapping()
    public String teacher()
    {
        return prefix + "/teacher";
    }

    /**
     * 查询教师信息 列表
     */
    @RequiresPermissions("system:teacher:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PrsnTeacher prsnTeacher)
    {
        startPage();
        List<PrsnTeacher> list = prsnTeacherService.selectPrsnTeacherList(prsnTeacher);
        return getDataTable(list);
    }

    /**
     * 导出教师信息 列表
     */
    @RequiresPermissions("system:teacher:export")
    @Log(title = "教师信息 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PrsnTeacher prsnTeacher)
    {
        List<PrsnTeacher> list = prsnTeacherService.selectPrsnTeacherList(prsnTeacher);
        ExcelUtil<PrsnTeacher> util = new ExcelUtil<PrsnTeacher>(PrsnTeacher.class);
        return util.exportExcel(list, "teacher");
    }

    /**
     * 新增教师信息 
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教师信息 
     */
    @RequiresPermissions("system:teacher:add")
    @Log(title = "教师信息 ", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PrsnTeacher prsnTeacher)
    {
        return toAjax(prsnTeacherService.insertPrsnTeacher(prsnTeacher));
    }

    /**
     * 修改教师信息 
     */
    @GetMapping("/edit/{teacherId}")
    public String edit(@PathVariable("teacherId") Long teacherId, ModelMap mmap)
    {
        PrsnTeacher prsnTeacher = prsnTeacherService.selectPrsnTeacherById(teacherId);
        mmap.put("prsnTeacher", prsnTeacher);
        return prefix + "/edit";
    }

    /**
     * 修改保存教师信息 
     */
    @RequiresPermissions("system:teacher:edit")
    @Log(title = "教师信息 ", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PrsnTeacher prsnTeacher)
    {
        return toAjax(prsnTeacherService.updatePrsnTeacher(prsnTeacher));
    }

    /**
     * 删除教师信息 
     */
    @RequiresPermissions("system:teacher:remove")
    @Log(title = "教师信息 ", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(prsnTeacherService.deletePrsnTeacherByIds(ids));
    }
}
