package com.ruoyi.project.system.record.mapper;

import com.ruoyi.project.system.record.domain.TestRecordStu;

import java.util.List;

public interface TestRecordStuMapper {
    public int insertTestRecordStu(TestRecordStu testRecordStu);
    public int updateTestRecordStu(TestRecordStu testRecordStu);

   public  List<TestRecordStu> selectRecordStuList(TestRecordStu trs);
//    public int updateTestRecordStu(@Param((value="updateStuList")List<DatagoActivi>))
}
