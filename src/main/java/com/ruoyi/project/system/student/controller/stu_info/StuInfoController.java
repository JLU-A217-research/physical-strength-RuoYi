package com.ruoyi.project.system.student.controller.stu_info;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.student.domain.PrsnStudent;
import com.ruoyi.project.system.student.domain.StuInfo;
import com.ruoyi.project.system.student.service.IPrsnStudentService;
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
@RequestMapping("/system/student/stu_info")
public class StuInfoController extends BaseController
{
    private String prefix = "system/student/stu_info";

    @Autowired

    private IPrsnStudentService prsnsStudentService;

    @RequiresPermissions("system:student:stu_info:view")
    @GetMapping()
//    public String stu_info(){
//        return prefix + "/stu_info";
//    }
//
//    @RequiresPermissions("system:student:list")
//    @PostMapping("/list")
//    @ResponseBody
//    public TableDataInfo list()
//    {
//        startPage();
//        User user = ShiroUtils.getSysUser();
//        Long accountId= user.getUserId();
//
//        //通过userId找到stuid，通过stuId找学生信息
//        //通过userId找到stuid，改controller，domain，service，serviceImp，Mapper，PrsnStudentMapper.xml
//        PrsnStudent prsnStudent=prsnsStudentService.selectstuIdByAccountId(accountId);
////        PrsnStudent prsnStudent= prsnsStudentService.selectPrsnStudentById(stuId);
//
//        List<PrsnStudent> list = new ArrayList<PrsnStudent>();
//        list.add(prsnStudent);
//        return getDataTable(list);
//
////        mmap.put("prsnStudent", prsnStudent);
//        }
    public String stu_info(ModelMap mmap){
        startPage();
        User user = ShiroUtils.getSysUser();
        Long accountId= user.getUserId();
        StuInfo stuInfo=prsnsStudentService.selectstuIdByAccountId(accountId);
        mmap.put("user", user);
        mmap.put("prsnStudent", stuInfo);
        return prefix + "/stu_info";
    }



    /**
     * 修改保存学生信息
     */
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(PrsnStudent prsnStudent)
    {

        return toAjax(prsnsStudentService.updatepartPrsnStudent(prsnStudent));
    }

}
