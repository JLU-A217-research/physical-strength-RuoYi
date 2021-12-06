package com.ruoyi.project.system.recordstuCopy.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.recordstuCopy.domain.RecordStuCopy;
import com.ruoyi.project.system.recordstuCopy.mapper.RecordStuCopyMapper;
import com.ruoyi.project.system.recordstuCopy.service.IRecordStuCopyService;
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
public class RecordStuCopyServiceImpl implements IRecordStuCopyService
{
    @Autowired
    private RecordStuCopyMapper recordStuCopyMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param testRecordId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public RecordStuCopy selectRecordStuById(Long testStuId)
    {
//        RecordStu rs=new RecordStu();
//        Long recordId=rs.getTestRecordIds();

        return recordStuCopyMapper.selectRecordStuById(testStuId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param recordStuCopy 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RecordStuCopy> selectRecordStuList(RecordStuCopy recordStuCopy)
    {
//        Long ids=recordStu.getTestRecordIds();
//        recordStu.setTestRecordIds(ids);
        return recordStuCopyMapper.selectRecordStuList(recordStuCopy);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param recordStu 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRecordStu(RecordStuCopy recordStuCopy)
    {
        return recordStuCopyMapper.insertRecordStu(recordStuCopy);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param recordStu 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRecordStu(RecordStuCopy recordStuCopy)
    {
        return recordStuCopyMapper.updateRecordStu(recordStuCopy);
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
        return recordStuCopyMapper.deleteRecordStuByIds(Convert.toStrArray(ids));
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
        return recordStuCopyMapper.deleteRecordStuById(testRecordId,stuId,testItemId);
    }

    @Override
    public int updateTestStu(RecordStuCopy recordStuCopy){
        return recordStuCopyMapper.updateTestStu(recordStuCopy);
    }
}
