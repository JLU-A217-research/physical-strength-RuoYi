package com.ruoyi.project.system.student.controller;

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
import com.ruoyi.project.system.student.domain.PrsnStudent;
import com.ruoyi.project.system.student.service.IPrsnStudentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 学生信息 Controller
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
@Controller
@RequestMapping("/system/student")
public class PrsnStudentController extends BaseController
{
    private String prefix = "system/student";

    @Autowired
    private IPrsnStudentService prsnStudentService;

    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student()
    {
        return prefix + "/student";
    }

    /**
     * 查询学生信息 列表
     */
    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PrsnStudent prsnStudent)
    {
        startPage();
        List<PrsnStudent> list = prsnStudentService.selectPrsnStudentList(prsnStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生信息 列表
     */
    @RequiresPermissions("system:student:export")
    @Log(title = "学生信息 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PrsnStudent prsnStudent)
    {
        List<PrsnStudent> list = prsnStudentService.selectPrsnStudentList(prsnStudent);
        ExcelUtil<PrsnStudent> util = new ExcelUtil<PrsnStudent>(PrsnStudent.class);
        return util.exportExcel(list, "student");
    }

    /**
     * 新增学生信息 
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生信息 
     */
    @RequiresPermissions("system:student:add")
    @Log(title = "学生信息 ", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PrsnStudent prsnStudent)
    {
        return toAjax(prsnStudentService.insertPrsnStudent(prsnStudent));
    }

    /**
     * 修改学生信息 
     */
    @GetMapping("/edit/{stuId}")
    public String edit(@PathVariable("stuId") Long stuId, ModelMap mmap)
    {
        PrsnStudent prsnStudent = prsnStudentService.selectPrsnStudentById(stuId);
        mmap.put("prsnStudent", prsnStudent);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生信息 
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "学生信息 ", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PrsnStudent prsnStudent)
    {
        return toAjax(prsnStudentService.updatePrsnStudent(prsnStudent));
    }

    /**
     * 删除学生信息 
     */
    @RequiresPermissions("system:student:remove")
    @Log(title = "学生信息 ", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(prsnStudentService.deletePrsnStudentByIds(ids));
    }
}
