package com.ketai.activity;

import com.ketai.activity.mapper.FrontActivityMapper;
import com.ketai.activity.service.impl.YxActivityServiceImpl;
import com.ketai.model.domain.YxActivity;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.apache.commons.lang3.time.DateUtils.parseDate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YanxueActivityApplication.class)
public class FrontActivityServiceImplTest {

    @Autowired
    private FrontActivityMapper frontActivityMapper;

    @Autowired
    private YxActivityServiceImpl yxActivityService;

    @Test
    public void Test2(){
        Date time =new Date("Tue Mar 26 00:00:00 CST 2019");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String timeFormat = sdf.format(time);
        System.out.println("——————++++——————"+timeFormat);
    }


    @SneakyThrows
    @Test
    public void test11(){
        String oldDateStr = "2019-01-30T16:00:00.000+0000";
        Date date1 = null;
        DateFormat df2 = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse(oldDateStr);
            //EEE MMM dd HH:mm:ss Z yyyy
            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date1 = df1.parse(date.toString());
            System.out.println("——————++++++————————"+date1);
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String format = df2.format(date1);
        System.out.println("测试"+format);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = sdf.parse(format);
        System.out.println("测试"+startTime);
    }

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