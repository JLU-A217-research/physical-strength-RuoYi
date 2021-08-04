package com.ruoyi.project.system.recordCopy.mapper;

import com.ruoyi.project.system.recordCopy.domain.TestRecordTeacher;

import java.util.List;

/*
测试记录与教师关联表 数据层
 */
public interface TestRecordTeacherMapper {
    public int selectCountTestRecordTeacherByTestRecordId(long testRecordId);
    public int countTestRecordTeacherById(long prsnteacherId);
    public int insertTestRecordTeacher(TestRecordTeacher testRecordTeacher);
    public int deleteTestRecordTeacherByTestRecordId(long testRecordId);
    public int deleteTestRecordTeacher(long[] ids);
    public int batchTestRecordTeacher(List<TestRecordTeacher> testRecordTeacherList);
}
