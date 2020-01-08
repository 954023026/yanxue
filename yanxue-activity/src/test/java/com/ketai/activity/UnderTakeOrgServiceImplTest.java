package com.ketai.activity;

import com.ketai.activity.orgin.mapper.YxUndertakeOrgMapper;
import com.ketai.model.domain.YxUndertakeOrg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = YanxueActivityApplication.class)
public class UnderTakeOrgServiceImplTest {

    @Autowired
    private YxUndertakeOrgMapper undertakeOrgMapper;

    @Test
    public void testGetAllYear(){
        List<String> allYear = undertakeOrgMapper.getAllYear();
        allYear.forEach(item-> System.out.println("年份"+item));
    }
}
