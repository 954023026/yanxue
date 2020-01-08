package com.ketai.activity.front.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ketai.model.domain.YxActivity;

/**
 * <p>
 * 活动表 Mapper 接口
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface FrontActivityMapper extends BaseMapper<YxActivity> {

    /**
     * 累计开展研学学校
     * @param year
     * @return
     */
    Integer selCarryOutSchool(String year);

    Integer selNumberOfTeaAndStu(String year);

}
