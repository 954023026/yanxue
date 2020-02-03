package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxBaseSchoolMapper;
import com.ketai.activity.service.YxBaseSchoolService;
import com.ketai.model.domain.YxBaseSchool;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 学校（区县）表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-10
 */
@Service
public class YxBaseSchoolServiceImpl extends ServiceImpl<YxBaseSchoolMapper, YxBaseSchool> implements YxBaseSchoolService {

    @Override
    public List<YxBaseSchool> selByParentId(Long parentId) {
        QueryWrapper<YxBaseSchool>  qq = new QueryWrapper<>();
        //获取所有区县
        if(parentId==0){
            return baseMapper.selectList(qq);
        }
        qq.eq("parent_id",parentId);
        return baseMapper.selectList(qq);
    }
}
