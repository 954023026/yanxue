package com.ketai.activity.families.controller;

import com.ketai.activity.families.vo.ActivityCount;
import com.ketai.api.admin.AdminActivityControllerApi;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("getActivityStatisticsCount")
    @Override
    public Result getActivityStatisticsCount(){

        return Result.ok(new ActivityCount());
    }

}
