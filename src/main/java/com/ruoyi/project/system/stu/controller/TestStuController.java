package com.ruoyi.project.system.stu.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.stu.domain.TestStu;
import com.ruoyi.project.system.stu.service.ITestStuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 测试学生列 Controller
 * 
 * @author ruoyi
 * @date 2021-07-16
 */
@Controller
@RequestMapping("/system/stu")
public class TestStuController extends BaseController
{
    private String prefix = "system/stu";

    @Autowired
    private ITestStuService testStuService;

    @RequiresPermissions("system:stu:view")
    @GetMapping()
    public String stu()
    {
        return prefix + "/stu";
    }

    /**
     * 查询测试学生列 列表
     */
    @RequiresPermissions("system:stu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestStu testStu)
    {
        startPage();
        List<TestStu> list = testStuService.selectTestStuList(testStu);
        return getDataTable(list);
    }

    /**
     * 导出测试学生列 列表
     */
    @RequiresPermissions("system:stu:export")
    @Log(title = "测试学生列 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestStu testStu)
    {
        List<TestStu> list = testStuService.selectTestStuList(testStu);
        ExcelUtil<TestStu> util = new ExcelUtil<TestStu>(TestStu.class);
        return util.exportExcel(list, "stu");
    }

    /**
     * 新增测试学生列 
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存测试学生列 
     */
    @RequiresPermissions("system:stu:add")
    @Log(title = "测试学生列 ", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestStu testStu)
    {
        return toAjax(testStuService.insertTestStu(testStu));
    }

    /**
     * 修改测试学生列 
     */
    @GetMapping("/edit/{testStuId}")
    public String edit(@PathVariable("testStuId") Long testStuId, ModelMap mmap)
    {
        TestStu testStu = testStuService.selectTestStuById(testStuId);
        mmap.put("testStu", testStu);
        return prefix + "/edit";
    }

    /**
     * 修改保存测试学生列 
     */
    @RequiresPermissions("system:stu:edit")
    @Log(title = "测试学生列 ", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestStu testStu)
    {
        return toAjax(testStuService.updateTestStu(testStu));
    }

    /**
     * 删除测试学生列 
     */
    @RequiresPermissions("system:stu:remove")
    @Log(title = "测试学生列 ", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testStuService.deleteTestStuByIds(ids));
    }
}
