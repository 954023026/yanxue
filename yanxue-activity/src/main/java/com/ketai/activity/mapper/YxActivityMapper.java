package com.ketai.activity.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.families.response.ActivityVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    List<ActivityVo> findByPage(Page<ActivityVo> pageParam,@Param(Constants.WRAPPER) QueryWrapper<YxActivity> queryWrapper);
}
