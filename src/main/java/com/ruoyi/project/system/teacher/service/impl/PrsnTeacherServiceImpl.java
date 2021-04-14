package com.ruoyi.project.system.teacher.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.teacher.mapper.PrsnTeacherMapper;
import com.ruoyi.project.system.teacher.domain.PrsnTeacher;
import com.ruoyi.project.system.teacher.service.IPrsnTeacherService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 教师信息 Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
@Service
public class PrsnTeacherServiceImpl implements IPrsnTeacherService 
{
    @Autowired
    private PrsnTeacherMapper prsnTeacherMapper;

    /**
     * 查询教师信息 
     * 
     * @param teacherId 教师信息 ID
     * @return 教师信息 
     */
    @Override
    public PrsnTeacher selectPrsnTeacherById(Long teacherId)
    {
        return prsnTeacherMapper.selectPrsnTeacherById(teacherId);
    }

    /**
     * 查询教师信息 列表
     * 
     * @param prsnTeacher 教师信息 
     * @return 教师信息 
     */
    @Override
    public List<PrsnTeacher> selectPrsnTeacherList(PrsnTeacher prsnTeacher)
    {
        return prsnTeacherMapper.selectPrsnTeacherList(prsnTeacher);
    }

    /**
     * 新增教师信息 
     * 
     * @param prsnTeacher 教师信息 
     * @return 结果
     */
    @Override
    public int insertPrsnTeacher(PrsnTeacher prsnTeacher)
    {
        return prsnTeacherMapper.insertPrsnTeacher(prsnTeacher);
    }

    /**
     * 修改教师信息 
     * 
     * @param prsnTeacher 教师信息 
     * @return 结果
     */
    @Override
    public int updatePrsnTeacher(PrsnTeacher prsnTeacher)
    {
        return prsnTeacherMapper.updatePrsnTeacher(prsnTeacher);
    }

    /**
     * 删除教师信息 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePrsnTeacherByIds(String ids)
    {
        return prsnTeacherMapper.deletePrsnTeacherByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教师信息 信息
     * 
     * @param teacherId 教师信息 ID
     * @return 结果
     */
    @Override
    public int deletePrsnTeacherById(Long teacherId)
    {
        return prsnTeacherMapper.deletePrsnTeacherById(teacherId);
    }
}
