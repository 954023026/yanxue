package com.ketai.activity.front.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.front.service.FrontActivityService;
import com.ketai.api.front.FrontActivityControllerApi;
import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.KetaiException;
import com.ketai.common.response.Result;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.pcQuery.PcActivityQuery;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pc/activity/selectPage")
public class FrontActivityController implements FrontActivityControllerApi {
    @Autowired
    private FrontActivityService yxActivityService;

    @PostMapping("{page}/{limit}")
    @Override
    public Result selectPage(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Integer page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Integer limit,
            @ApiParam(name = "pcActivityQuery", value = "查询对象", required = false)
                    PcActivityQuery pcActivityQuery) {
        if (page<=0||limit<=0){
            //21003 参数错误
            throw new KetaiException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<YxActivity> pageParam=new Page<>(page,limit);
        yxActivityService.pageQuery(pageParam,pcActivityQuery);
        List<YxActivity> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return Result.ok();
    }

    @Override
    public Result selectById(
            @ApiParam(name="id",value = "研学实践id",required = true)
            @PathVariable Integer id) {
        yxActivityService.getActivityDetailsByid(id);
        return null;
    }


}
