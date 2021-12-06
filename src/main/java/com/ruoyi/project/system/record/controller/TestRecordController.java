package com.ruoyi.project.system.record.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.record.domain.TestRecord;
import com.ruoyi.project.system.record.service.ITestRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）Controller
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Controller
@RequestMapping("/system/record")
public class TestRecordController extends BaseController
{
    private String prefix = "system/record";

    @Autowired
    private ITestRecordService testRecordService;

    @RequiresPermissions("system:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）列表
     */
    @RequiresPermissions("system:record:add")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestRecord testRecord)
    {
        startPage();
        List<TestRecord> list = testRecordService.selectTestRecordList(testRecord);
        return getDataTable(list);
    }
     @RequiresPermissions("system:record:export")
    @Log(title = "体测记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestRecord testRecord)
    {
        List<TestRecord> list = testRecordService.selectTestRecordList(testRecord);
        ExcelUtil<TestRecord> util = new ExcelUtil<TestRecord>(TestRecord.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 新增测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @GetMapping("/addTree")
    public String add()
    {
//        mmap.put("items",testItemService.selectTestItemAll());
//        mmap.put("teachers",prsnTeacherService.selectPrsnTeacherAll());
        return prefix + "/addTree";
    }

    /**
     * 新增保存测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @RequiresPermissions("system:record:addTree")
    @Log(title = "体测记录", businessType = BusinessType.INSERT)
    @PostMapping("/addTree")
    @ResponseBody
    public AjaxResult addSave(TestRecord testRecord)
    {
        return toAjax(testRecordService.insertTestRecord(testRecord));
    }

    /**
     * 修改测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @GetMapping("/edit/{testRecordId}")
    public String edit(@PathVariable("testRecordId") Long testRecordId, ModelMap mmap)
    {
       TestRecord testRecord = testRecordService.selectTestRecordById(testRecordId);
        mmap.put("testRecord", testRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @RequiresPermissions("system:record:edit")
    @Log(title = "测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestRecord testRecord)
    {
        return toAjax(testRecordService.updateTestRecord(testRecord));
    }

    /**
     * 删除测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @RequiresPermissions("system:record:remove")
    @Log(title = "测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testRecordService.deleteTestRecordByIds(ids));
    }




}
