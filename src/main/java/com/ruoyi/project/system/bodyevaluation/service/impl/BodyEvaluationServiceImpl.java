package com.ruoyi.project.system.bodyevaluation.service.impl;


import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluation;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationBar;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationLine;
import com.ruoyi.project.system.bodyevaluation.domain.BodyScore;
import com.ruoyi.project.system.bodyevaluation.mapper.BodyEvaluationMapper;
import com.ruoyi.project.system.bodyevaluation.service.IBodyEvaluationService;
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
        return bodyEvaluationMapper.selectItemList();
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
        for(int i=0;i<scoreList.size();i++){
            scoreList.get(i).setTestPoint(creatPoint(scoreList.get(i)));
        }

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
            int idex = nowYear - year;//idex表示距离我现在第几年
            int itemId = Integer.parseInt(""+bodyScore.getItemId());
            if(idex < 6){
                listLine.get(itemId - 1).setSumPoint(listLine.get(itemId - 1).getSumPoint(idex) + bodyScore.getTestPoint(), idex);
                listLine.get(itemId - 1).setNum(listLine.get(itemId - 1).getNum(idex) + 1, idex);
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
    public List<BodyEvaluationBar> generateDataForBar(BodyScore score){

        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        Calendar c = Calendar.getInstance();

        List<BodyEvaluationBar> listBar = selectItemListBar();
        BodyScore bodyScore;

        //处理查询的年级今年的均分
        List<BodyScore> scoreList = selectScoreList(score);
        for(int i=0;i<scoreList.size();i++){
            scoreList.get(i).setTestPoint(creatPoint(scoreList.get(i)));
        }

        for(int i=0;i<scoreList.size();i++){
            bodyScore = scoreList.get(i);
            c.setTime(bodyScore.getTestTime());
            int year = c.get(Calendar.YEAR);
            int itemId = Integer.parseInt(""+bodyScore.getItemId());
            if(nowYear == year){
                listBar.get(itemId - 1).setSumPointNow(listBar.get(itemId - 1).getSumPointNow() + bodyScore.getTestPoint());
                listBar.get(itemId - 1).setNumNow(listBar.get(itemId - 1).getNumNow() + 1);
            }
        }
        for(int i=0;i<listBar.size();i++){
            if(listBar.get(i).getNumNow() != 0)
                listBar.get(i).setAveNow(1.0 * listBar.get(i).getSumPointNow() / listBar.get(i).getNumNow());
        }

        //处理查询的年级去年的均分
        if(score.getClassGrade() - 1 >= 0) {
            score.setClassGrade(score.getClassGrade() - 1);

            scoreList = selectScoreList(score);
            for(int i=0;i<scoreList.size();i++){
                scoreList.get(i).setTestPoint(creatPoint(scoreList.get(i)));
            }

            for(int i=0;i<scoreList.size();i++){
                bodyScore = scoreList.get(i);
                c.setTime(bodyScore.getTestTime());
                int year = c.get(Calendar.YEAR);
                int itemId = Integer.parseInt(""+bodyScore.getItemId());
                if(nowYear - 1 == year){
                    listBar.get(itemId - 1).setSumPointLast(listBar.get(itemId - 1).getSumPointLast() + bodyScore.getTestPoint());
                    listBar.get(itemId - 1).setNumLast(listBar.get(itemId - 1).getNumLast() + 1);
                }
            }
            for(int i=0;i<listBar.size();i++){
                if(listBar.get(i).getNumLast() != 0)
                    listBar.get(i).setAveLast(1.0 * listBar.get(i).getSumPointLast() / listBar.get(i).getNumLast());
            }

        }
        else{
            for(int i=0;i<listBar.size();i++){
                listBar.get(i).setAveLast(0);
            }
        }

        return listBar;
    }

    @Override
    public long creatPoint(BodyScore s){
        double[][][][] testStand = (double[][][][]) CacheUtils.get(Constants.Test_Standar_Base, Constants.Test_Standar_Base_Key);
        int[][][] lengthBase = (int[][][]) CacheUtils.get(Constants.Test_Standar_Base_Length, Constants.Test_Standar_Base_Length_Key);
        long[][][][] testPoint = (long[][][][]) CacheUtils.get(Constants.Test_Standar_Point, Constants.Test_Standar_Point_Key);
        int j;
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
        return 0;
    }

    @Override
    public long creatTestGrade(BodyScore s){
        double[][][][] testStand = (double[][][][]) CacheUtils.get(Constants.Test_Standar_Base, Constants.Test_Standar_Base_Key);
        int[][][] lengthBase = (int[][][]) CacheUtils.get(Constants.Test_Standar_Base_Length, Constants.Test_Standar_Base_Length_Key);
        long[][][][] testGrade = (long[][][][]) CacheUtils.get(Constants.Test_Standar_Grade, Constants.Test_Standar_Grade_Key);
        int j;
        int grade = Integer.parseInt(s.getClassGrade()+"");
        int item = Integer.parseInt(s.getItemId()+"");
        int sex = Integer.parseInt(s.getSexId()+"");
        int length = lengthBase[grade][item][sex];
        double testScore = s.getTestScore();
        if(s.getScoreRelation()==0){
            for(j=0;j<length;j++){
                if(testScore>=testStand[grade][item][sex][j]){
                    return testGrade[grade][item][sex][j];
                }
            }
        }
        else{
            for(j=1;j<=testStand[grade][item][sex][0];j++){
                if(testStand[grade][item][sex][j]>=testScore){
                    return testGrade[grade][item][sex][j];
                }
            }
        }
        return 0;
    }

}
