package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.*;
import com.ketai.activity.service.FrontActivityService;
import com.ketai.activity.service.FrontBaseInfoService;
import com.ketai.activity.service.FrontYxActivityRecordService;
import com.ketai.activity.service.YxActivityService;
import com.ketai.common.query.pcQuery.PcActivityQuery;
import com.ketai.common.query.pcQuery.PcActivityRecordQuery;
import com.ketai.common.query.pcQuery.PcBaseInfoQuery;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultMap;
import com.ketai.model.domain.*;
import com.ketai.model.domain.families.ext.ActivityCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class FrontBaseInfoServiceImpl extends ServiceImpl<YxBaseInfoMapper, YxBaseInfo> implements FrontBaseInfoService {
    @Autowired
    private YxEvaluateInfoMapper yxEvaluateInfoMapper;


    //分页查询研学基地
    @Override
    public void pageQuery(Page<YxBaseInfo> pageParam, PcBaseInfoQuery pcBaseInfoQuery) {
        QueryWrapper<YxBaseInfo> queryWrapper = new QueryWrapper<>();
        if (pcBaseInfoQuery == null) {
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }
        String areaId = pcBaseInfoQuery.getAreaId();  //区县id
        String baseName = pcBaseInfoQuery.getBaseName(); //基地名称
        String baseTags = pcBaseInfoQuery.getBaseTags(); //基地标签
        String baseType = pcBaseInfoQuery.getBaseType(); //基地类型
        if (!StringUtils.isEmpty(areaId)){
            queryWrapper.eq("area_id",areaId);
        }
        if (!StringUtils.isEmpty(baseName)){
            queryWrapper.like("area_name",baseName);
        }
        if (!StringUtils.isEmpty(baseTags)){
            queryWrapper.eq("base_tags",baseTags);
        }
        if (!StringUtils.isEmpty(baseType)){
            queryWrapper.eq("base_type",baseType);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }


    //根据基地id分页查询研学基地评分信息
    @Override
    public void EvaluatePageQuery(Page<YxEvaluateInfo> pageParam, Integer baseId) {
        QueryWrapper<YxEvaluateInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("base_id ",baseId);
        yxEvaluateInfoMapper.selectPage(pageParam,queryWrapper);
    }
    //根据id查询研学基地评分(总的评分)信息
    @Override
    public List<YxEvaluateInfo> qryBaseEvaluateInfo(Integer baseId) {
        QueryWrapper<YxEvaluateInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("base_id ",baseId);
        List<YxEvaluateInfo> evaluateInfoList = yxEvaluateInfoMapper.selectList(queryWrapper);//评价集合
        Integer count = yxEvaluateInfoMapper.selectCount(queryWrapper); //评价总数
        return null;
    }
}
