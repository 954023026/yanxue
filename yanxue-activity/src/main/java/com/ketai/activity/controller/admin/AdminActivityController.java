package com.ketai.activity.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.YxActivityService;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.families.ext.ActivityCount;
import com.ketai.api.admin.AdminActivityControllerApi;
import com.ketai.common.response.Result;
import com.ketai.model.domain.families.request.ActivityRequest;
import com.ketai.model.domain.families.response.ActivityVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 统计研学信息
     * @param schyear
     * @return
     * @author  周
     */
    @PostMapping("getActivityStatisticsCount")
    @Override
    public Result getActivityStatisticsCount(
            @RequestParam(value = "schyear",required = false) String schyear
    ){
        ActivityCount activityNum = activityService.findActivityNum(schyear);
        return Result.ok(activityNum);
    }

    /**
     * 分页查询研学信息
     * @param activityRequest
     * @return
     * @author  周
     */
    @PostMapping("activityStatistics")
    @Override
    public Result activityStatistics(ActivityRequest activityRequest) {
        Page<ActivityVo> pageParam = new Page<>(activityRequest.getNowPage(), activityRequest.getPageSize());
        List<ActivityVo> activityVos = activityService.pageStatisticsQuery(pageParam, activityRequest);
        return Result.ok(new ResultListPage(activityVos, pageParam.getPages(), pageParam.getTotal(), activityRequest.getNowPage(), activityRequest.getPageSize()));
    }

    /**
     * 查询年份列表
     * @return
     * @author  周
     */
    @ApiOperation(value = "查询年份列表----xh")
    @PostMapping("getAllSchYear")
    public Result getAllSchYear() {
        return Result.ok(activityService.getAllSchYear());
    }
}
