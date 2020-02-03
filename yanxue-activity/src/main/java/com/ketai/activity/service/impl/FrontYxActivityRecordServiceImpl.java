package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxActivityRecordMapper;
import com.ketai.activity.service.FrontYxActivityRecordService;
import com.ketai.common.query.pcQuery.PcActivityRecordQuery;
import com.ketai.model.domain.YxActivityRecord;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 研学(活动)风采表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class FrontYxActivityRecordServiceImpl extends ServiceImpl<YxActivityRecordMapper, YxActivityRecord> implements FrontYxActivityRecordService {

    @Override
    public int selRecordNumber(String year) {
        QueryWrapper<YxActivityRecord> qq = new QueryWrapper<>();
        qq.like("create_time",year);
        Integer integer = baseMapper.selectCount(qq);
        return integer;
    }

    /**
     * 研学风采分页查询
     * @param pageParam
     * @param pcActivityRecordQuery 查询条件对象
     * @author  黄松
     */
    @Override
    public void pageQuery(Page<YxActivityRecord> pageParam, PcActivityRecordQuery pcActivityRecordQuery) {
        QueryWrapper<YxActivityRecord> queryWrapper = new QueryWrapper<>();
        if (pcActivityRecordQuery == null) {
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }
        Integer studyStep = pcActivityRecordQuery.getStudyStep(); //学习阶段1小学2初中4高中
        String type = pcActivityRecordQuery.getType();  //类型
        Integer activityId = pcActivityRecordQuery.getActivityId(); //活动id
        if (!StringUtils.isEmpty(studyStep)){
            queryWrapper.eq("",studyStep);
        }
        if (!StringUtils.isEmpty(type)){
            queryWrapper.eq("type",type);
        }
        if (!StringUtils.isEmpty(activityId)){
            queryWrapper.eq("activity_id",activityId);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }
}
