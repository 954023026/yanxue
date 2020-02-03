package com.ketai.activity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.common.query.pcQuery.PcActivityRecordQuery;
import com.ketai.common.query.pcQuery.PcBaseInfoQuery;
import com.ketai.model.domain.YxActivityRecord;
import com.ketai.model.domain.YxBaseInfo;
import com.ketai.model.domain.YxEvaluateInfo;

import java.util.List;

/**
 * <p>
 * 研学基地表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface FrontBaseInfoService extends IService<YxBaseInfo> {
    /**
     * 条件、分页查询
     * @param pcBaseInfoQuery 查询条件对象
     * @auther 黄松
     */
    void pageQuery(Page<YxBaseInfo> pageParam, PcBaseInfoQuery pcBaseInfoQuery);

    /**
     * 根据基地id分页查询研学基地评分信息
     * @param pageParam
     * @param baseId
     * @auther 黄松
     */
    void EvaluatePageQuery(Page<YxEvaluateInfo> pageParam, Integer baseId);

    /**
     * 根据id查询研学基地评分(总的评分)信息
     * @param baseId 基地id
     * @auther 黄松
     */
    List<YxEvaluateInfo> qryBaseEvaluateInfo(Integer baseId);
}
