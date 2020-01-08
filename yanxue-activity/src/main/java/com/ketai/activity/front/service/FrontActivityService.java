package com.ketai.activity.front.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.common.response.Result;
import com.ketai.model.domain.YxActivity;
import com.ketai.common.query.pcQuery.PcActivityQuery;

/**
 * <p>
 * 活动表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface FrontActivityService extends IService<YxActivity> {
    /**
     * 条件、分页查询
     * @param pcActivityQuery 查询条件对象
     */
    void pageQuery(Page<YxActivity> pageParam, PcActivityQuery pcActivityQuery);

    /**
     * 根据id查询研学实践
     * @param id
     */
    void getActivityDetailsByid(Integer id);

    /**
     * 查询数据总览
     * @param year
     * @return
     * @auther 李佐威
     */
    Result selDataOverview(String year);

}
