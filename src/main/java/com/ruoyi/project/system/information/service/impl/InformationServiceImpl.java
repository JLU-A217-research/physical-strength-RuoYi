package com.ruoyi.project.system.information.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.system.information.domain.Information;
import com.ruoyi.project.system.information.mapper.InformationMapper;
import com.ruoyi.project.system.information.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
@Service
public class InformationServiceImpl implements IInformationService 
{
    @Autowired
    private InformationMapper informationMapper;

    /**
     * 查询消息
     * 
     * @param infoId 消息ID
     * @return 消息
     */
    @Override
    public Information selectInformationById(Long infoId)
    {
        return informationMapper.selectInformationById(infoId);
    }

    /**
     * 查询消息列表
     * 
     * @param information 消息
     * @return 消息
     */
    @Override
    public List<Information> selectInformationList(Information information)
    {
        return informationMapper.selectInformationList(information);
    }

    /**
     * 新增消息
     * 
     * @param information 消息
     * @return 结果
     */
    @Override
    public int insertInformation(Information information)
    {
        return informationMapper.insertInformation(information);
    }

    /**
     * 修改消息
     * 
     * @param information 消息
     * @return 结果
     */
    @Override
    public int updateInformation(Information information)
    {
        return informationMapper.updateInformation(information);
    }

    /**
     * 删除消息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteInformationByIds(String ids)
    {
        return informationMapper.deleteInformationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除消息信息
     * 
     * @param infoId 消息ID
     * @return 结果
     */
    @Override
    public int deleteInformationById(Long infoId)
    {
        return informationMapper.deleteInformationById(infoId);
    }
}
