package com.ketai.activity.families.controller;

import com.ketai.activity.school.service.YxActivityService;
import com.ketai.activity.school.service.impl.YxActivityServiceImpl;
import com.ketai.model.domain.families.ext.ActivityCount;
import com.ketai.api.admin.AdminActivityControllerApi;
import com.ketai.common.response.Result;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2020-01-06 19:51
 */
@RestController
@RequestMapping("/admin/activity/")
public class AdminActivityController implements AdminActivityControllerApi {

    @Autowired
    private YxActivityService activityService;

    @PostMapping("getActivityStatisticsCount")
    @Override
    public Result getActivityStatisticsCount(
            @RequestParam(value = "schyear",required = false) String schyear
    ){
        ActivityCount activityNum = activityService.findActivityNum(schyear);
        return Result.ok(activityNum);
    }

    @Override
    public Result activityStatistics() {


        return Result.ok();
    }
}
