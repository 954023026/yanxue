package com.ketai.activity.families.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.model.domain.YxActivityRecord;

/**
 * <p>
 * 研学(活动)风采表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface YxActivityRecordService extends IService<YxActivityRecord> {

    void addRecord(String imageUrl);
}
