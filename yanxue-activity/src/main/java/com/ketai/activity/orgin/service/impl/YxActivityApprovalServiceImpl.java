package com.ketai.activity.orgin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.orgin.mapper.YxActivityApprovalMapper;
import com.ketai.activity.orgin.service.YxActivityApprovalService;
import com.ketai.model.domain.YxActivityApproval;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动批准表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class YxActivityApprovalServiceImpl extends ServiceImpl<YxActivityApprovalMapper, YxActivityApproval> implements YxActivityApprovalService {

    @Override
    public int findApprovalNubmber() {
        //1 为以通过，0为无效
        QueryWrapper<YxActivityApproval> q = new QueryWrapper<>();
        q.eq("approver_status",1).eq("status",0);
        //年份
        return baseMapper.selectCount(q);
    }
}
