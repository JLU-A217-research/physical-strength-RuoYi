package com.ruoyi.project.system.recordstu.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.recordstu.domain.RecordStu;
import com.ruoyi.project.system.recordstu.mapper.RecordStuMapper;
import com.ruoyi.project.system.recordstu.service.IRecordStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-26
 */
@Service
public class RecordStuServiceImpl implements IRecordStuService 
{
    @Autowired
    private RecordStuMapper recordStuMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param testRecordId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public RecordStu selectRecordStuById(Long testStuId)
    {
//        RecordStu rs=new RecordStu();
//        Long recordId=rs.getTestRecordIds();

        return recordStuMapper.selectRecordStuById(testStuId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param recordStu 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RecordStu> selectRecordStuList(RecordStu recordStu)
    {
//        Long ids=recordStu.getTestRecordIds();
//        recordStu.setTestRecordIds(ids);
        return recordStuMapper.selectRecordStuList(recordStu);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param recordStu 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRecordStu(RecordStu recordStu)
    {

        return recordStuMapper.insertRecordStu(recordStu);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param recordStu 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRecordStu(RecordStu recordStu)
    {
        return recordStuMapper.updateRecordStu(recordStu);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRecordStuByIds(String ids)
    {
        return recordStuMapper.deleteRecordStuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param testRecordId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRecordStuById(String testRecordId,String stuId,String testItemId)
    {
        return recordStuMapper.deleteRecordStuById(testRecordId,stuId,testItemId);
    }

    @Override
    public int updateTestStu(RecordStu recordStu){
        return recordStuMapper.updateTestStu(recordStu);
    }

}
