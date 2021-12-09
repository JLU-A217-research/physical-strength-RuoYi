package com.ruoyi.project.system.user.controller;

import com.ruoyi.common.utils.CookieUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.config.service.IConfigService;
import com.ruoyi.project.system.menu.domain.Menu;
import com.ruoyi.project.system.menu.service.IMenuService;
import com.ruoyi.project.system.student.domain.StuInfo;
import com.ruoyi.project.system.student.service.IPrsnStudentService;
import com.ruoyi.project.system.teacher.domain.TeaInfo;
import com.ruoyi.project.system.teacher.service.IPrsnTeacherService;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.ruoyi.project.system.dict.utils.DictUtils.getDictLabel;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private IConfigService configService;

    @Autowired
    private RuoYiConfig ruoYiConfig;

    @Autowired
    private IPrsnStudentService prsnStudentService;

    @Autowired
    private IPrsnTeacherService prsnTeacherService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        User user = getSysUser();
        //取学校名称
        String schoolName = configService.selectConfigByKey("sys.schoolname");
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("schoolname", schoolName);
        mmap.put("sideTheme", configService.selectConfigByKey("sys.index.sideTheme"));
        mmap.put("skinName", configService.selectConfigByKey("sys.index.skinName"));
        mmap.put("ignoreFooter", configService.selectConfigByKey("sys.index.ignoreFooter"));
        mmap.put("copyrightYear", ruoYiConfig.getCopyrightYear());
        mmap.put("demoEnabled", ruoYiConfig.isDemoEnabled());

        // 菜单导航显示风格
        String menuStyle = configService.selectConfigByKey("sys.index.menuStyle");
        // 移动端，默认使左侧导航菜单，否则取默认配置
        String indexStyle = ServletUtils.checkAgentIsMobile(ServletUtils.getRequest().getHeader("User-Agent")) ? "index" : menuStyle;
        
        // 优先Cookie配置导航菜单
        Cookie[] cookies = ServletUtils.getRequest().getCookies();
        for (Cookie cookie : cookies)
        {
            if (StringUtils.isNotEmpty(cookie.getName()) && "nav-style".equalsIgnoreCase(cookie.getName()))
            {
                indexStyle = cookie.getValue();
                break;
            }
        }
        String webIndex = "topnav".equalsIgnoreCase(indexStyle) ? "index-topnav" : "index";
        return webIndex;
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin()
    {
        return "skin";
    }

    // 切换菜单
    @GetMapping("/system/menuStyle/{style}")
    public void menuStyle(@PathVariable String style, HttpServletResponse response)
    {
        CookieUtils.setCookie(response, "nav-style", style);
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", ruoYiConfig.getVersion());
        User user = getSysUser();
        mmap.put("user", user);
        Long userId = user.getUserId();
        if(user.getUserType().equals("0")){
            //学生信息
            //if(user.account_type == 0)
            //Long stu_id = user.getStu_id();
//        Long stu_id = 1L;

            StuInfo stuInfo = prsnStudentService.selectstuIdByAccountId(userId);
            String stuNation = getDictLabel("sys_user_nation",String.valueOf(stuInfo.getStuNationId()));
            int stuAge = getAge(stuInfo.getStuBirth());
            mmap.put("prsnStudent", stuInfo);
            mmap.put("stuNation", stuNation); //等荣荣的学生domain改完之后改这里
            mmap.put("stuAge", stuAge);
            return "main_student";
        }else{
            //教师信息
            //Long teacher_id = user.getTeacher_id();
//        Long teacher_id = 2L;
            TeaInfo teaInfo = prsnTeacherService.selectteaIdByAccountId(userId);
            String teacherJob = getDictLabel("teacher_job_id",String.valueOf(teaInfo.getTeacherJobId()));
//        String teacherJob = getDictLabel("teacher_job_id", "2");
            mmap.put("prsnTeacher", teaInfo);
            mmap.put("teacherJob", teacherJob);
            return "main";
        }



    }

    //年龄计算
    public int getAge(Date birthday){
        Calendar today = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        c.setTime(birthday);
        return (today.get(Calendar.YEAR) - c.get(Calendar.YEAR));
    }
}
