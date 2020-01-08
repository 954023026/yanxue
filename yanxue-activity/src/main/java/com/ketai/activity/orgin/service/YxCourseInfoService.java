package com.ketai.activity.orgin.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.model.domain.YxBaseInfo;
import com.ketai.model.domain.YxCourseInfo;

/**
 * <p>
 * 研学课程表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface YxCourseInfoService extends IService<YxCourseInfo> {

    /**
     * 根据课程名称分页查询
     * @param pageParam
     * @param CourseInfoName
     */
    void pageQuery(Page<YxCourseInfo> pageParam, String CourseInfoName);
}
