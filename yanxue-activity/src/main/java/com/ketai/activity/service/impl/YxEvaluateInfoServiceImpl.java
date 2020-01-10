package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.mapper.YxEvaluateInfoMapper;
import com.ketai.activity.service.YxEvaluateInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.YxEvaluateInfo;
import com.ketai.model.domain.families.request.EvaluateRequest;
import com.ketai.model.domain.families.response.ActivityVo;
import com.ketai.model.domain.families.response.EvaluateInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 研学活动评分表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class YxEvaluateInfoServiceImpl extends ServiceImpl<YxEvaluateInfoMapper, YxEvaluateInfo> implements YxEvaluateInfoService {
    @Autowired
    private YxEvaluateInfoMapper evaluateInfoMapper;

    /**
     * @描述
     * @参数注释：
     * @返回值
     * @创建人  愿你活的通透拎得清轻重辩得明是非
     * @创建时间  2020/1/10 11:44
     */
    @Override
    public List<EvaluateInfoVo> qryBaseEvaluatePage(Page<ActivityVo> pageParam, EvaluateRequest evaluateRequest) {
        QueryWrapper<YxEvaluateInfo> queryWrapper = new QueryWrapper<>();
        //queryWrapper.orderByDesc("create_time");
        //研学基地名称
        String baseName = evaluateRequest.getBaseName();

        if (StringUtils.isNotBlank(baseName)) {
            queryWrapper.eq("base_name", baseName);
        }
        List<EvaluateInfoVo> byPage = evaluateInfoMapper.findEvaluatePage(pageParam, queryWrapper);
        return byPage;
    }
}
