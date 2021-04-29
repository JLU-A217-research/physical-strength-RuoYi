package com.ruoyi.project.system.information.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.information.domain.Information;
import com.ruoyi.project.system.information.service.IInformationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消息Controller
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/information")
public class InformationController extends BaseController
{
    private String prefix = "system/information";

    @Autowired
    private IInformationService informationService;

    @RequiresPermissions("system:information:view")
    @GetMapping()
    public String information()
    {
        return prefix + "/information";
    }

    /**
     * 查询消息列表
     */
    @RequiresPermissions("system:information:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Information information)
    {
        startPage();
        List<Information> list = informationService.selectInformationList(information);
        return getDataTable(list);
    }

    /**
     * 导出消息列表
     */
    @RequiresPermissions("system:information:export")
    @Log(title = "消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Information information)
    {
        List<Information> list = informationService.selectInformationList(information);
        ExcelUtil<Information> util = new ExcelUtil<Information>(Information.class);
        return util.exportExcel(list, "information");
    }

    /**
     * 新增消息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存消息
     */
    @RequiresPermissions("system:information:add")
    @Log(title = "消息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Information information)
    {
        return toAjax(informationService.insertInformation(information));
    }

    /**
     * 修改消息
     */
    @GetMapping("/edit/{infoId}")
    public String edit(@PathVariable("infoId") Long infoId, ModelMap mmap)
    {
        Information information = informationService.selectInformationById(infoId);
        mmap.put("information", information);
        return prefix + "/edit";
    }

    /**
     * 修改保存消息
     */
    @RequiresPermissions("system:information:edit")
    @Log(title = "消息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Information information)
    {
        return toAjax(informationService.updateInformation(information));
    }

    /**
     * 删除消息
     */
    @RequiresPermissions("system:information:remove")
    @Log(title = "消息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(informationService.deleteInformationByIds(ids));
    }
}
