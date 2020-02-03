package com.ketai.activity.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.common.response.Result;
import com.ketai.model.domain.YxBaseOrgan;

import java.util.List;

/**
 * <p>
 * 区(县)域表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-10
 */
public interface YxBaseOrganService extends IService<YxBaseOrgan> {

    /**
     * 根据前端传来的父级id查询市区
     * @return
     * @auther 李
     */
    List<YxBaseOrgan> selByParentCode(Long parentCode);
}
