package com.ruoyi.project.system.scoreandevaluation.studentscoremanage.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.scoreandevaluation.studentscoremanage.mapper.ScoreMapper;
import com.ruoyi.project.system.scoreandevaluation.studentscoremanage.domain.Score;
import com.ruoyi.project.system.scoreandevaluation.studentscoremanage.service.IScoreService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 学生成绩管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
@Service
public class ScoreServiceImpl implements IScoreService 
{
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public Score selectItemId(Score score){
        return scoreMapper.selectItemId(score);
    }

    /**
     * 查询学生成绩管理
     * 
     * @param scoreRecordId 学生成绩管理ID
     * @return 学生成绩管理
     */
    @Override
    public Score selectScoreById(Long scoreRecordId)
    {
        Score s = scoreMapper.selectScoreById(scoreRecordId);
        return s;
    }

    public Score selectStudentByNo(Long stuNo){
        return scoreMapper.selectstudentByNo(stuNo);
    }

    /**
     * 查询学生成绩管理列表
     * 
     * @param score 学生成绩管理
     * @return 学生成绩管理
     */
    @Override
    public List<Score> selectScoreListByStu(Score score)
    {
        List<Score> s = scoreMapper.selectScoreListByStu(score);
        //更新测试年级
        Calendar calendar = Calendar.getInstance();
        long nowYear = calendar.get(Calendar.YEAR);
        Calendar c = Calendar.getInstance();
        int len = s.size();
        long enrollYear;
        for(int i=0;i<len;i++){
            c.setTime(s.get(i).getTestTime());
            enrollYear = c.get(Calendar.YEAR);
            s.get(i).setClassGrade(nowYear - enrollYear + s.get(i).getClassGrade());
        }
        return s;
    }

    /**
     * 新增学生成绩管理
     * 
     * @param score 学生成绩管理
     * @return 结果
     */
    @Override
    public int insertScore(Score score)
    {
        return scoreMapper.insertScore(score);
    }

    /**
     * 修改学生成绩管理
     * 
     * @param score 学生成绩管理
     * @return 结果
     */
    @Override
    public int updateScore(Score score)
    {
        Score s = score;
        return scoreMapper.updateScore(score);
    }

    /**
     * 删除学生成绩管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteScoreByIds(String ids)
    {
        return scoreMapper.deleteScoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生成绩管理信息
     * 
     * @param scoreRecordId 学生成绩管理ID
     * @return 结果
     */
    @Override
    public int deleteScoreById(Long scoreRecordId)
    {
        return scoreMapper.deleteScoreById(scoreRecordId);
    }

    @Override
    public long creatPoint(Score s){
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
            if(j>=length)  return 0;
        }
        else{
            for(j=0;j<length;j++){
                if(testStand[grade][item][sex][j]>=testScore){
                    return testPoint[grade][item][sex][j];
                }
            }
            if(j>=length)  return 0;
        }
        return 0;
    }

    @Override
    public long creatTestGrade(Score s){
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
            if(j>=length)  return 3;
        }
        else{
            for(j=0;j<length;j++){
                if(testStand[grade][item][sex][j]>=testScore){
                    return testGrade[grade][item][sex][j];
                }
            }
            if(j>=length)  return 3;
        }
        return 0;
    }


    //updateBMI
    public long getTgsId(Score score){
        return scoreMapper.getTgsId(score);
    }

    @Override
    public void updateBMI(){
        //定义参数
        double[][][][] testStand = (double[][][][]) CacheUtils.get(Constants.Test_Standar_Base, Constants.Test_Standar_Base_Key);
        Score s = new Score();
        double weight, height;

        //获取学生表
        List<Score> stu = scoreMapper.getStuInfo();
        int stulen = stu.size();

        //对每个学生进行处理，更新它们的BMI
        for(int i=0;i<stulen;i++){
            s.setStuId(stu.get(i).getStuId());
            s.setSexId(stu.get(i).getSexId());
            List<Score> scores = scoreMapper.updateBMI(s);  //先找到某个学生的所有的身高体重的测试
            int scoreSize = scores.size();
            //将身高和体重分别放在两个列表里，方便后面使用，其中身高的id是8，体重是9
            List<Score> scores_8 = new ArrayList<>();
            List<Score> scores_9 = new ArrayList<>();
            for(int j=0;j<scoreSize;j++){
                if(scores.get(j).getItemId() == 8){
                    scores_8.add(scores.get(j));
                }
                else if(scores.get(j).getItemId() == 9){
                    scores_9.add(scores.get(j));
                }
            }
            //idx8和idx9分别指向scores_8和scores_9，对它们进行匹配
            int idx8,len8 = scores_8.size();
            int idx9,len9 = scores_9.size();
            long classGrade8,classGrade9;
            for(idx8=0, idx9=0 ; idx8 < len8 && idx9 < len9;){
                classGrade8 = scoreMapper.getClassGradeByTgsId(scores_8.get(idx8));
                classGrade9 = scoreMapper.getClassGradeByTgsId(scores_9.get(idx9));
                if(classGrade8<classGrade9){
                    idx8++;
                }
                else if(classGrade8>classGrade9){
                    idx9++;
                }
                else{
                    s.setTestTime(scores_8.get(idx8).getTestTime());
                    height = scores_8.get(idx8).getTestScore() / 100.0;
                    weight = scores_9.get(idx9).getTestScore();
                    s.setTestScore(weight / height / height);

                    int grade = Integer.parseInt(classGrade8+"");
                    int item = 10;
                    int sex = Integer.parseInt(s.getSexId()+"");
                    double testScore = s.getTestScore();
                    if(testScore<testStand[grade][item][sex][0]){
                        s.setTestPoint(80L);
                        s.setTestGradeId(1L);
                    }
                    else if(testScore<testStand[grade][item][sex][1]){
                        s.setTestPoint(100L);
                        s.setTestGradeId(0L);
                    }
                    else if(testScore<testStand[grade][item][sex][2]){
                        s.setTestPoint(80L);
                        s.setTestGradeId(1L);
                    }
                    else{
                        s.setTestPoint(60L);
                        s.setTestGradeId(2L);
                    }

                    s.setClassGrade(classGrade8);
                    s.setItemId(10L);
                    s.setTgsId(getTgsId(s));
                    idx8++;idx9++;
                }
                s.setScoreRecordId(scoreMapper.getRecordIdByS(s));
//                scoreMapper.insertScore(s);
            }
        }
    }

}
