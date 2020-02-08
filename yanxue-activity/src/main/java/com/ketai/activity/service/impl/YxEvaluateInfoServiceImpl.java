package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.mapper.YxEvaluateInfoMapper;
import com.ketai.activity.service.YxEvaluateInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.ExceptionThrowOut;
import com.ketai.common.model.response.CommonCode;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.YxEvaluateInfo;
import com.ketai.model.domain.families.request.EvaluateRequest;
import com.ketai.model.domain.families.response.ActivityVo;
import com.ketai.model.domain.families.response.EvaluateInfoNumVo;
import com.ketai.model.domain.families.response.EvaluateInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
     * @描述 分页查询研学评价
     * @返回值
     * @创建人 愿你活的通透拎得清轻重辩得明是非
     * @创建时间 2020/1/10 11:44
     */
    @Override
    public List<EvaluateInfoVo> qryBaseEvaluatePage(Page<ActivityVo> pageParam, EvaluateRequest evaluateRequest) {
        QueryWrapper<YxEvaluateInfo> queryWrapper = new QueryWrapper<>();
        //queryWrapper.orderByDesc("create_time");
        //研学基地名称
        String baseName = evaluateRequest.getBaseName();

        if (StringUtils.isNotBlank(baseName)) {
            queryWrapper.like("base_name", baseName);
        }
        List<EvaluateInfoVo> evaluateInfoVoList = evaluateInfoMapper.findEvaluatePage(pageParam, queryWrapper);
        //todo 抛出指定异常
        if (evaluateInfoVoList == null) {
            ExceptionThrowOut.cast(CommonCode.SERVER_ERROR);
            return null;
        }
        return evaluateInfoVoList;
    }

    @Override
    public List<EvaluateInfoVo> qryEvaluateInfoPage(Page<ActivityVo> pageParam, EvaluateRequest evaluateRequest) {
        QueryWrapper<YxEvaluateInfo> queryWrapper = new QueryWrapper<>();
        //研学基地名称
        String baseName = evaluateRequest.getBaseName();
        //研学基地名称
        Long qryScore = evaluateRequest.getQryScore();
        //开始时间
        String serStartTime = evaluateRequest.getStartTime();
        //结束
        String serEndTime = evaluateRequest.getEndTime();
        if (StringUtils.isNotBlank(baseName)) {
            queryWrapper.like("b.base_name", baseName);
        }
        if (!org.springframework.util.StringUtils.isEmpty(qryScore)) {
            queryWrapper.eq("FLOOR(score)", qryScore);
        }
        if (StringUtils.isNotBlank(serStartTime)) {
            queryWrapper.gt("e.create_time", serStartTime);
        }
        if (StringUtils.isNotBlank(serEndTime)) {
            queryWrapper.lt("e.create_time", serEndTime);
        }
        List<EvaluateInfoVo> evaluateInfoVoList = evaluateInfoMapper.qryEvaluateInfoPage(pageParam, queryWrapper);
        //todo 抛出指定异常
        if (evaluateInfoVoList == null) {
            ExceptionThrowOut.cast(CommonCode.SERVER_ERROR);
            return null;
        }
        return evaluateInfoVoList;
    }

    @Override
    public Map<String, Integer> queryBaseEvaluateGroupCnt() {
        List<EvaluateInfoNumVo> evaluateInfoVoList = evaluateInfoMapper.selectBaseEvaluateGroupCnt();
        Map<String, Integer> map = new HashMap<>();
        map.put("score0", 0);
        map.put("score1", 0);
        map.put("score2", 0);
        map.put("score3", 0);
        map.put("score4", 0);
        map.put("score5", 0);
        String[] scoreCounts = {"score0", "score1", "score2", "score3", "score4", "score5"};
        //todo 抛出指定异常
        if (evaluateInfoVoList == null) {
            ExceptionThrowOut.cast(CommonCode.SERVER_ERROR);
            return null;
        }

        evaluateInfoVoList.forEach(evaluate -> {
            Integer score = evaluate.getScore();
            String scoreName = scoreCounts[score];
            map.put(scoreName, evaluate.getScores());
        });
        return map;
    }

    /**
     * @描述  显示或隐藏该条评论
     * @返回值  无
     * @创建人  愿你活的通透拎得清轻重辩得明是非
     * @创建时间  2020/2/3 18:41
     */
    @Override
    public void changeEvaluateState(EvaluateRequest evaluateRequest) {
        if (evaluateRequest.getId() <= 0 || evaluateRequest.getId() == null || evaluateRequest.getDisplay() == null) {
            ExceptionThrowOut.cast(ResultCodeEnum.PARAM_ERROR);
        }
        YxEvaluateInfo evaluateInfo = new YxEvaluateInfo();
        evaluateInfo.setId(evaluateRequest.getId());
        evaluateInfo.setDisplay(evaluateRequest.getDisplay());
        evaluateInfoMapper.updateById(evaluateInfo);

    }

}
