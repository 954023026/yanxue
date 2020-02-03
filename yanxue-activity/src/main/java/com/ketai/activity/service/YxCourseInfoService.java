package com.ketai.activity.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.common.response.Result;
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
     * @auther 李
     */
    void pageQuery(Page<YxCourseInfo> pageParam,Integer id, String CourseInfoName);

    /**
     * 新增研学课程信息
     * @param yxCourseInfo
     * @return
     * @auther 李
     */
    Result saveCourseInfo(YxCourseInfo yxCourseInfo);

    /**
     * 根据id修改研学课程信息
     * @param yxCourseInfo
     * @return
     * @auther 李
     */
    Result saveAndFulsh(YxCourseInfo yxCourseInfo);
}
