package com.ruoyi.project.system.information.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 消息对象 information
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public class Information extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消息ID */
    private Long infoId;

    /** 发送人ID */
    private Long sendId;

    @Excel(name = "发送方")
    private String sendName;

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    /** 接收人ID */
    private Long receiveId;

    /** 发送时间 */
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendTime;

    /** 阅读状态 */
    @Excel(name = "阅读状态", readConverterExp = "0=未读,1=已读")
    private String readStatus;

    /** 消息类型 */
    @Excel(name = "消息类型", readConverterExp = "0=体测通知,1=申请结果")
    private String infoType;

    /** 消息主题 */
    @Excel(name = "消息主题")
    private String infoTheme;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String infoContent;

    public void setInfoId(Long infoId)
    {
        this.infoId = infoId;
    }

    public Long getInfoId()
    {
        return infoId;
    }
    public void setSendId(Long sendId)
    {
        this.sendId = sendId;
    }

    public Long getSendId()
    {
        return sendId;
    }
    public void setReceiveId(Long receiveId)
    {
        this.receiveId = receiveId;
    }

    public Long getReceiveId()
    {
        return receiveId;
    }
    public void setSendTime(Date sendTime)
    {
        this.sendTime = sendTime;
    }

    public Date getSendTime()
    {
        return sendTime;
    }
    public void setReadStatus(String readStatus)
    {
        this.readStatus = readStatus;
    }

    public String getReadStatus()
    {
        return readStatus;
    }
    public void setInfoType(String infoType)
    {
        this.infoType = infoType;
    }

    public String getInfoType()
    {
        return infoType;
    }
    public void setInfoTheme(String infoTheme)
    {
        this.infoTheme = infoTheme;
    }

    public String getInfoTheme()
    {
        return infoTheme;
    }
    public void setInfoContent(String infoContent)
    {
        this.infoContent = infoContent;
    }

    public String getInfoContent()
    {
        return infoContent;
    }

    @Override
    public String toString() {
        return "Information{" +
                "infoId=" + infoId +
                ", sendId=" + sendId +
                ", sendName='" + sendName + '\'' +
                ", receiveId=" + receiveId +
                ", sendTime=" + sendTime +
                ", readStatus='" + readStatus + '\'' +
                ", infoType='" + infoType + '\'' +
                ", infoTheme='" + infoTheme + '\'' +
                ", infoContent='" + infoContent + '\'' +
                '}';
    }
}
