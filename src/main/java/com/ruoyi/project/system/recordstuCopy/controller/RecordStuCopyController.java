package com.ruoyi.project.system.recordstuCopy.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.recordstuCopy.domain.RecordStuCopy;
import com.ruoyi.project.system.recordstuCopy.service.IRecordStuCopyService;
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
@RequestMapping("/system/recordstuCopy")
public class RecordStuCopyController extends BaseController
{
    private String prefix = "system/recordstuCopy";

    @Autowired
    private IRecordStuCopyService recordStuCopyService;

    @RequiresPermissions("system:recordstuCopy:view")
    @GetMapping()
    public String recordstuCopy()
    {
        return prefix + "/recordstuCopy";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:recordstuCopy:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecordStuCopy recordStuCopy)
    {
        startPage();
        List<RecordStuCopy> list = recordStuCopyService.selectRecordStuList(recordStuCopy);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:recordstuCopy:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecordStuCopy recordStuCopy)
    {
        List<RecordStuCopy> list = recordStuCopyService.selectRecordStuList(recordStuCopy);
        ExcelUtil<RecordStuCopy> util = new ExcelUtil<RecordStuCopy>(RecordStuCopy.class);
        return util.exportExcel(list, "recordstuCopy");
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
    @RequiresPermissions("system:recordstuCopy:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecordStuCopy recordStuCopy)
    {
        return toAjax(recordStuCopyService.insertRecordStu(recordStuCopy));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{testStuId}")
    public String edit(@PathVariable("testStuId") Long testStuId, ModelMap mmap)
    {
        RecordStuCopy recordStuCopy = recordStuCopyService.selectRecordStuById(testStuId);
        mmap.put("recordStuCopy", recordStuCopy);
        return prefix + "/edit";
    }

//
//    @GetMapping("/edit/{recordStu}")
//    public String edit(Array rs, ModelMap mmap, @PathVariable String recordStu){
//        RecordStu rsCopy=recordStuService.selectRecordStuById(rs);
//        mmap.put("rsCopy",rsCopy);
//        return prefix + "/edit";
//    }


    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:recordstuCopy:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecordStuCopy recordStuCopy)
    {
        recordStuCopyService.updateTestStu(recordStuCopy);
        if(recordStuCopy.getPassOrNot()==1) {
            int  temp=recordStuCopyService.insertRecordStu(recordStuCopy);
            return toAjax(temp);
        }
        return toAjax(1);
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:recordstuCopy:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recordStuCopyService.deleteRecordStuByIds(ids));
    }
}
