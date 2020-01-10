package com.ketai.activity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.common.query.YxActivityQuery;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.families.ext.ActivityCount;
import com.ketai.model.domain.families.request.ActivityRequest;
import com.ketai.model.domain.families.response.ActivityVo;

import java.util.List;

/**
 * <p>
 * 活动表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface YxActivityService extends IService<YxActivity> {
    /**
     * 研学活动分页查询
     * @param pageParm
     * @param yxActivityQuery
     */
    void selectPage(Page<YxActivity> pageParm, YxActivityQuery yxActivityQuery);

    /**
     * 根据学年查询
     * @param schyear
     * @return
     */
    ActivityCount findActivityNum(String schyear);


    /**
     * 分页查询研学信息
     * @param pageParam
     * @param activityRequest
     */
    List<ActivityVo> pageStatisticsQuery(Page<ActivityVo> pageParam, ActivityRequest activityRequest);

    List<String> getAllSchYear();
}
