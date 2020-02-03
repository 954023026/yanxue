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
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("pc/activity")
public class FrontActivityController implements FrontActivityControllerApi {
    @Autowired
    private FrontActivityService frontActivityService;

    @PostMapping("selectPage")
    public Result selectPage(PcActivityQuery pcActivityQuery) {
        if (pcActivityQuery.getNowPage()<=0||pcActivityQuery.getPageSize()<=0){
            //21003 参数错误
            throw new KetaiException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<YxActivity> pageParam=new Page<>(pcActivityQuery.getNowPage(),pcActivityQuery.getPageSize());
        frontActivityService.pageQuery(pageParam,pcActivityQuery);
        System.out.println(pageParam.getTotal());
        return Result.ok(
                new ResultListPage(
                        pageParam.getRecords(), pageParam.getPages(),
                        pageParam.getTotal(), pageParam.getCurrent(), pageParam.getSize()));
    }
    @PostMapping("activityDetails")
    @Override
    public Result activityDetailsById(Integer id) {
        Map<String, Object> result = frontActivityService.getActivityDetailsByid(id);
        return Result.ok(result);
    }

    @PostMapping("getSelectItem")
    @Override
    public Result getSelectItem() {
        Map<String, Object> result = frontActivityService.getSelectItem();
        return Result.ok(result);

    }

    //活动学年
    @PostMapping("getAllSchYear")
    @Override
    public Result getAllSchYear() {
        return frontActivityService.getAllSchYear();
    }

    //获取统计总数
    @PostMapping("getActivityStatisticsCount")
    @Override
    public Result getActivityStatisticsCount(String schyear) {
        ActivityCount activityStatisticsCount = frontActivityService.getActivityStatisticsCount(schyear);
        return Result.ok().data(activityStatisticsCount);
    }
}
