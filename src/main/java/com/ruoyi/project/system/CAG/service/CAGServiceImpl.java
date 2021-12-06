package com.ruoyi.project.system.CAG.service;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.CAG.domain.CAG;
import com.ruoyi.project.system.CAG.mapper.CAGMapper;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.role.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Service
public class CAGServiceImpl implements ICAGService{
    @Autowired
    CAGMapper cagMapper;
    @Override
    public List<Dept> selectDeptList(Dept dept) {
        return null;
    }

    @Override
    public List<Ztree> selectCAGTree(CAG cag) {
        List<CAG> cagList = cagMapper.selectCAGList(cag);
        List<Ztree> ztrees = initZtree(cagList);
        return ztrees;
    }
    /**
     * 对象转部门树
     *
     * @param cagList 部门列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<CAG> cagList)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        HashSet<Long>enroll_years = new HashSet<Long>();
        for(CAG cag:cagList){
            enroll_years.add(cag.getEnrollYear());
        }
        Ztree ztree = new Ztree();
        ztree.setId(0L);
        ztree.setpId(0L);
        ztree.setName("吉林大学");
        ztrees.add(ztree);
        for(Long enroll_year : enroll_years){
            ztree = new Ztree();
            ztree.setId(enroll_year);
            ztree.setpId(0L);
            ztree.setName(""+enroll_year);
            ztree.setTitle(""+enroll_year);
            ztrees.add(ztree);
        }
        for (CAG cag : cagList)
        {
            ztree = new Ztree();
            ztree.setId(cag.getClassNo());
            ztree.setpId(cag.getEnrollYear());
            ztree.setName(""+cag.getClassNo());
            ztree.setTitle(""+cag.getClassNo());
            ztrees.add(ztree);
        }
        return ztrees;
    }




    @Override
    public List<Ztree> selectDeptTreeExcludeChild(Dept dept) {
        return null;
    }

    @Override
    public List<Ztree> roleDeptTreeData(Role role) {
        return null;
    }

    @Override
    public int selectDeptCount(Long parentId) {
        return 0;
    }

    @Override
    public boolean checkDeptExistUser(Long deptId) {
        return false;
    }

    @Override
    public int deleteDeptById(Long deptId) {
        return 0;
    }

    @Override
    public int insertDept(Dept dept) {
        return 0;
    }

    @Override
    public int updateDept(Dept dept) {
        return 0;
    }

    @Override
    public CAG selectCAGById(Long gradeClassId) {
        return cagMapper.selectCAGById(gradeClassId);
    }

    @Override
    public int selectNormalChildrenDeptById(Long deptId) {
        return 0;
    }

    @Override
    public String checkDeptNameUnique(Dept dept) {
        return null;
    }
}
