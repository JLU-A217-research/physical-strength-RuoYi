package com.ruoyi.project.system.user.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.shiro.service.PasswordService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.student.domain.StuInfo;
import com.ruoyi.project.system.student.service.IPrsnStudentService;
import com.ruoyi.project.system.teacher.domain.TeaInfo;
import com.ruoyi.project.system.teacher.service.IPrsnTeacherService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 个人信息 业务处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/user/info")
public class UserInfoController extends BaseController
{

    private String prefix_stu = "system/student/stu_info";
    private String prefix_tea = "system/teacher/tea_info";
    @Autowired
    private IPrsnStudentService prsnsStudentService;

    @Autowired
    private IPrsnTeacherService prsnsTeacherService;
    @GetMapping()
    public String user_info(ModelMap mmap) {
        startPage();
        User user = ShiroUtils.getSysUser();
        Long accountId= user.getUserId();
        mmap.put("user", user);
        //学生还是老师
        if(user.getUserType().equals("0")){
            StuInfo stuInfo=prsnsStudentService.selectstuIdByAccountId(accountId);
            mmap.put("prsnStudent", stuInfo);
            return prefix_stu + "/stu_info";
        }else {
            TeaInfo teaInfo = prsnsTeacherService.selectteaIdByAccountId(accountId);
            mmap.put("user", user);
            mmap.put("prsnTeacher", teaInfo);
            return prefix_tea + "/tea_info";
        }
    }





}
