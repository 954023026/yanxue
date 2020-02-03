package com.ketai.activity.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.FrontActivityService;
import com.ketai.activity.service.FrontBaseInfoService;
import com.ketai.api.front.FrontActivityControllerApi;
import com.ketai.api.front.FrontBaseInfoControllerApi;
import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.KetaiException;
import com.ketai.common.query.pcQuery.PcActivityQuery;
import com.ketai.common.query.pcQuery.PcBaseInfoQuery;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.common.response.ResultMap;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.YxBaseInfo;
import com.ketai.model.domain.YxEvaluateInfo;
import com.ketai.model.domain.families.ext.ActivityCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pc/base/baseManage")
public class FrontBaseInfoController implements FrontBaseInfoControllerApi {
    @Autowired
    private FrontBaseInfoService frontBaseInfoService;

    @PostMapping("qryBaseInfoPage")
    @Override
    public Result qryBaseInfoPage(
            @RequestParam("nowPage") Integer nowPage,
            @RequestParam("pageSize") Integer pageSize,
            PcBaseInfoQuery pcBaseInfoQuery) {
        if (nowPage<=0||pageSize<=0){
            //21003 参数错误
            throw new KetaiException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<YxBaseInfo> pageParam=new Page<>(nowPage,pageSize);
        frontBaseInfoService.pageQuery(pageParam,pcBaseInfoQuery);
        return Result.ok(
                new ResultListPage(
                        pageParam.getRecords(),pageParam.getPages(),
                        pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));
    }

    @PostMapping("qryBaseEvaluatePage")
    @Override
    public Result qryBaseEvaluatePage(
            @RequestParam("nowPage") Integer nowPage,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("baseId") Integer baseId) {
        if (nowPage<=0||pageSize<=0){
            //21003 参数错误
            throw new KetaiException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<YxEvaluateInfo> pageParam=new Page<>(nowPage,pageSize);
        frontBaseInfoService.EvaluatePageQuery(pageParam,baseId);
        return Result.ok(
                new ResultListPage(
                        pageParam.getRecords(),pageParam.getPages(),
                        pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));
    }

    @PostMapping("qryBaseInfo")
    @Override
    public Result qryBaseInfo(Integer id) {
        YxBaseInfo yxBaseInfo = frontBaseInfoService.getById(id);
        return Result.ok(yxBaseInfo);
    }

    @PostMapping("qryBaseEvaluateInfo")
    @Override
    public Result qryBaseEvaluateInfo(Integer id) {
        List<YxEvaluateInfo> result = frontBaseInfoService.qryBaseEvaluateInfo(id);
        return Result.ok(result);
    }

}
