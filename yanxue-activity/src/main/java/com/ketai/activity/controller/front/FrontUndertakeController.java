package com.ketai.activity.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.FrontBaseInfoService;
import com.ketai.activity.service.FrontUndertakeService;
import com.ketai.api.front.FrontBaseInfoControllerApi;
import com.ketai.api.front.FrontUndertakeControllerApi;
import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.KetaiException;
import com.ketai.common.query.pcQuery.PcBaseInfoQuery;
import com.ketai.common.query.pcQuery.PcUndertakeOrgQuery;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.YxBaseInfo;
import com.ketai.model.domain.YxEvaluateInfo;
import com.ketai.model.domain.YxUndertakeOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pc/base/undertakeOrg")
public class FrontUndertakeController implements FrontUndertakeControllerApi {
    @Autowired
    private FrontUndertakeService frontUndertakeService;

    @PostMapping("qryUndertakeOrgInfoActivityPage")
    @Override
    public Result qryUndertakeOrginInfoPage(PcUndertakeOrgQuery pcUndertakeOrgQuery) {
        if (pcUndertakeOrgQuery.getNowPage()<=0||pcUndertakeOrgQuery.getPageSize()<=0){
            //参数错误
            throw new KetaiException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<YxUndertakeOrg> pageParam=new Page<>(pcUndertakeOrgQuery.getNowPage(),pcUndertakeOrgQuery.getPageSize());
        frontUndertakeService.pageQuery(pageParam,pcUndertakeOrgQuery);
        System.out.println(pageParam.getTotal());
        return Result.ok(
                new ResultListPage(
                        pageParam.getRecords(),pageParam.getPages(),
                        pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));
    }

    @PostMapping("qryUndertakeOrgInfo")
    @Override
    public Result qryUndertakeOrgInfo(Integer id) {
        YxUndertakeOrg result = frontUndertakeService.getById(id);
        return Result.ok(result);
    }

    @PostMapping("qryUndertakeOrgEvaluatePage")
    @Override
    public Result qryUndertakeOrgEvaluatePage(PcUndertakeOrgQuery pcUndertakeOrgQuery,Integer undertakeOrgId) {
        Page<YxEvaluateInfo> pageParam =new Page<>(pcUndertakeOrgQuery.getNowPage(),pcUndertakeOrgQuery.getPageSize());
        frontUndertakeService.EvaluatePageQuery(pageParam,undertakeOrgId);
        return Result.ok(
                new ResultListPage(
                        pageParam.getRecords(),pageParam.getPages(),
                        pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));
    }

    @PostMapping("qryUndertakeOrgEvaluateInfo")
    @Override
    public Result qryUndertakeOrgEvaluateInfo(Integer id) {
        return null;
    }
}
