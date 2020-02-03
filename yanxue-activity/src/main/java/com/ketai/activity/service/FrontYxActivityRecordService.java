package com.ketai.activity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.common.query.pcQuery.PcActivityRecordQuery;
import com.ketai.model.domain.YxActivityRecord;

/**
 * <p>
 * 研学(活动)风采表 服务类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface FrontYxActivityRecordService extends IService<YxActivityRecord> {

    int selRecordNumber(String year);

    /**
     * 条件、分页查询
     * @param pcActivityRecordQuery 查询条件对象
     * @auther 黄松
     */
    void pageQuery(Page<YxActivityRecord> pageParam, PcActivityRecordQuery pcActivityRecordQuery);
}
