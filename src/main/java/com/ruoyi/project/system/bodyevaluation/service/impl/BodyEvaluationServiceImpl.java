package com.ruoyi.project.system.bodyevaluation.service.impl;


import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluation;
import com.ruoyi.project.system.bodyevaluation.domain.BodyEvaluationBar;
import com.ruoyi.project.system.bodyevaluation.domain.BodyScore;
import com.ruoyi.project.system.bodyevaluation.domain.Statistical;
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
        List<BodyEvaluation> list = bodyEvaluationMapper.selectItemList();
        return list;
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
                for(j=0;j<length;j++){
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
                for (j = 0; j < length; j++) {
                    if (testStand[grade][item][sex][j] >= testScore) {
                        return testGrade[grade][item][sex][j];
                    }
                }
            }
        }
        return 0;
    }
    //更新统计数据
    @Override
    public void updateStatistical(){
        List<BodyScore> bodyScores = bodyEvaluationMapper.selectBodyScoreList(null);
        Calendar c = Calendar.getInstance();

        Statistical[] statistical = new Statistical [10000];
        int i=0,j=0,r=0;
        Long year = null;
        for(i=0;i<10000;i++){
            statistical[i] = new Statistical();
        }
        int n=bodyScores.size();
        for(i=0;i<n;i++){
            if(bodyScores.get(i).getTestTime()!=null&&bodyScores.get(i).getItemId()!=null
                    &&bodyScores.get(i).getClassGrade()!=null){
                c.setTime(bodyScores.get(i).getTestTime());
                year = (long)c.get(Calendar.YEAR);
                for(j=0;j<r;j++){
                    if(statistical[j].getTestItemId().equals(bodyScores.get(i).getItemId())
                        && statistical[j].getTestClassGrade().equals(bodyScores.get(i).getClassGrade())
                        && statistical[j].getTestYear().equals(year)
                        && statistical[j].getClassNo().equals(bodyScores.get(i).getClassNo())){
                        break;
                    }
                }
                if(j==r){
                    Long L0 = 0L;
                    Long jj= (long) (j + 1);
                    statistical[j].setTestItemId(bodyScores.get(i).getItemId());
                    statistical[j].setStatisticalInformationId(jj);
                    statistical[j].setTestClassGrade(bodyScores.get(i).getClassGrade());
                    statistical[j].setClassNo(bodyScores.get(i).getClassNo());
                    statistical[j].setTestYear(year);
                    statistical[j].setSumPoint(L0);
                    statistical[j].setSumStu(L0);
                    r++;
                }
                statistical[j].setSumPoint(statistical[j].getSumPoint() + bodyScores.get(i).getTestPoint());
                statistical[j].setSumStu(statistical[j].getSumStu() + 1);
            }
        }
        for(j=0;j<r;j++){
            if(statistical[j].getSumStu()!=0)statistical[j].setAvePoint(statistical[j].getSumPoint()*1.0/statistical[j].getSumStu());
            else    statistical[j].setAvePoint(0.0);
        }
        //向表中插入数据
        bodyEvaluationMapper.truncateTable();
        for(i=0;i<r;i++) {
            bodyEvaluationMapper.insertStatistical(statistical[i]);
        }
    }
}
