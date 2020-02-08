package com.ketai.activity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.model.domain.YxEvaluateInfo;
import com.ketai.model.domain.families.response.EvaluateInfoVo;

public interface FrontEvaluatenInfoservice extends IService<YxEvaluateInfo> {
    /**
     * 总评分
     * @param id
     * @param flag
     * @return
     */
    EvaluateInfoVo qryBaseEvaluateInfo(Integer id, boolean flag);


}
