package com.ketai.activity;

import com.ketai.activity.mapper.YxUndertakeOrgMapper;
import com.ketai.activity.service.impl.YxBaseOrganServiceImpl;
import com.ketai.model.domain.YxBaseOrgan;
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

    @Autowired
    private YxBaseOrganServiceImpl yxBaseOrganService;

    //查询市区
    @Test
    public void testSelByParentCode() {
        List<YxBaseOrgan> yxBaseOrgans = yxBaseOrganService.selByParentCode(100000000000L);
        yxBaseOrgans.forEach(item ->
                System.out.println("市区"+item+"\n"));
    }

    @Test
    public void testGetAllYear(){
        List<String> allYear = undertakeOrgMapper.getAllYear();
        allYear.forEach(item-> System.out.println("年份"+item));
    }
}
