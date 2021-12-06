package com.ruoyi.project.system.recordCopy.mapper;

import com.ruoyi.project.system.recordCopy.domain.TestRecordStuCopy;

import java.util.List;

public interface TestRecordStuCopyMapper {
    public int insertTestRecordStu(TestRecordStuCopy testRecordStuCopy);
    public int updateTestRecordStu(TestRecordStuCopy testRecordStuCopy);

    public List<TestRecordStuCopy> selectRecordStuList(TestRecordStuCopy trs);
}
