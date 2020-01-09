package com.ketai.activity.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.FrontActivityService;
import com.ketai.api.front.FrontActivityControllerApi;
import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.KetaiException;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.common.response.ResultMap;
import com.ketai.model.domain.YxActivity;
import com.ketai.common.query.pcQuery.PcActivityQuery;
import com.ketai.model.domain.families.ext.ActivityCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("pc/activity")
public class FrontActivityController implements FrontActivityControllerApi {
    @Autowired
    private FrontActivityService frontActivityService;

    @PostMapping("selectPage/{page}/{limit}")
    @Override
    public Result selectPage(
            @PathVariable Integer page,
            @PathVariable Integer limit,
            PcActivityQuery pcActivityQuery) {
        if (page<=0||limit<=0){
            //21003 参数错误
            throw new KetaiException(ResultCodeEnum.PARAM_ERROR);
        }

        Page<YxActivity> pageParam=new Page<>(page,limit);
        frontActivityService.pageQuery(pageParam,pcActivityQuery);
        System.out.println(pageParam.getTotal());
        return Result.ok(
                new ResultListPage(
                        pageParam.getRecords(),pageParam.getPages(),
                        pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));
    }
    @PostMapping("activityDetails")
    @Override
    public ResultMap selectById(Integer id) {
        return frontActivityService.getActivityDetailsByid(id);
    }

    @PostMapping("getSelectItem")
    @Override
    public Result getSelectItem() {
        Map<String, Object> result = frontActivityService.getSelectItem();
        return Result.ok(result);

    }

    @PostMapping("getAllSchYear")
    @Override
    public Result getAllSchYear() {
        return frontActivityService.getAllSchYear();
    }

    @PostMapping("getActivityStatisticsCount")
    @Override
    public Result getActivityStatisticsCount(String schyear) {
        ActivityCount activityStatisticsCount = frontActivityService.getActivityStatisticsCount(schyear);
        return Result.ok().data(activityStatisticsCount);
    }
}
