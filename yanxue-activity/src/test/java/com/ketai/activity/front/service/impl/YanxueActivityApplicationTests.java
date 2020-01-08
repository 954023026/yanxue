package com.ketai.activity.front.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.front.service.FrontActivityService;
import com.ketai.activity.school.service.YxActivityService;
import com.ketai.activity.school.service.impl.YxActivityServiceImpl;
import com.ketai.common.query.YxActivityQuery;
import com.ketai.model.domain.YxActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YanxueActivityApplicationTests {
    @Autowired
    private FrontActivityService yxActivityService;

    @Test
    public void testSelectPage() {
        YxActivityService yxActivityService = new YxActivityServiceImpl();
        YxActivityQuery yxActivityQuery = new YxActivityQuery();
        yxActivityQuery.setBaseName("长沙科泰研学基地");
//        yxActivityQuery.setActivityName("java编程思想学习");
//        yxActivityQuery.setAuditStatus("1");
//        yxActivityQuery.setOrganizationName("1");
//        yxActivityQuery.setSerEndTime("2020-01-07 00:00:00");
//        yxActivityQuery.setSerStartTime("2020-01-07 00:00:00");
        Page<YxActivity> pageParam = new Page<>(1, 5);
        yxActivityService.selectPage(pageParam,yxActivityQuery);
        List<YxActivity> records = pageParam.getRecords();

//        System.out.println("————"+pageParam.getCurrent());
    }

}
