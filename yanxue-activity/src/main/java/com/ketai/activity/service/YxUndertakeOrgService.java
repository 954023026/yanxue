package com.ketai.activity.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.model.domain.YxUndertakeOrg;

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
     */
    void pageQuery(Page<YxUndertakeOrg> pageParam, String orgname);
}
