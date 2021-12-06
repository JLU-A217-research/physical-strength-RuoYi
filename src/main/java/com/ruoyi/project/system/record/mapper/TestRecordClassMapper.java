package com.ruoyi.project.system.record.mapper;

import com.ruoyi.project.system.record.domain.TestRecordClass;

public interface TestRecordClassMapper {

    public int insertTestRecordClass(TestRecordClass testRecordClass);
    public int deleteTestRecordClassByTestRecordId(Long testRecordId);
    public int deleteTestRecordClass(Long[] ids);
    public int selectCountTestRecordClassByTestRecordId(Long testRecordId);
}
