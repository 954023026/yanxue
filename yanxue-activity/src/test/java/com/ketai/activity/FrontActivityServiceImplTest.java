package com.ketai.activity;

import com.ketai.activity.mapper.FrontActivityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YanxueActivityApplication.class)
public class FrontActivityServiceImplTest {

    @Autowired
    private FrontActivityMapper frontActivityMapper;

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