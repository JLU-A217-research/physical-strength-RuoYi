package com.ruoyi.project.system.bodyevaluation.service;



import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluation;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationBar;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationLine;
import com.ruoyi.project.system.bodyevaluation.domain.BodyScore;

import java.util.List;

public interface IBodyEvaluationService {

    public List<BodyScore> selectScoreList(BodyScore score);

    public List<BodyEvaluation> selectItemList();
    public List<BodyEvaluationLine> generateDataForLine(BodyScore score);
    public List<BodyEvaluationBar> generateDataForBar(BodyScore score);
    public List<BodyEvaluationLine> selectItemListLine();
    public List<BodyEvaluationBar> selectItemListBar();

    public long creatPoint(BodyScore s);

    public long creatTestGrade(BodyScore s);

    //更新统计数据
    public void updateStatistical();
}