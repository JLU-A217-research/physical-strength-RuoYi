package com.ruoyi.project.system.teacher.controller.Tea_Info;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.teacher.domain.PrsnTeacher;
import com.ruoyi.project.system.teacher.domain.TeaInfo;
import com.ruoyi.project.system.teacher.service.IPrsnTeacherService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

 

@Controller
@RequestMapping("/system/teacher/tea_info")
public class TeaInfoController extends BaseController
{
    private String prefix = "system/teacher/tea_info";

    @Autowired

    private IPrsnTeacherService prsnsTeacherService;

    @RequiresPermissions("system:teacher:tea_info:view")
    @GetMapping()

    public String tea_info(ModelMap mmap){
        startPage();
        User user = ShiroUtils.getSysUser();
        Long accountId= user.getUserId();
        Long account= Long.valueOf(2);
        TeaInfo teaInfo = prsnsTeacherService.selectteaIdByAccountId(account);

        mmap.put("prsnTeacher", teaInfo);
        return prefix + "/tea_info";
    }
    /**
     * 修改保存教师信息
     */
    @Log(title = "教师信息", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(PrsnTeacher prsnTeacher)
    {

        return toAjax(prsnsTeacherService.updatepartPrsnTeacher(prsnTeacher));
    }

}
