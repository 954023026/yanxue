package com.ketai.activity.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxCourseInfoMapper;
import com.ketai.activity.service.YxCourseInfoService;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
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

    /**
     * 根据课程名称分页查询研学课程信息
     * @param pageParam
     * @param CourseInfoName
     * @auther 李
     */
    @Override
    public void pageQuery(Page<YxCourseInfo> pageParam, String CourseInfoName) {
        QueryWrapper<YxCourseInfo> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(CourseInfoName)){
            queryWrapper.like("course_name",CourseInfoName);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }

    /**
     * 新增研学课程信息
     * @param yxCourseInfo
     * @return
     * @auther 李
     */
    @Override
    public Result saveCourseInfo(YxCourseInfo yxCourseInfo) {
        int insert = baseMapper.insert(yxCourseInfo);
        if(insert>0){
            return Result.ok(new ResultListPage(yxCourseInfo));
        }
        return Result.error();
    }

    /**
     * 根据id修改研学课程信息
     * @param yxCourseInfo
     * @return
     * @auther 李
     */
    @Override
    public Result saveAndFulsh(YxCourseInfo yxCourseInfo) {
        int i = baseMapper.updateById(yxCourseInfo);
        if(i>0){
            return Result.ok(new ResultListPage(yxCourseInfo));
        }
        return Result.error();
    }
}
