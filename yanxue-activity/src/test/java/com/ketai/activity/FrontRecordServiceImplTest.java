package com.ketai.activity;


import com.ketai.activity.front.service.FrontYxActivityRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YanxueActivityApplication.class)
public class FrontRecordServiceImplTest {

    @Autowired
    private FrontYxActivityRecordService recordService;


    @Test
    public void testSelRecordNumber(){
        int i = recordService.selRecordNumber("2018");
        System.out.println("——————"+i);
    }
}
