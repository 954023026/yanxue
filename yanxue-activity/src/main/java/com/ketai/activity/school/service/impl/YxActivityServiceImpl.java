package com.ketai.activity.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.school.mapper.YxActivityMapper;
import com.ketai.activity.school.query.YxActivityQuery;
import com.ketai.activity.school.service.YxActivityService;
import com.ketai.model.domain.YxActivity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class YxActivityServiceImpl extends ServiceImpl<YxActivityMapper, YxActivity> implements YxActivityService {

    /**
     * 研学活动分页查询
     * @param pageParm
     * @param yxActivityQuery
     */
    @Override
    public void selectPage(Page<YxActivity> pageParm, YxActivityQuery yxActivityQuery) {
        QueryWrapper<YxActivity> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        if(queryWrapper == null){
            baseMapper.selectPage(pageParm,queryWrapper);
            return;
        }
        //获取研学基地名称查询条件
        String baseName=yxActivityQuery.getBaseName();
        //获取承办基地名称查询条件
        String organizationName=yxActivityQuery.getOrganizationName();
        //获取审批状态查询条件
        String auditStatus=yxActivityQuery.getAuditStatus();
        //获取研学主题名称模糊查询条件
        String activityName=yxActivityQuery.getActivityName();

        //条件查询
        if (!StringUtils.isEmpty(baseName)) {
            queryWrapper.like("name", baseName);
        }
        if (!StringUtils.isEmpty(organizationName)) {
            queryWrapper.eq("organizationName", baseName);
        }
        if (!StringUtils.isEmpty(auditStatus)) {
            queryWrapper.eq("auditStatus", baseName);
        }
        if (!StringUtils.isEmpty(activityName)) {
            queryWrapper.like("name", activityName);
        }
        baseMapper.selectPage(pageParm,queryWrapper);
    }
}
