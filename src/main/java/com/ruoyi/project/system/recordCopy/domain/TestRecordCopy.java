package com.ruoyi.project.system.recordCopy.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.project.classmanagement.classmanage.domain.ClassGradeInfo;

import java.util.Arrays;
import java.util.Date;

/**
 * 测试记录 对应Demo: 体测管理->新建补测（下边的体测记录）对象 test_record
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public class TestRecordCopy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 测试记录ID */
    private Long testRecordId;

    public Long getTestRecordIdCopy() {
        return testRecordIdCopy;
    }

    public void setTestRecordIdCopy(Long testRecordIdCopy) {
        this.testRecordIdCopy = testRecordIdCopy;
    }

    private Long testRecordIdCopy;

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String str1;

    public Long getGradeClassId() {
        return gradeClassId;
    }

    public void setGradeClassId(Long gradeClassId) {
        this.gradeClassId = gradeClassId;
    }

    /*年班ID*/
    private Long gradeClassId;

    public void setClassGradeInfo(ClassGradeInfo classGradeInfo) {
        this.classGradeInfo = classGradeInfo;
    }



    /*年班对象*/
//    @Excel({
//            @Excel(name="年级",targetAttr = "classGrade",type = Excel.Type.EXPORT),
//            @Excel(name = "班级ID",targetAttr = "classID",type = Excel.Type.EXPORT)
//    })
    private ClassGradeInfo classGradeInfo;
    public ClassGradeInfo getClassGradeInfo(){
        if (classGradeInfo==null){
            classGradeInfo=new ClassGradeInfo();
        }
        return classGradeInfo;
    }

    public Long getItemIds() {
        return itemIds;
    }

    public void setItemIds(Long itemIds) {
        this.itemIds = itemIds;
    }

    private Long itemIds;
    private Long[] testItemIds;

    public Long getTeacherIds() {
        return teacherIds;
    }

    public void setTeacherIds(Long teacherIds) {
        this.teacherIds = teacherIds;
    }

    private Long teacherIds;

    private Long [] prsnTeacherIds;

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

    public Long[] getPrsnTeacherIds() {
        return prsnTeacherIds;
    }

    public void setPrsnTeacherIds(Long[] prsnTeacherIds) {
        this.prsnTeacherIds = prsnTeacherIds;
    }

    @Override
    public String toString() {
        return "TestRecordCopy{" +
                " testRecordId=" + testRecordId +
                ", itemIds=" + itemIds +
                ", testItemIds=" + Arrays.toString(testItemIds) +
//                ",testItemIds=" + testItemIds+
                ", teacherIds=" + teacherIds +
                ", prsnTeacherIds=" + Arrays.toString(prsnTeacherIds) +
//                ", prsnTeacherIds="+prsnTeacherIds+
                ", gradeClassId=" +gradeClassId +
                ", classGradeInfo=" +classGradeInfo +
                ", testOrSupId=" + testOrSupId +
                ", testName='" + testName + '\'' +
                ", testTime=" + testTime +
                ", testSiteIdCopy='" + testSiteIdCopy + '\'' +
                ", classGradeCopy=" + classGradeCopy +
                ", testItemCopy=" + Arrays.toString(testItemCopy) +
                ", teacherCopy=" + Arrays.toString(teacherCopy) +
                ", testStatus=" + testStatus +
                ", teacherNameCopy='" + teacherNameCopy + '\'' +
                ", testItemName=" +testItemName +
                ", testSite=" + testSite +
                ", enrollYear=" + enrollYear +
                ", classNo=" + classNo +
                ", str1=" + str1 +
                ", testRecordIdCopy=" + testRecordIdCopy +
                '}';
    }


    public Long[] getTestItemIds() {
        return testItemIds;
    }

    public void setTestItemIds(Long[] testItemIds) {
        this.testItemIds = testItemIds;
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

    public String getTestSite() {
        return testSite;
    }

    public void setTestSite(String testSite) {
        this.testSite = testSite;
    }

    private String testSite;

    public Long[] getTestSiteIds() {
        return testSiteIds;
    }

    public void setTestSiteIds(Long[] testSiteIds) {
        this.testSiteIds = testSiteIds;
    }

    private Long[] testSiteIds;


    /** 体测年级班级*/
    @Excel(name = "体测年级班级")
    private String classGradeCopy;

    /** 体测项目组*/
//    @Excel(name = "体测项目")
    private String[] testItemCopy;


    public String getTestItemName() {
        return testItemName;
    }

    public void setTestItemName(String testItemName) {
        this.testItemName = testItemName;
    }

    private String testItemName;

    public long[] getTeacher() {
        return teacherCopy;
    }

    public void setTeacher(long[] teacherCopy) {
        this.teacherCopy = teacherCopy;
    }

    /*体测老师组*
     */
    private long[] teacherCopy;

    /** 完成状态 0-未完成，1-完成 */
    @Excel(name = "完成状态 0-未完成，1-完成")
    private Long testStatus;


    /** 接收通知的老师*/
    @Excel(name = "接收通知的老师")
    private String teacherNameCopy;

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
    public void setTestSiteId(Long  testSiteIdCopy)
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

    public String[] getTestItem() {
        return testItemCopy;
    }

    public void setTestItem(String[] testItemCopy) {
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

}
