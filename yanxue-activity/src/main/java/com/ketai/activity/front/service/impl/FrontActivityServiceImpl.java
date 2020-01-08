package com.ketai.activity.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.front.mapper.FrontActivityMapper;
import com.ketai.activity.front.service.FrontActivityService;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.pcQuery.PcActivityQuery;
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
public class FrontActivityServiceImpl extends ServiceImpl<FrontActivityMapper, YxActivity> implements FrontActivityService {

    //分页查询
    @Override
    public void pageQuery(Page<YxActivity> pageParam, PcActivityQuery pcActivityQuery) {
        QueryWrapper<YxActivity> queryWrapper=new QueryWrapper<>();
        if (pcActivityQuery==null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }
        Integer baseId = pcActivityQuery.getBaseId();   //研学基地id
        Integer organId = pcActivityQuery.getOrganId(); //区域id
        Integer organizationId = pcActivityQuery.getOrganizationId(); //承办机构id
        String participationSchYear = pcActivityQuery.getParticipationSchYear();  //年级
        String activityName = pcActivityQuery.getActivityName();    //模糊查询值
        Integer studyStep = pcActivityQuery.getStudyStep(); //阶段筛选

        if (!StringUtils.isEmpty(baseId)){
            queryWrapper.eq("base_id",baseId);
        }
        if (!StringUtils.isEmpty(organId)){
            queryWrapper.eq("organ_id",organId);
        }
        if (!StringUtils.isEmpty(organizationId)){
            queryWrapper.eq("organization_id",organizationId);
        }
        if (!StringUtils.isEmpty(baseId)){
            queryWrapper.eq("participation_sch_year",participationSchYear);
        }
        if (!StringUtils.isEmpty(studyStep)){
            queryWrapper.eq("study_step",studyStep);
        }
        if (!StringUtils.isEmpty(activityName)){
            queryWrapper.like("activity_name",activityName);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }

    //根据研学id查询
    @Override
    public void getActivityDetailsByid(Integer id) {

    }
}
