package com.ketai.activity.orgin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.model.domain.YxActivityApproval;

public interface YxActivityApprovalService extends IService<YxActivityApproval> {

    /**
     * 局领导查询待审核活动数量
     *  条件：状态为以通过，且是无效的
     * @return
     */
    int findApprovalNubmber();
}
