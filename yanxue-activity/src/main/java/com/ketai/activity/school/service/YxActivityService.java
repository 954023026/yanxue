package com.ketai.activity.school.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.activity.school.query.YxActivityQuery;
import com.ketai.model.domain.YxActivity;

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
}
