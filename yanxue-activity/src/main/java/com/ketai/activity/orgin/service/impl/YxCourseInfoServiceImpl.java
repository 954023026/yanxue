package com.ketai.activity.orgin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.orgin.mapper.YxCourseInfoMapper;
import com.ketai.activity.orgin.service.YxCourseInfoService;
import com.ketai.model.domain.YxCourseInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 研学课程表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class YxCourseInfoServiceImpl extends ServiceImpl<YxCourseInfoMapper, YxCourseInfo> implements YxCourseInfoService {

    @Override
    public void pageQuery(Page<YxCourseInfo> pageParam, String CourseInfoName) {
        QueryWrapper<YxCourseInfo> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(CourseInfoName)){
            queryWrapper.eq("course_name",CourseInfoName);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }
}
