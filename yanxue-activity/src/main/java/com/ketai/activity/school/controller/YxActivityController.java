package com.ketai.activity.school.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.school.query.YxActivityQuery;
import com.ketai.activity.school.service.YxActivityService;
import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.vo.R;
import com.ketai.model.domain.YxActivity;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/activity/yx-activity")
public class YxActivityController {

    @Autowired
    private YxActivityService yxActivityService;

    /**
     * 研学活动分页查询
     */
    @PostMapping
    public R selectPage(@ApiParam(name = "nowPage", value = "当前页码", required = true)
                        @PathVariable Long nowPage,
                        @ApiParam(name = "pageSize", value = "每页记录数", required = true)
                        @PathVariable Long pageSize,
                        @ApiParam(name = "yxActivityQuery", value = "查询对象", required = true)
                                YxActivityQuery yxActivityQuery) {
        System.out.println("--开始研学活动分页查询--");
        Page<YxActivity> pageParam = new Page<>(nowPage, pageSize);
        yxActivityService.selectPage(pageParam,yxActivityQuery);
        List<YxActivity> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("records", records);
    }
}

