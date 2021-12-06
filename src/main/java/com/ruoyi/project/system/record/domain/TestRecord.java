package com.ruoyi.project.system.record.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.classmanagement.classmanage.domain.ClassGradeInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）对象 test_record
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public class TestRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 测试记录ID */
    private Long testRecordId;

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    private String str1;

    public Long getGradeClassId() {
        return gradeClassId;
    }

    public void setGradeClassId(Long gradeClassId) {
        this.gradeClassId = gradeClassId;
    }

    public Long getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(Long enrollYear) {
        this.enrollYear = enrollYear;
    }

    private Long enrollYear;

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    private String classNo;
    /*年班ID*/
    private Long gradeClassId;

    private ClassGradeInfo classGradeInfo;
    public ClassGradeInfo getClassGradeInfo(){
        if (classGradeInfo==null){
            classGradeInfo=new ClassGradeInfo();
        }
        return classGradeInfo;
    }

    /** 体测/补测ID（字典） 0-体测，1-补测 */
    @Excel(name = "体测/补测ID", readConverterExp = "字=典")
    private Long testOrSupId;

    /** 测试名称 */
    @Excel(name = "体测名称")
    private String testName;

    /** 测试时间 */
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testTime;

    /** 测试场所ID（字典） */
    @Excel(name = "场所", readConverterExp = "字=典")
    private Long testSiteIdCopy;

    public Long[] getTestSiteIds() {
        return testSiteIds;
    }

    public void setTestSiteIds(Long[] testSiteIds) {
        this.testSiteIds = testSiteIds;
    }

    private Long[] testSiteIds;

    public String getTestSite() {
        return testSite;
    }
    //testSite用于select中的地址显示
    public void setTestSite(String testSite) {
        this.testSite = testSite;
    }

    private String testSite;




    /** 体测年级班级*/
    @Excel(name = "体测年级班级")
    private String  classGradeCopy;

    /** 体测项目*/
    @Excel(name = "体测项目")
    private String testItemCopy;

    public String getTestItemName() {
        return testItemName;
    }

    public void setTestItemName(String testItemName) {
        this.testItemName = testItemName;
    }

    private String testItemName;


    /** 完成状态 0-未完成，1-完成 */
    @Excel(name = "完成状态 0-未完成，1-完成")
    private Long testStatus;


    /** 接收通知的老师*/
    @Excel(name = "接收通知的老师")
    private String teacherNameCopy;

    public Long itemIds;

    public Long[] testItemIds;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long stuId;


    public Long getTeacherIds() {
        return teacherIds;
    }

    public void setTeacherIds(Long teacherIds) {
        this.teacherIds = teacherIds;
    }

    private Long teacherIds;

    public Long[] getPrsnTeacherIds() {
        return prsnTeacherIds;
    }

    public void setPrsnTeacherIds(Long[] prsnTeacherIds) {
        this.prsnTeacherIds = prsnTeacherIds;
    }

    private Long[] prsnTeacherIds;

    public Long[] getTestItemIds() {
        return testItemIds;
    }

    public void setTestItemIds(Long[] testItemIds) {
        this.testItemIds = testItemIds;
    }


    public Long getItemIds() {
        return itemIds;
    }

    public void setItemIds(Long itemIds) {
        this.itemIds = itemIds;
    }
    public void setTestRecordId(Long testRecordId)
    {
        this.testRecordId = testRecordId;
    }

    public Long getTestRecordId()
    {
        return testRecordId;
    }
    public void setTestOrSupId(Long testOrSupId)
    {
        this.testOrSupId = testOrSupId;
    }

    public Long getTestOrSupId()
    {
        return testOrSupId;
    }
    public void setTestName(String testName)
    {
        this.testName = testName;
    }

    public String getTestName()
    {
        return testName;
    }
    public void setTestTime(Date testTime)
    {
        this.testTime = testTime;
    }

    public Date getTestTime()
    {
        return testTime;
    }
    public void setTestSiteId(Long testSiteIdCopy)
    {
        this.testSiteIdCopy = testSiteIdCopy;
    }

    public Long getTestSiteId()
    {
        return testSiteIdCopy;
    }
    public void setTestStatus(Long testStatus)
    {
        this.testStatus = testStatus;
    }

    public Long getTestStatus()
    {
        return testStatus;
    }

    public String getTestItem() {
        return testItemCopy;
    }

    public void setTestItem(String testItemCopy) {
        this.testItemCopy = testItemCopy;
    }


    public String getClassGrade() {
        return classGradeCopy;
    }

    public void setClassGrade(String classGradeCopy) {
        this.classGradeCopy = classGradeCopy;
    }
    public String getTeacherNameCopy() {
        return teacherNameCopy;
    }

    public void setTeacherNameCopy(String teacherNameCopy) {
        this.teacherNameCopy = teacherNameCopy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("testRecordId", getTestRecordId())
            .append("testOrSupId", getTestOrSupId())
            .append("testName", getTestName())
            .append("testTime", getTestTime())
            .append("classGradeCopy",getClassGrade())
            .append("testItemCopy",getTestItem())
            .append("testItemName",getTestItemName())
            .append("testSiteIdCopy", getTestSiteId())
            .append("testSite",getTestSite())
            .append("teacherNameCopy",getTeacherNameCopy())
            .append("testStatus", getTestStatus())
            .append("itemIds",getItemIds())
            .append("testItemIds",getTestItemIds())
            .append("teacherIds",getTestItemIds())
            .append("prsnTeacherIds",getPrsnTeacherIds())
            .append("gradeClassId",getGradeClassId())
            .append("classGradeInfo",getGradeClassId())
            .append("str1",getStr1())
             .append("enrollYear",getEnrollYear())
            .append("classNo",getClassNo())
            .append("stuId",getStuId())
            .toString();
    }
}
