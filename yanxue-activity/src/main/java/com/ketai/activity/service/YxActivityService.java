package com.ketai.activity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.common.query.YxActivityQuery;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.families.ext.ActivityCount;
import com.ketai.model.domain.families.request.ActivityRequest;
import com.ketai.model.domain.families.response.ActivityVo;
import io.swagger.models.auth.In;

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

    /**
     * 根据id查询研学活动信息
     * @return
     */
    YxActivity activityInfo(Integer id);

    /**
     * 根据研学活动id更改审批状态
     * @param id
     */
    void submitActivity(Integer id);

    /**
     * 根据研学活动id更改审批状态
     * 局领导进行审批
     * @param activityId
     * @author  李
     */
    int approval(Integer activityId, String reasonsNotPassed, Integer approverStatus);

    /**
     *  查询 所有审核状态为已通过和有效的研学活动
     *  进行归档操作
     * @auther 李
     * @return
     */
    List<YxActivity> selByStatus();
}
