package com.ruoyi.project.system.information.mapper;

import com.ruoyi.project.system.information.domain.Information;

import java.util.List;

/**
 * 消息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public interface InformationMapper 
{
    /**
     * 查询消息
     * 
     * @param infoId 消息ID
     * @return 消息
     */
    public Information selectInformationById(Long infoId);

    /**
     * 查询消息列表
     * 
     * @param information 消息
     * @return 消息集合
     */
    public List<Information> selectInformationList(Information information);

    /**
     * 新增消息
     * 
     * @param information 消息
     * @return 结果
     */
    public int insertInformation(Information information);

    /**
     * 修改消息
     * 
     * @param information 消息
     * @return 结果
     */
    public int updateInformation(Information information);

    /**
     * 删除消息
     * 
     * @param infoId 消息ID
     * @return 结果
     */
    public int deleteInformationById(Long infoId);

    /**
     * 批量删除消息
     * 
     * @param infoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteInformationByIds(String[] infoIds);
}
