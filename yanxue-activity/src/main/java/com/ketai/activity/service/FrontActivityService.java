package com.ketai.activity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultMap;
import com.ketai.model.domain.YxActivity;
import com.ketai.common.query.pcQuery.PcActivityQuery;
import com.ketai.model.domain.families.ext.ActivityCount;

import java.util.Map;

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
     * @auther 黄松
     */
    void pageQuery(Integer province,Page<YxActivity> pageParam, PcActivityQuery pcActivityQuery);

    /**
     * 根据id查询研学实践
     * @param id
     * @auther 黄松
     */
    Map<String, Object> getActivityDetailsByid(Integer id);

    /**
     * 查询数据总览
     * @param year
     * @return
     * @auther 李佐威
     */
    Result selDataOverview(String year);

    /**
     * 获取所有筛选项
     */
    Map<String,Object> getSelectItem();

    /**
     * 获取所有活动学年
     */
    Result getAllSchYear();

    /**
     * 获取统计总数
     * @return
     */
    ActivityCount getActivityStatisticsCount(String schyear);

}
