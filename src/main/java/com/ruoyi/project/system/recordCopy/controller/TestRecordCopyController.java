package com.ruoyi.project.system.recordCopy.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.item.service.ITestItemService;
import com.ruoyi.project.system.recordCopy.domain.TestRecordCopy;
import com.ruoyi.project.system.recordCopy.service.ITestRecordCopyService;
import com.ruoyi.project.system.teacher.service.IPrsnTeacherService;
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
@RequestMapping("/system/recordCopy")
public class TestRecordCopyController extends BaseController
{
    private String prefix = "system/recordCopy";

    @Autowired
    private ITestRecordCopyService testRecordCopyService;

    @Autowired
    private ITestItemService testItemService;

    @Autowired
    private IPrsnTeacherService prsnTeacherService;

    @RequiresPermissions("system:recordCopy:view")
    @GetMapping()
    public String recordCopy()
    {
        return prefix + "/recordCopy";
    }

    /**
     * 查询测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）列表
     */
    @RequiresPermissions("system:recordCopy")    //????????
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestRecordCopy testRecordCopy)
    {
        startPage();
        List<TestRecordCopy> list = testRecordCopyService.selectTestRecordCopyList(testRecordCopy);
        return getDataTable(list);
    }
     @RequiresPermissions("system:recordCopy:export")
    @Log(title = "体测记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestRecordCopy testRecordCopy)
    {
        List<TestRecordCopy> list = testRecordCopyService.selectTestRecordCopyList(testRecordCopy);
        ExcelUtil<TestRecordCopy> util = new ExcelUtil<TestRecordCopy>(TestRecordCopy.class);
        return util.exportExcel(list, "recordCopy");
    }

    /**
     * 新增测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @GetMapping("/addTree")
    public String add(ModelMap mmap)
    {
        mmap.put("items",testItemService.selectTestItemAll());
        mmap.put("teachers",prsnTeacherService.selectPrsnTeacherAll());
        return prefix + "/addTree";
    }

    /**
     * 新增保存测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @RequiresPermissions("system:recordCopy:addTree")
    @Log(title = "体测记录", businessType = BusinessType.INSERT)
    @PostMapping("/addTree")
    @ResponseBody
    public AjaxResult addSave(TestRecordCopy testRecordCopy)
    {
        return toAjax(testRecordCopyService.insertTestRecordCopy(testRecordCopy));
    }


    /**
     * 修改测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @GetMapping("/edit/{testRecordId}")
    public String edit(@PathVariable("testRecordId") Long testRecordId, ModelMap mmap)
    {
        TestRecordCopy testRecordCopy = testRecordCopyService.selectTestRecordCopyById(testRecordId);
        mmap.put("testRecordCopy", testRecordCopy);
//        mmap.put("items",testItemService.selectTestItemByTestRecordId(testRecordId));
//        mmap.put("teachers",prsnTeacherService.selectPrsnTeacherByTestRecordId(testRecordId));
        return prefix + "/edit";
    }

    /**
     * 修改保存测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @RequiresPermissions("system:recordCopy:edit")
    @Log(title = "测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestRecordCopy testRecordCopy)
    {
        return toAjax(testRecordCopyService.updateTestRecordCopy(testRecordCopy));
    }

    /**
     * 删除测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）
     */
    @RequiresPermissions("system:recordCopy:remove")
    @Log(title = "测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testRecordCopyService.deleteTestRecordCopyByIds(ids));
    }




}
