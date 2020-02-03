package com.ketai.activity;

import com.ketai.activity.mapper.FrontActivityMapper;
import com.ketai.activity.service.impl.YxActivityServiceImpl;
import com.ketai.model.domain.YxActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.commons.lang3.time.DateUtils.parseDate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YanxueActivityApplication.class)
public class FrontActivityServiceImplTest {

    @Autowired
    private FrontActivityMapper frontActivityMapper;

    @Autowired
    private YxActivityServiceImpl yxActivityService;

    //测试时间转换
    @Test
    public void testTime(){
        Date date = new Date();
        for (YxActivity yxActivity : yxActivityService.selByStatus()){
            Integer day = Math.toIntExact((date.getTime() - yxActivity.getSerStartTime().getTime()) / (24 * 60 * 60 * 1000));
            System.out.println("差值"+day);
        }
    }

    @Test
    public void testCarryOutSchool(){
        int i = frontActivityMapper.selCarryOutSchool("2019");
        System.out.println("——————"+i);
    }

    @Test
    public void testNumberOfTeaAndStu(){
        int i = frontActivityMapper.selNumberOfTeaAndStu("2020");
        System.out.println("————————Number"+i);
    }

}