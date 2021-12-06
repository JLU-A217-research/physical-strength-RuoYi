package com.ruoyi.project.system.recordCopy.mapper;

import com.ruoyi.project.system.recordCopy.domain.TestRecordClassCopy;

public interface TestRecordClassCopyMapper {
    public int insertTestRecordClassCopy(TestRecordClassCopy testRecordClassCopy);
    public int deleteTestRecordClassCopyByTestRecordId(Long testRecordId);
    public int deleteTestRecordClassCopy(Long[] ids);
    public int selectCountTestRecordClassCopyByTestRecordId(Long testRecordId);
}
