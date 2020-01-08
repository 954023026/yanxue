package com.ketai.activity.families.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.families.service.YxActivityRecordService;
import com.ketai.activity.school.mapper.YxActivityRecordMapper;
import com.ketai.common.exception.ExceptionThrowOut;
import com.ketai.model.domain.YxActivityRecord;
import com.ketai.model.domain.families.response.FileSystemCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 * 研学(活动)风采表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class YxActivityRecordServiceImpl extends ServiceImpl<YxActivityRecordMapper, YxActivityRecord> implements YxActivityRecordService {
    @Autowired
    private YxActivityRecordMapper recordMapper;

    @Override
    public void addRecord(String imageUrl) {
        if (this.count(new QueryWrapper<>()) >= 8) {
            ExceptionThrowOut.cast(FileSystemCode.UP_TO_8_PITURES);
        }
        //TODO 待填充
        YxActivityRecord record = new YxActivityRecord();
        record.setImageUrl(imageUrl);
        record.setType("recordHome");
        record.setStatus(1);
        record.setId(UUID.randomUUID().hashCode());
        recordMapper.insert(record);
    }
}
