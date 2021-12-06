package com.ruoyi.project.system.record.mapper;

import com.ruoyi.project.system.record.domain.TestRecordTeacherCopy;

import java.util.List;

/*
测试记录与教师关联表 数据层
 */
public interface TestRecordTeacherCopyMapper {
    public int selectCountTestRecordTeacherByTestRecordId(long testRecordId);
    public int countTestRecordTeacherById(long prsnteacherId);
    public int insertTestRecordTeacher(TestRecordTeacherCopy testRecordTeacherCopy);
    public int deleteTestRecordTeacherByTestRecordId(long testRecordId);
    public int deleteTestRecordTeacher(long[] ids);
    public int batchTestRecordTeacher(List<TestRecordTeacherCopy> testRecordTeacherList);
}

