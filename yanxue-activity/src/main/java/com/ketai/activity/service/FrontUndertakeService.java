package com.ketai.activity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.common.query.pcQuery.PcBaseInfoQuery;
import com.ketai.common.query.pcQuery.PcUndertakeOrgQuery;
import com.ketai.model.domain.YxBaseInfo;
import com.ketai.model.domain.YxEvaluateInfo;
import com.ketai.model.domain.YxUndertakeOrg;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 研学机构表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public interface FrontUndertakeService extends IService<YxUndertakeOrg> {
    /**
     * 条件、分页查询
     * @param pcUndertakeOrgQuery 查询条件对象
     * @auther 黄松
     */
    void pageQuery(Page<YxUndertakeOrg> pageParam, PcUndertakeOrgQuery pcUndertakeOrgQuery);

    /**
     * 根据承办机构id分页查询研学承办机构评分信息
     * @param pageParam
     * @param undertakeOrgId
     */
    void EvaluatePageQuery(Page<YxEvaluateInfo> pageParam, Integer undertakeOrgId);



}
