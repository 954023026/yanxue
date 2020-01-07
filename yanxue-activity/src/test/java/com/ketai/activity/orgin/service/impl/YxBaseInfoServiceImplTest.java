package com.ketai.activity.orgin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.YanxueActivityApplication;
import com.ketai.activity.orgin.service.YxBaseInfoService;
import com.ketai.model.domain.YxBaseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = YanxueActivityApplication.class)
public class YxBaseInfoServiceImplTest {


    @Autowired
    private YxBaseInfoService yxBaseInfoService;

    @Test
    public void pageQuery() {
        Page<YxBaseInfo> pageParam = new Page<>(1, 5);
        yxBaseInfoService.pageQuery(pageParam,"基地名称");
        List<YxBaseInfo> records = pageParam.getRecords();
    }
}