package com.ruoyi.project.system.relation.controller;

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
import com.ruoyi.project.system.relation.domain.TestGradeSexRelation;
import com.ruoyi.project.system.relation.service.ITestGradeSexRelationService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 年级-性别-测试项目关系 Controller
 * 
 * @author ruoyi
 * @date 2021-03-24
 */
@Controller
@RequestMapping("/system/relation")
public class TestGradeSexRelationController extends BaseController
{
    private String prefix = "system/relation";

    @Autowired
    private ITestGradeSexRelationService testGradeSexRelationService;

    @RequiresPermissions("system:relation:view")
    @GetMapping()
    public String relation()
    {
        return prefix + "/relation";
    }

    /**
     * 查询年级-性别-测试项目关系 列表
     */
    @RequiresPermissions("system:relation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestGradeSexRelation testGradeSexRelation)
    {
        startPage();
        List<TestGradeSexRelation> list = testGradeSexRelationService.selectTestGradeSexRelationList(testGradeSexRelation);
        return getDataTable(list);
    }

    /**
     * 导出年级-性别-测试项目关系 列表
     */
    @RequiresPermissions("system:relation:export")
    @Log(title = "年级-性别-测试项目关系 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestGradeSexRelation testGradeSexRelation)
    {
        List<TestGradeSexRelation> list = testGradeSexRelationService.selectTestGradeSexRelationList(testGradeSexRelation);
        ExcelUtil<TestGradeSexRelation> util = new ExcelUtil<TestGradeSexRelation>(TestGradeSexRelation.class);
        return util.exportExcel(list, "relation");
    }

    /**
     * 新增年级-性别-测试项目关系 
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存年级-性别-测试项目关系 
     */
    @RequiresPermissions("system:relation:add")
    @Log(title = "年级-性别-测试项目关系 ", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestGradeSexRelation testGradeSexRelation)
    {
        return toAjax(testGradeSexRelationService.insertTestGradeSexRelation(testGradeSexRelation));
    }

    /**
     * 修改年级-性别-测试项目关系 
     */
    @GetMapping("/edit/{tgsId}")
    public String edit(@PathVariable("tgsId") Long tgsId, ModelMap mmap)
    {
        TestGradeSexRelation testGradeSexRelation = testGradeSexRelationService.selectTestGradeSexRelationById(tgsId);
        mmap.put("testGradeSexRelation", testGradeSexRelation);
        return prefix + "/edit";
    }

    /**
     * 修改保存年级-性别-测试项目关系 
     */
    @RequiresPermissions("system:relation:edit")
    @Log(title = "年级-性别-测试项目关系 ", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestGradeSexRelation testGradeSexRelation)
    {
        return toAjax(testGradeSexRelationService.updateTestGradeSexRelation(testGradeSexRelation));
    }

    /**
     * 删除年级-性别-测试项目关系 
     */
    @RequiresPermissions("system:relation:remove")
    @Log(title = "年级-性别-测试项目关系 ", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testGradeSexRelationService.deleteTestGradeSexRelationByIds(ids));
    }
}
