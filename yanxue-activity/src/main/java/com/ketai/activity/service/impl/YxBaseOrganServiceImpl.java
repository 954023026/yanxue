package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxBaseOrganMapper;
import com.ketai.activity.service.YxBaseOrganService;
import com.ketai.model.domain.YxBaseOrgan;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 区(县)域表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-10
 */
@Service
public class YxBaseOrganServiceImpl extends ServiceImpl<YxBaseOrganMapper, YxBaseOrgan> implements YxBaseOrganService {

    @Override
    public List<YxBaseOrgan> selByParentCode(Long parentCode) {
        QueryWrapper<YxBaseOrgan> qq = new QueryWrapper<>();
        qq.eq("parent_code",parentCode);
        return baseMapper.selectList(qq);
    }
}
