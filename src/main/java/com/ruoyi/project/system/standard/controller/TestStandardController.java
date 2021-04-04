package com.ruoyi.project.system.standard.controller;

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
import com.ruoyi.project.system.standard.domain.TestStandard;
import com.ruoyi.project.system.standard.service.ITestStandardService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 测试指标 Controller
 * 
 * @author ruoyi
 * @date 2021-03-29
 */
@Controller
@RequestMapping("/system/standard")
public class TestStandardController extends BaseController
{
    private String prefix = "system/standard";

    @Autowired
    private ITestStandardService testStandardService;

    @RequiresPermissions("system:standard:view")
    @GetMapping()
    public String standard()
    {
        return prefix + "/standard";
    }

    /**
     * 查询测试指标 列表
     */
    @RequiresPermissions("system:standard:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestStandard testStandard)
    {
        startPage();
        List<TestStandard> list = testStandardService.selectTestStandardList(testStandard);
        return getDataTable(list);
    }

    /**
     * 导出测试指标 列表
     */
    @RequiresPermissions("system:standard:export")
    @Log(title = "测试指标 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestStandard testStandard)
    {
        List<TestStandard> list = testStandardService.selectTestStandardList(testStandard);
        ExcelUtil<TestStandard> util = new ExcelUtil<TestStandard>(TestStandard.class);
        return util.exportExcel(list, "standard");
    }

    /**
     * 新增测试指标 
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存测试指标 
     */
    @RequiresPermissions("system:standard:add")
    @Log(title = "测试指标 ", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestStandard testStandard)
    {
        return toAjax(testStandardService.insertTestStandard(testStandard));
    }

    /**
     * 修改测试指标 
     */
    @GetMapping("/edit/{testStandardId}")
    public String edit(@PathVariable("testStandardId") Long testStandardId, ModelMap mmap)
    {
        TestStandard testStandard = testStandardService.selectTestStandardById(testStandardId);
        mmap.put("testStandard", testStandard);
        return prefix + "/edit";
    }

    /**
     * 修改保存测试指标 
     */
    @RequiresPermissions("system:standard:edit")
    @Log(title = "测试指标 ", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestStandard testStandard)
    {
        return toAjax(testStandardService.updateTestStandard(testStandard));
    }

    /**
     * 删除测试指标 
     */
    @RequiresPermissions("system:standard:remove")
    @Log(title = "测试指标 ", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testStandardService.deleteTestStandardByIds(ids));
    }
}
