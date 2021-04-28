package com.ruoyi.project.system.student.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.user.domain.User;
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

@Controller
@RequestMapping("/system/student/stu_info")
public class StuInfoControllerr extends BaseController
{
    private String prefix = "system/student";

    @Autowired

    private IPrsnStudentService prsnsStudentService;

    @RequiresPermissions("system:student:stu_info:view")

    @GetMapping()
    public String stu_info(ModelMap mmap)
    {
        startPage();
        User user = ShiroUtils.getSysUser();
        Long accountId= user.getUserId();

        //通过userId找到stuid，通过stuId找学生信息
        //通过userId找到stuid，改controller，domain，service，serviceImp，Mapper，PrsnStudentMapper.xml
        PrsnStudent prsnStudent=prsnsStudentService.selectstuIdByAccountId(accountId);
//        PrsnStudent prsnStudent= prsnsStudentService.selectPrsnStudentById(stuId);

        mmap.put("prsnStudent", prsnStudent);
        return prefix + "/stu_info";
        }

//    /**
//     * 导出体测项目 列表
//     */
//    @RequiresPermissions("system:stu_info:export")
//    @Log(title = "体测项目 ", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(TestItem testItem)
//    {
//        List<TestItem> list = testItemService.selectTestItemList(testItem);
//        ExcelUtil<TestItem> util = new ExcelUtil<TestItem>(TestItem.class);
//        return util.exportExcel(list, "item");
//    }
//
//    /**
//     * 新增体测项目
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存体测项目
//     */
//    @RequiresPermissions("system:stu_info:add")
//    @Log(title = "体测项目 ", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(TestItem testItem)
//    {
//        return toAjax(testItemService.insertTestItem(testItem));
//    }
//
//    /**
//     * 修改体测项目
//     */
//    @GetMapping("/edit/{testItemId}")
//    public String edit(@PathVariable("testItemId") Long testItemId, ModelMap mmap)
//    {
//        TestItem testItem = testItemService.selectTestItemById(testItemId);
//        mmap.put("testItem", testItem);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存体测项目
//     */
//    @RequiresPermissions("system:stu_info:edit")
//    @Log(title = "体测项目 ", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(TestItem testItem)
//    {
//        return toAjax(testItemService.updateTestItem(testItem));
//    }
//
//    /**
//     * 删除体测项目
//     */
//    @RequiresPermissions("system:stu_info:remove")
//    @Log(title = "体测项目 ", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids)
//    {
//        return toAjax(testItemService.deleteTestItemByIds(ids));
//    }
}
