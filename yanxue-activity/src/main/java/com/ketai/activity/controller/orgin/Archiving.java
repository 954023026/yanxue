package com.ketai.activity.controller.orgin;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxActivityMapper;
import com.ketai.activity.service.impl.YxActivityServiceImpl;
import com.ketai.model.domain.YxActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 延续归档
 */
@Component
public class Archiving extends ServiceImpl<YxActivityMapper, YxActivity> {

    @Autowired
    private YxActivityServiceImpl yxActivityService;

    /**
     * 每天 1:00 点进行归档统计
     * 0/2 * * * * ? 每两秒执行一次
     * @auther 李
     */
    @Scheduled(cron = "0 0 0 */1 * ?")
    public void guidang(){
        Date date = new Date();
        //查询审核以通过，状态为有效的所有研学活动
        List<YxActivity> yxActivities = yxActivityService.selByStatus();
        for(YxActivity yxActivity : yxActivities){
            Integer day = Math.toIntExact((date.getTime() - yxActivity.getSerStartTime().getTime()) / (24 * 60 * 60 * 1000));
            if(day>0||day==0){//活动已结束
                yxActivity.setAuditStatus(9);
                yxActivity.setStatus(0);    //活动无效
                baseMapper.updateById(yxActivity);
            }
        }
    }
}
