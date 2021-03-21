package com.ruoyi.project.system.student.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.student.mapper.PrsnStudentMapper;
import com.ruoyi.project.system.student.domain.PrsnStudent;
import com.ruoyi.project.system.student.service.IPrsnStudentService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 学生信息 Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
@Service
public class PrsnStudentServiceImpl implements IPrsnStudentService 
{
    @Autowired
    private PrsnStudentMapper prsnStudentMapper;

    /**
     * 查询学生信息 
     * 
     * @param stuId 学生信息 ID
     * @return 学生信息 
     */
    @Override
    public PrsnStudent selectPrsnStudentById(Long stuId)
    {
        return prsnStudentMapper.selectPrsnStudentById(stuId);
    }

    /**
     * 查询学生信息 列表
     * 
     * @param prsnStudent 学生信息 
     * @return 学生信息 
     */
    @Override
    public List<PrsnStudent> selectPrsnStudentList(PrsnStudent prsnStudent)
    {
        return prsnStudentMapper.selectPrsnStudentList(prsnStudent);
    }

    /**
     * 新增学生信息 
     * 
     * @param prsnStudent 学生信息 
     * @return 结果
     */
    @Override
    public int insertPrsnStudent(PrsnStudent prsnStudent)
    {
        return prsnStudentMapper.insertPrsnStudent(prsnStudent);
    }

    /**
     * 修改学生信息 
     * 
     * @param prsnStudent 学生信息 
     * @return 结果
     */
    @Override
    public int updatePrsnStudent(PrsnStudent prsnStudent)
    {
        return prsnStudentMapper.updatePrsnStudent(prsnStudent);
    }

    /**
     * 删除学生信息 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePrsnStudentByIds(String ids)
    {
        return prsnStudentMapper.deletePrsnStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生信息 信息
     * 
     * @param stuId 学生信息 ID
     * @return 结果
     */
    @Override
    public int deletePrsnStudentById(Long stuId)
    {
        return prsnStudentMapper.deletePrsnStudentById(stuId);
    }
}
