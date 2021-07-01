package com.ruoyi.project.system.config.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.config.domain.Config;
import com.ruoyi.project.system.config.service.IConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 参数配置 信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/loginSetting")
public class LoginSettingController extends BaseController
{
    private String prefix = "system/config";

    @Autowired
    private IConfigService configService;


    @RequiresPermissions("system:loginSetting:view")
    @GetMapping()
    public String loginSetting()
    {
        return prefix + "/loginSetting";
    }


    /**
     * 新增保存参数配置
     */
    @RequiresPermissions("system:config:add")
    @Log(title = "参数管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Config config)
    {
        if (UserConstants.CONFIG_KEY_NOT_UNIQUE.equals(configService.checkConfigKeyUnique(config)))
        {
            return error("新增参数'" + config.getConfigName() + "'失败，参数键名已存在");
        }
        return toAjax(configService.insertConfig(config));
    }




    @Log(title = "登录设置", businessType = BusinessType.UPDATE)
    @PostMapping("/Setting")
    @ResponseBody
    public AjaxResult editSave(Config config)
    {
        config.setConfigId(10L);
        config.setConfigKey("sys.school.name");
        return toAjax(configService.updateConfig(config));
    }


}
