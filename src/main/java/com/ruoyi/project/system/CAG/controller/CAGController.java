package com.ruoyi.project.system.CAG.controller;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.CAG.domain.CAG;
import com.ruoyi.project.system.CAG.service.ICAGService;
import com.ruoyi.project.system.dept.domain.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/system/CAG")
public class CAGController {
    private String prefix = "system/CAG";

    @Autowired
    private ICAGService CAGService;
    /**
     * 选择班级
     *
     * @param gradeClassId 班级ID
     * @param excludeId 排除ID
     */
    @GetMapping(value = { "/selectCAGTree/{gradeClassId}", "/selectCAGTree/{gradeClassId}/{excludeId}" })
    public String selectDeptTree(@PathVariable("gradeClassId") Long gradeClassId,
                                 @PathVariable(value = "excludeId", required = false) String excludeId, ModelMap mmap)
    {
        mmap.put("CAG", CAGService.selectCAGById(gradeClassId));
        mmap.put("excludeId", excludeId);
        return prefix + "/tree";
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = CAGService.selectCAGTree(new CAG());
        return ztrees;
    }

    /**
     * 加载部门列表树（排除下级）
     */
    @GetMapping("/treeData/{excludeId}")
    @ResponseBody
    public List<Ztree> treeDataExcludeChild(@PathVariable(value = "excludeId", required = false) Long excludeId)
    {
        Dept dept = new Dept();
        dept.setDeptId(excludeId);
        List<Ztree> ztrees = CAGService.selectDeptTreeExcludeChild(dept);
        return ztrees;
    }
}
