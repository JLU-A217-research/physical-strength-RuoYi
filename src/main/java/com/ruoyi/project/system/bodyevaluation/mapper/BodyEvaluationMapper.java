package com.ruoyi.project.system.bodyevaluation.mapper;



import com.ruoyi.project.system.bodyevaluation.domain.*;

import java.util.List;

public interface BodyEvaluationMapper {

    public List<BodyScore> selectBodyScoreList(BodyScore score);

    public List<BodyEvaluation> selectItemList();

    public List<BodyEvaluationBar> selectForBar(BodyEvaluationBar bodyEvaluationBar);

    public void insertStatistical(Statistical statistical);

    public void truncateTable();
}
