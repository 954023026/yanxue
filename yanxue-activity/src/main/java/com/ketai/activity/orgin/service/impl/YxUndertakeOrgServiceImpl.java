package com.ketai.activity.orgin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.orgin.mapper.YxUndertakeOrgMapper;
import com.ketai.activity.orgin.service.YxUndertakeOrgService;
import com.ketai.model.domain.YxUndertakeOrg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 研学承办机构表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class YxUndertakeOrgServiceImpl extends ServiceImpl<YxUndertakeOrgMapper, YxUndertakeOrg> implements YxUndertakeOrgService {

    @Override
    public void pageQuery(Page<YxUndertakeOrg> pageParam, String orgname) {
        QueryWrapper<YxUndertakeOrg> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(orgname)){
            queryWrapper.eq("orgname",orgname);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }
}
