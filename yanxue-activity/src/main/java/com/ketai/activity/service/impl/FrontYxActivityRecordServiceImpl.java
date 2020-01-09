package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxActivityRecordMapper;
import com.ketai.activity.service.FrontYxActivityRecordService;
import com.ketai.model.domain.YxActivityRecord;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 研学(活动)风采表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class FrontYxActivityRecordServiceImpl extends ServiceImpl<YxActivityRecordMapper, YxActivityRecord> implements FrontYxActivityRecordService {

    @Override
    public int selRecordNumber(String year) {
        QueryWrapper<YxActivityRecord> qq = new QueryWrapper<>();
        qq.like("create_time",year);
        Integer integer = baseMapper.selectCount(qq);
        return integer;
    }
}
