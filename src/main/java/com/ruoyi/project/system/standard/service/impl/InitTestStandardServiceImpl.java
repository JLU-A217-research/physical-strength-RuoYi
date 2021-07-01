package com.ruoyi.project.system.standard.service.impl;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.standard.domain.InitTestStandard;
import com.ruoyi.project.system.standard.mapper.InitTestStandardMapper;
import com.ruoyi.project.system.standard.service.InitTestStantardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class InitTestStandardServiceImpl implements InitTestStantardService {

    @Autowired
    private InitTestStandardMapper initTestStandardMapper;

    public List<InitTestStandard> sellctAllStandar(){
        return initTestStandardMapper.selectAllTestStandard();
    }


    public void setAllStandarCache(){

        List<InitTestStandard> list = sellctAllStandar();
        double[][][][] testStandar = new double[15][20][2][50];
        long[][][][] testPoint = new long[15][20][2][50];
        int[][][] lengthBase = new int[15][20][2];
        long[][][][] testGrade = new long[15][20][2][50];
        int grade;
        int itemId;
        int sexId;
        InitTestStandard ts;
        for(int i=0;i<list.size();i++){
            ts = list.get(i);
            if(ts.getGrade() != null && ts.getTestItemId() != null && ts.getStuSexId() != null &&
                    ts.getTestBase() !=null && ts.getTestGradeId() != null){
                grade = Integer.parseInt(ts.getGrade()+"");
                itemId = Integer.parseInt(ts.getTestItemId()+"");
                sexId = Integer.parseInt(ts.getStuSexId()+"");
                double testBase = ts.getTestBase();
                long point = ts.getTestPoint();
                long tsgrade = ts.getTestGradeId();
//            System.out.println("testBase="+testBase);
                testStandar[grade][itemId][sexId][lengthBase[grade][itemId][sexId]] = testBase;
                testPoint[grade][itemId][sexId][lengthBase[grade][itemId][sexId]] = point;
                testGrade[grade][itemId][sexId][lengthBase[grade][itemId][sexId]] = tsgrade;
                lengthBase[grade][itemId][sexId]++;
            }
        }
        CacheUtils.put(Constants.Test_Standar_Base, Constants.Test_Standar_Base_Key, testStandar);
        CacheUtils.put(Constants.Test_Standar_Base_Length, Constants.Test_Standar_Base_Length_Key, lengthBase);
        CacheUtils.put(Constants.Test_Standar_Point, Constants.Test_Standar_Point_Key, testPoint);
        CacheUtils.put(Constants.Test_Standar_Grade, Constants.Test_Standar_Grade_Key, testGrade);
    }

    public List<InitTestStandard> getAllStandarCache()
    {
        Object cacheObj = CacheUtils.get(Constants.Test_Standar_Base, Constants.Test_Standar_Base_Key);
        if (StringUtils.isNotNull(cacheObj))
        {
            List<InitTestStandard> InitTestStandards = StringUtils.cast(cacheObj);
            return InitTestStandards;
        }
        return null;
    }

    @PostConstruct
    public void init()
    {
        setAllStandarCache();
    }
}
