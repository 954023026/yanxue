package com.ketai.activity.school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ketai.model.domain.YxActivity;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 活动表 Mapper 接口
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
public interface YxActivityMapper extends BaseMapper<YxActivity> {

    /**
     * 查询师生参与研学实践人次
     */
    Integer selectAllPeopleNumber(@Param("schyear") String schyear);

    Integer selectAllSchNumber(@Param("schyear") String schyear);
}
