package com.ruoyi.project.system.bodyevaluation.service.impl;


import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.project.system.bodyevaluation.domain.*;
import com.ruoyi.project.system.bodyevaluation.mapper.BodyEvaluationMapper;
import com.ruoyi.project.system.bodyevaluation.service.IBodyEvaluationService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class BodyEvaluationServiceImpl implements IBodyEvaluationService {

    @Autowired
    BodyEvaluationMapper bodyEvaluationMapper;

    @Override
    public List<BodyScore> selectScoreList(BodyScore score){
        return bodyEvaluationMapper.selectBodyScoreList(score);
    }

    @Override
    public List<BodyEvaluation> selectItemList(){
        List<BodyEvaluation> list = bodyEvaluationMapper.selectItemList();
        return list;
    }

    @Override
    public List<BodyEvaluationLine> selectItemListLine(){
        return bodyEvaluationMapper.selectItemListLine();
    }

    @Override
    public List<BodyEvaluationBar> selectItemListBar(){
        return bodyEvaluationMapper.selectItemListBar();
    }


    @Override
    public List<BodyEvaluationLine> generateDataForLine(BodyScore score){
        //通过score里传回来的年级数据，获取数据库中所有该年级的成绩（年份不一样，表示不同届学生）
        //例如score.date.year == 7 则返回所有曾经在7年级时候测试的成绩
        List<BodyScore> scoreList = selectScoreList(score);

        //获取当前年份
        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        Calendar c = Calendar.getInstance();

        //获取项目id和名称存放在一个list里面，list的下标与itemid-1保持一致
        List<BodyEvaluationLine> listLine = selectItemListLine();
        //对scoreList里的每一个值，分配到对应的sumPoint中
        BodyScore bodyScore;
        for(int i=0;i<scoreList.size();i++){
            bodyScore = scoreList.get(i);
            c.setTime(bodyScore.getTestTime());
            int year = c.get(Calendar.YEAR);
            int yearIdex = nowYear - year;//idex表示距离我现在第几年
            int itemId = Integer.parseInt(""+bodyScore.getItemId());
            int idex = itemId!=10 ? itemId - 1 : 7;
            if(yearIdex < 6){
                listLine.get(idex).setSumPoint(listLine.get(idex).getSumPoint(yearIdex) + bodyScore.getTestPoint(), yearIdex);
                listLine.get(idex).setNum(listLine.get(idex).getNum(yearIdex) + 1, yearIdex);
            }
        }
        for(int i=0;i<listLine.size();i++){
            for(int j=0;j<6;j++){
                if(listLine.get(i).getNum(j) != 0)
                    listLine.get(i).setAve(1.0 * listLine.get(i).getSumPoint(j) / listLine.get(i).getNum(j) , j);
            }
        }
        return listLine;
    }

    @Override
    public List<BodyEvaluationBar> generateDataForBar(BodyEvaluationBar bodyEvaluationBar){
        List<BodyEvaluationBar> listBar = bodyEvaluationMapper.selectForBar(bodyEvaluationBar);
        return listBar;
    }

    @Override
    public long creatPoint(BodyScore s){
        double[][][][] testStand = (double[][][][]) CacheUtils.get(Constants.Test_Standar_Base, Constants.Test_Standar_Base_Key);
        int[][][] lengthBase = (int[][][]) CacheUtils.get(Constants.Test_Standar_Base_Length, Constants.Test_Standar_Base_Length_Key);
        long[][][][] testPoint = (long[][][][]) CacheUtils.get(Constants.Test_Standar_Point, Constants.Test_Standar_Point_Key);
        int j;
        if(s.getClassGrade() != null && s.getItemId() != null && s.getSexId() != null && s.getScoreRelation() != null){
            int grade = Integer.parseInt(s.getClassGrade()+"");
            int item = Integer.parseInt(s.getItemId()+"");
            int sex = Integer.parseInt(s.getSexId()+"");
            int length = lengthBase[grade][item][sex];
            double testScore = s.getTestScore();
            if(s.getScoreRelation()==0){
                for(j=0;j<length;j++){
                    if(testScore>=testStand[grade][item][sex][j]){
                        return testPoint[grade][item][sex][j];
                    }
                }
            }
            else{
                for(j=1;j<=testStand[grade][item][sex][0];j++){
                    if(testStand[grade][item][sex][j]>=testScore){
                        return testPoint[grade][item][sex][j];
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public long creatTestGrade(BodyScore s){
        double[][][][] testStand = (double[][][][]) CacheUtils.get(Constants.Test_Standar_Base, Constants.Test_Standar_Base_Key);
        int[][][] lengthBase = (int[][][]) CacheUtils.get(Constants.Test_Standar_Base_Length, Constants.Test_Standar_Base_Length_Key);
        long[][][][] testGrade = (long[][][][]) CacheUtils.get(Constants.Test_Standar_Grade, Constants.Test_Standar_Grade_Key);
        int j;
        if(s.getClassGrade() != null && s.getItemId() != null && s.getSexId() != null && s.getScoreRelation() != null) {
            int grade = Integer.parseInt(s.getClassGrade() + "");
            int item = Integer.parseInt(s.getItemId() + "");
            int sex = Integer.parseInt(s.getSexId() + "");
            int length = lengthBase[grade][item][sex];
            double testScore = s.getTestScore();
            if (s.getScoreRelation() == 0) {
                for (j = 0; j < length; j++) {
                    if (testScore >= testStand[grade][item][sex][j]) {
                        return testGrade[grade][item][sex][j];
                    }
                }
            } else {
                for (j = 1; j <= testStand[grade][item][sex][0]; j++) {
                    if (testStand[grade][item][sex][j] >= testScore) {
                        return testGrade[grade][item][sex][j];
                    }
                }
            }
        }
        return 0;
    }

    //计算统计数据


    //更新统计数据
    @Override
    public void updateStatistical(){
        List<BodyScore> bodyScores = bodyEvaluationMapper.selectBodyScoreList(null);
        Calendar c = Calendar.getInstance();

        Statistical[] statistical = new Statistical [10000];
        int i=0,j=0,r=0,year=0;
        for(i=0;i<10000;i++){
            statistical[i] = new Statistical();
        }
        int n=bodyScores.size();
        for(i=0;i<n;i++){
            if(bodyScores.get(i).getTestTime()!=null&&bodyScores.get(i).getItemId()!=null
                    &&bodyScores.get(i).getClassGrade()!=null){
                c.setTime(bodyScores.get(i).getTestTime());
                year = c.get(Calendar.YEAR);
                for(j=0;j<r;j++){
                    if(statistical[j].getTestItemId()==bodyScores.get(i).getItemId()
                        && statistical[j].getTestClassGrade()==bodyScores.get(i).getClassGrade()
                        && statistical[j].getTestYear()==year){
                        break;
                    }
                }
                if(j==r){
                    statistical[j].setTestItemId(bodyScores.get(i).getItemId());
                    statistical[j].setStatisticalInformationId(j+1);
                    statistical[j].setTestClassGrade(bodyScores.get(i).getClassGrade());
                    statistical[j].setTestYear(year);
                    statistical[j].setSumPoint(0);
                    statistical[j].setSumStu(0);
                    r++;
                }
                statistical[j].setSumPoint(statistical[j].getSumPoint() + bodyScores.get(i).getTestPoint());
                statistical[j].setSumStu(statistical[j].getSumStu() + 1);
            }
        }
        for(j=0;j<r;j++){
            if(statistical[j].getSumStu()!=0)statistical[j].setAvePoint(statistical[j].getSumPoint()*1.0/statistical[j].getSumStu());
            else    statistical[j].setAvePoint(0);
        }
        //向表中插入数据
        bodyEvaluationMapper.truncateTable();
        for(i=0;i<r;i++) {
            bodyEvaluationMapper.insertStatistical(statistical[i]);
        }
    }
}
