package com.ketai.activity.orgin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.model.domain.YxBaseInfo;

/**
 * <p>
 * 研学基地表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface YxBaseInfoService extends IService<YxBaseInfo> {

    /**
     * 根据名称分页查询
     */
    void pageQuery(Page<YxBaseInfo> pageParam,String baseInfoName);
}
