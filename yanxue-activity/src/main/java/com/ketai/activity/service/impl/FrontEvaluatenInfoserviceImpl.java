package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxEvaluateInfoMapper;
import com.ketai.activity.service.FrontEvaluatenInfoservice;
import com.ketai.model.domain.YxEvaluateInfo;
import com.ketai.model.domain.families.response.EvaluateInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Service
public class FrontEvaluatenInfoserviceImpl extends ServiceImpl<YxEvaluateInfoMapper, YxEvaluateInfo> implements FrontEvaluatenInfoservice {
    /**
     * 总评分
     * @param id
     * @param flag
     * @return
     */
    @Override
    public EvaluateInfoVo qryBaseEvaluateInfo(Integer id, boolean flag) {
        System.out.println("id==>"+id+"flag==>"+flag);
        QueryWrapper<YxEvaluateInfo> queryWrapper =new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        EvaluateInfoVo evaluateInfo =null;
        if (flag){
            if (!StringUtils.isEmpty(id)){
                queryWrapper.eq("base_id",id);
            }
            YxEvaluateInfo allScore = baseMapper.getAllScore(1,id);
            Integer count = baseMapper.selectCount(queryWrapper);
            evaluateInfo = getEvaluateInfo(count, allScore);
        }else {
            if (!StringUtils.isEmpty(id)){
                queryWrapper.eq("undertake_org_id",id);
            }
            YxEvaluateInfo allScore = baseMapper.getAllScore(id,0);
            Integer count = baseMapper.selectCount(queryWrapper);
            evaluateInfo = getEvaluateInfo(count, allScore);
        }
        return evaluateInfo;
    }

    /**
     * 根据所有评分数据计算总评分
     * @param count
     * @param allScore
     * @return
     */
    public EvaluateInfoVo getEvaluateInfo(Integer count,YxEvaluateInfo allScore){
        if (count==0){
            return new EvaluateInfoVo();
        }
        BigDecimal bigDecimal = new BigDecimal(count);
        EvaluateInfoVo evaluateInfo = new EvaluateInfoVo();
        evaluateInfo.setCourseScore((allScore.getCourseScore().divide(bigDecimal,2, BigDecimal.ROUND_HALF_UP)).setScale(2, BigDecimal.ROUND_HALF_UP));
        evaluateInfo.setScore((allScore.getScore().divide(bigDecimal, 2, BigDecimal.ROUND_HALF_UP)).setScale(2, BigDecimal.ROUND_HALF_UP));
        evaluateInfo.setUndertakeServiceScore((allScore.getUndertakeServiceScore().divide(bigDecimal, 2, BigDecimal.ROUND_HALF_UP)).setScale(2, BigDecimal.ROUND_HALF_UP));
        evaluateInfo.setSafetyScore((allScore.getSafetyScore().divide(bigDecimal, 2, BigDecimal.ROUND_HALF_UP)).setScale(2, BigDecimal.ROUND_HALF_UP));
        evaluateInfo.setBaseManageScore((allScore.getBaseManageScore().divide(bigDecimal, 2, BigDecimal.ROUND_HALF_UP)).setScale(2, BigDecimal.ROUND_HALF_UP));
        return evaluateInfo;
    }
}
