package com.ketai.activity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.model.domain.YxEvaluateInfo;
import com.ketai.model.domain.families.request.EvaluateRequest;
import com.ketai.model.domain.families.response.ActivityVo;
import com.ketai.model.domain.families.response.EvaluateInfoVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 研学活动评分表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface YxEvaluateInfoService extends IService<YxEvaluateInfo> {


    List<EvaluateInfoVo> qryBaseEvaluatePage(Page<ActivityVo> pageParam, EvaluateRequest evaluateRequest);

    List<EvaluateInfoVo> qryEvaluateInfoPage(Page<ActivityVo> pageParam, EvaluateRequest evaluateRequest);

    Map<String,Integer> queryBaseEvaluateGroupCnt();

    void changeEvaluateState(EvaluateRequest evaluateRequest);
}
