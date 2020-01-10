package com.ketai.activity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ketai.model.domain.YxEvaluateInfo;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.YxEvaluateInfo;
import com.ketai.model.domain.families.response.ActivityVo;
import com.ketai.model.domain.families.response.EvaluateInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 研学活动评分表 Mapper 接口
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface YxEvaluateInfoMapper extends BaseMapper<YxEvaluateInfo> {

    List<EvaluateInfoVo> findEvaluatePage(Page<ActivityVo> pageParam, @Param(Constants.WRAPPER) QueryWrapper<YxEvaluateInfo> queryWrapper);
}
