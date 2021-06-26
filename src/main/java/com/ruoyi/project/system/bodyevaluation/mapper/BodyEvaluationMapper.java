package com.ruoyi.project.system.bodyevaluation.mapper;



import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluation;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationBar;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationLine;
import com.ruoyi.project.system.bodyevaluation.domain.BodyScore;

import java.util.List;

public interface BodyEvaluationMapper {

    public List<BodyScore> selectBodyScoreList(BodyScore score);

    public List<BodyEvaluation> selectItemList();

    public List<BodyEvaluationLine> selectItemListLine();

    public List<BodyEvaluationBar> selectItemListBar();

    public void updateStatistical(BodyScore bodyScore);

    public void truncateTable();
}
