package com.ketai.activity.orgin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.orgin.service.YxUndertakeOrgService;
import com.ketai.api.orgin.YxUndertakeOrgApi;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxUndertakeOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 研学承办机构信息
 */
@RestController()
@RequestMapping("pc/base/undertakeOrg")
public class YxUndertakeOrgController implements YxUndertakeOrgApi {

    @Autowired
    private YxUndertakeOrgService yxUndertakeOrgService;


    @GetMapping("qryUndertakeOrgInfoPag")
    @Override
    public Result PageQuery(String baseName, Integer pageSize, Integer nowPage) {
        Page<YxUndertakeOrg> pageParam = new Page<>(nowPage, pageSize);
        yxUndertakeOrgService.pageQuery(pageParam,baseName);
        List<YxUndertakeOrg> records = pageParam.getRecords();
        return Result.ok(
                new ResultListPage(
                        records,pageParam.getPages(),pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));

    }
}
