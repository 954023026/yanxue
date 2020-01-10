package com.ketai.activity.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.common.response.Result;
import com.ketai.model.domain.YxUndertakeOrg;

import java.awt.image.RescaleOp;

/**
 * <p>
 * 研学承办机构表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface YxUndertakeOrgService extends IService<YxUndertakeOrg> {

    /**
     * 根据基地名称分页查询
     * @param pageParam
     * @param orgname
     * @auther 李
     */
    void pageQuery(Page<YxUndertakeOrg> pageParam, String orgname);

    /**
     * 研学基地新增
     * @param yxUndertakeOrg
     * @return
     * @auther 李
     */
    Result saveYxUndertakeOrg(YxUndertakeOrg yxUndertakeOrg);

    /**
     *
     * @param yxUndertakeOrg
     * @return
     * @auther 李
     */
    Result saveAndFlush(YxUndertakeOrg yxUndertakeOrg);
}
