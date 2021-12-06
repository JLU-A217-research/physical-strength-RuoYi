package com.ruoyi.project.system.item.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.item.domain.TestItem;
import com.ruoyi.project.system.item.service.ITestItemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 体测项目 Controller
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
@Controller
@RequestMapping("/system/item")
public class TestItemController extends BaseController
{
    private String prefix = "system/item";

    @Autowired
    private ITestItemService testItemService;

    @RequiresPermissions("system:item:view")
    @GetMapping()
    public String item()
    {
        return prefix + "/item";
    }

    /**
     * 查询体测项目 列表
     */
    @RequiresPermissions("system:item:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestItem testItem)
    {
        startPage();
        List<TestItem> list = testItemService.selectTestItemList(testItem);
        return getDataTable(list);
    }

    /**
     * 导出体测项目 列表
     */
    @RequiresPermissions("system:item:export")
    @Log(title = "体测项目 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestItem testItem)
    {
        List<TestItem> list = testItemService.selectTestItemList(testItem);
        ExcelUtil<TestItem> util = new ExcelUtil<TestItem>(TestItem.class);
        return util.exportExcel(list, "item");
    }

    /**
     * 新增体测项目 
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存体测项目 
     */
    @RequiresPermissions("system:item:add")
    @Log(title = "体测项目 ", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestItem testItem)
    {
        return toAjax(testItemService.insertTestItem(testItem));
    }

    /**
     * 修改体测项目 
     */
    @GetMapping("/edit/{testItemId}")
    public String edit(@PathVariable("testItemId") Long testItemId, ModelMap mmap)
    {
        TestItem testItem = testItemService.selectTestItemById(testItemId);
        mmap.put("testItem", testItem);
        return prefix + "/edit";
    }

    /**
     * 修改保存体测项目 
     */
    @RequiresPermissions("system:item:edit")
    @Log(title = "体测项目 ", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestItem testItem)
    {
        return toAjax(testItemService.updateTestItem(testItem));
    }

    /**
     * 删除体测项目 
     */
    @RequiresPermissions("system:item:remove")
    @Log(title = "体测项目 ", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testItemService.deleteTestItemByIds(ids));
    }
}
