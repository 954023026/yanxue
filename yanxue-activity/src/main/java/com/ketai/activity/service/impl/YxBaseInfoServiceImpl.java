package com.ketai.activity.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxBaseInfoMapper;
import com.ketai.activity.service.YxBaseInfoService;
import com.ketai.model.domain.YxBaseInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 研学基地表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class YxBaseInfoServiceImpl extends ServiceImpl<YxBaseInfoMapper, YxBaseInfo> implements YxBaseInfoService {

    @Override
    public void pageQuery(Page<YxBaseInfo> pageParam, String baseInfoName) {
        QueryWrapper<YxBaseInfo> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(baseInfoName)){
            queryWrapper.like("base_name",baseInfoName);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }
}
