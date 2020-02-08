package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxBaseInfoMapper;
import com.ketai.activity.mapper.YxEvaluateInfoMapper;
import com.ketai.activity.mapper.YxUndertakeOrgMapper;
import com.ketai.activity.service.FrontBaseInfoService;
import com.ketai.activity.service.FrontUndertakeService;
import com.ketai.common.query.pcQuery.PcBaseInfoQuery;
import com.ketai.common.query.pcQuery.PcUndertakeOrgQuery;
import com.ketai.model.domain.YxBaseInfo;
import com.ketai.model.domain.YxEvaluateInfo;
import com.ketai.model.domain.YxUndertakeOrg;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FrontUndertakeServiceImpl extends ServiceImpl<YxUndertakeOrgMapper, YxUndertakeOrg> implements FrontUndertakeService {
    @Autowired
    private YxEvaluateInfoMapper yxEvaluateInfoMapper;

    @Override
    public void pageQuery(Page<YxUndertakeOrg> pageParam, PcUndertakeOrgQuery pcUndertakeOrgQuery) {
        QueryWrapper<YxUndertakeOrg> queryWrapper=new QueryWrapper<>();
        if (pcUndertakeOrgQuery==null){
            baseMapper.selectPage(pageParam,queryWrapper);
        }
        String orgname = pcUndertakeOrgQuery.getOrgname();//研学机构名称
        Integer id = pcUndertakeOrgQuery.getId(); //区县id
        if(!StringUtils.isEmpty(orgname)){
            queryWrapper.like("orgname",orgname);
        }
        if (!StringUtils.isEmpty(id)){
            queryWrapper.eq("area_id",id);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }


    //根据承办机构id分页查询研学承办机构评分信息
    @Override
    public void EvaluatePageQuery(Page<YxEvaluateInfo> pageParam, Integer undertakeOrgId) {
        QueryWrapper<YxEvaluateInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("undertake_org_id ",undertakeOrgId);
        yxEvaluateInfoMapper.selectPage(pageParam,queryWrapper);
    }


}
