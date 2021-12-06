package com.ruoyi.project.system.item.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 体测项目 对象 test_item
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
public class TestItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private boolean flag=false;

    /** 体测项目ID */
    private Long testItemId;

    /** 体测项目名称 */
    @Excel(name = "体测项目名称")
    private String testItemName;

    /** 体测项目单位 */
    @Excel(name = "体测项目单位")
    private String testItemUnit;

    /** 体测结果-成绩相关性 0-负相关，1-正相关，2-其他 */
    @Excel(name = "体测结果-成绩相关性 0-负相关，1-正相关，2-其他")
    private Integer testScoreRelation;

    public void setTestItemId(Long testItemId)
    {
        this.testItemId = testItemId;
    }

    public Long getTestItemId()
    {
        return testItemId;
    }
    public void setTestItemName(String testItemName)
    {
        this.testItemName = testItemName;
    }

    public String getTestItemName()
    {
        return testItemName;
    }
    public void setTestItemUnit(String testItemUnit)
    {
        this.testItemUnit = testItemUnit;
    }

    public String getTestItemUnit()
    {
        return testItemUnit;
    }
    public void setTestScoreRelation(Integer testScoreRelation)
    {
        this.testScoreRelation = testScoreRelation;
    }

    public Integer getTestScoreRelation()
    {
        return testScoreRelation;
    }

    public void setFlag(boolean flag){
        this.flag=flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("testItemId", getTestItemId())
            .append("testItemName", getTestItemName())
            .append("testItemUnit", getTestItemUnit())
            .append("testScoreRelation", getTestScoreRelation())
            .toString();
    }
}
