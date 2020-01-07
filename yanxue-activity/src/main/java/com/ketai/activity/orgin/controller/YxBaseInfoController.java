package com.ketai.activity.orgin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.orgin.service.YxBaseInfoService;
import com.ketai.api.orgin.YxBaseInfoControllerApi;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxBaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 研学基地信息
 */
@RestController("pc/base/baseManage")
public class YxBaseInfoController implements YxBaseInfoControllerApi {

    @Autowired
    private YxBaseInfoService yxBaseInfoService;

    //根据基地名称分页查询
    @GetMapping("qryBaseInfoPageList")
    @Override
    public Result PageQuery(String baseName, Integer pageSize, Integer nowPage) {
        Page<YxBaseInfo> pageParam = new Page<>(nowPage, pageSize);
        yxBaseInfoService.pageQuery(pageParam,baseName);
        List<YxBaseInfo> records = pageParam.getRecords();
        return Result.ok(
                new ResultListPage(
                        records,pageParam.getPages(),pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));
    }
}
