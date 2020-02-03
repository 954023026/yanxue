package com.ketai.activity.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.model.domain.YxBaseSchool;

import java.util.List;

/**
 * <p>
 * 学校表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-10
 */
public interface YxBaseSchoolService extends IService<YxBaseSchool> {

    /**
     * 根据  parentId 查询数据
     * 三级联查中的最后一级查询
     * @param parentId
     * @return
     */
    List<YxBaseSchool> selByParentId(Long parentId);


}
