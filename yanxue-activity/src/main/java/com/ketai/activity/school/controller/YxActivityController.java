package com.ketai.activity.school.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.api.school.SchoolControllerApi;
import com.ketai.common.query.YxActivityQuery;
import com.ketai.activity.school.service.YxActivityService;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class YxActivityController implements SchoolControllerApi {

    @Autowired
    private YxActivityService yxActivityService;

    /**
     * 研学活动分页查询
     */
    @PostMapping("selectPage")
    @Override
    public Result selectPage(
            @RequestParam("nowPage") Integer nowPage,
            @RequestParam("pageSize") Integer pageSize,

            YxActivityQuery yxActivityQuery
    ) {
        System.out.println("--开始研学活动分页查询--");
        Page<YxActivity> pageParam = new Page<>(nowPage, pageSize);
        yxActivityService.selectPage(pageParam, yxActivityQuery);
        List<YxActivity> records = pageParam.getRecords();
        return Result.ok(
                new ResultListPage(
                        records, pageParam.getPages(), pageParam.getTotal(), pageParam.getCurrent(), pageParam.getSize()));

    }

    /**
     * 添加研学活动申报信息
     *
     * @param yxActivity
     * @return
     */
    @PutMapping("insert")
    @Override
    public Result insert(@RequestBody YxActivity yxActivity) {
        yxActivityService.save(yxActivity);
        return Result.ok();
    }
}

