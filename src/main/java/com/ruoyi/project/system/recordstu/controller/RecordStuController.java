package com.ruoyi.project.system.recordstu.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.recordstu.domain.RecordStu;
import com.ruoyi.project.system.recordstu.service.IRecordStuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2021-07-26
 */
@Controller
@RequestMapping("/system/recordstu")
public class RecordStuController extends BaseController
{
    private String prefix = "system/recordstu";

    @Autowired
    private IRecordStuService recordStuService;

    @RequiresPermissions("system:recordstu:view")
    @GetMapping()
    public String recordstu()
    {
        return prefix + "/recordstu";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:recordstu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecordStu recordStu)
    {
        startPage();
        List<RecordStu> list = recordStuService.selectRecordStuList(recordStu);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:recordstu:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecordStu recordStu)
    {
        List<RecordStu> list = recordStuService.selectRecordStuList(recordStu);
        ExcelUtil<RecordStu> util = new ExcelUtil<RecordStu>(RecordStu.class);
        return util.exportExcel(list, "recordstu");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:recordstu:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecordStu recordStu)
    {
        return toAjax(recordStuService.insertRecordStu(recordStu));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{testRecordId}")
    public String edit(@PathVariable("testRecordId") String testRecordId, ModelMap mmap)
    {
        RecordStu recordStu = recordStuService.selectRecordStuById(testRecordId);
        mmap.put("recordStu", recordStu);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:recordstu:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecordStu recordStu)
    {
        return toAjax(recordStuService.updateRecordStu(recordStu));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:recordstu:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recordStuService.deleteRecordStuByIds(ids));
    }
}
