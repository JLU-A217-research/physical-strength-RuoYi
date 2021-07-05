package com.ruoyi.project.classmanagement.classmanage.controller;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.config.service.IConfigService;
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
import com.ruoyi.project.classmanagement.classmanage.domain.ClassGradeInfo;
import com.ruoyi.project.classmanagement.classmanage.service.IClassGradeInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;


/**
 * 年班信息Controller
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
@Controller
@RequestMapping("/classmanagement/classmanage")
public class ClassGradeInfoController extends BaseController
{
    private String prefix = "classmanagement/classmanage";

    @Autowired
    private IClassGradeInfoService classGradeInfoService;

    @Autowired
    private IConfigService configService;

    @RequiresPermissions("classmanagement:classmanage:view")
    @GetMapping()
    public String classmanage()
    {
        return prefix + "/classmanage";
    }

//    int schoolGradeStart1 = Integer.parseInt(configService.selectConfigByKey("sys.schoolgradestart"));
//    mmap.put("schoolgradestart", configService.selectConfigByKey("sys.schoolgradestart"));


    public static int getSysYear(){
        Calendar date = Calendar.getInstance();
        int year = date.get(Calendar.YEAR);
        return year;
    }

    /**
     * 查询年班信息列表
     */
    @RequiresPermissions("classmanagement:classmanage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ClassGradeInfo classGradeInfo)
    {
        int schoolGradeStart = Integer.parseInt(configService.selectConfigByKey("sys.schoolgradestart"));
        startPage();
        List<ClassGradeInfo> list = classGradeInfoService.selectClassGradeInfoList(classGradeInfo);
        for (ClassGradeInfo x: list) {
            x.setClassGrade((long) (getSysYear() - x.getEnrollYear() + schoolGradeStart));
//            x.setClassGrade((long) (getSysYear() - x.getEnrollYear() + 1));
        }
        return getDataTable(list);
    }

    /**
     * 导出年班信息列表
     */
    @RequiresPermissions("classmanagement:classmanage:export")
    @Log(title = "年班信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClassGradeInfo classGradeInfo)
    {
        List<ClassGradeInfo> list = classGradeInfoService.selectClassGradeInfoList(classGradeInfo);
        ExcelUtil<ClassGradeInfo> util = new ExcelUtil<ClassGradeInfo>(ClassGradeInfo.class);
        return util.exportExcel(list, "classmanage");
    }

    /**
     * 新增年班信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存年班信息
     */
    @RequiresPermissions("classmanagement:classmanage:add")
    @Log(title = "年班信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ClassGradeInfo classGradeInfo)
    {
        return toAjax(classGradeInfoService.insertClassGradeInfo(classGradeInfo));
    }

    /**
     * 修改年班信息
     */
    @GetMapping("/edit/{gradeClassId}")
    public String edit(@PathVariable("gradeClassId") Long gradeClassId, ModelMap mmap)
    {
        ClassGradeInfo classGradeInfo = classGradeInfoService.selectClassGradeInfoById(gradeClassId);
        mmap.put("classGradeInfo", classGradeInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存年班信息
     */
    @RequiresPermissions("classmanagement:classmanage:edit")
    @Log(title = "年班信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ClassGradeInfo classGradeInfo)
    {
        return toAjax(classGradeInfoService.updateClassGradeInfo(classGradeInfo));
    }

    /**
     * 删除年班信息
     */
    @RequiresPermissions("classmanagement:classmanage:remove")
    @Log(title = "年班信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(classGradeInfoService.deleteClassGradeInfoByIds(ids));
    }
}
