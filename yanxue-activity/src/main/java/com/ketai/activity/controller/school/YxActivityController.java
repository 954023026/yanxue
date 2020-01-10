package com.ketai.activity.controller.school;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.YxActivityService;
import com.ketai.api.school.SchoolControllerApi;
import com.ketai.common.query.YxActivityQuery;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxActivity;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
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
     * @param yxActivityQuery
     * @return
     */
    @PutMapping("insert")
    @Override
    public Result insert(@ApiParam YxActivityQuery yxActivityQuery) {
        System.out.println("开始新增申报信息");
        YxActivity yxActivity = new YxActivity();
        BeanUtils.copyProperties(yxActivityQuery,yxActivity);
        //创建研学活动保存申报信息，默认审批状态为：未提交
        yxActivity.setAuditStatus(1);
        yxActivityService.save(yxActivity);
        System.out.println("测试是否新增成功："+yxActivity);
        return Result.ok();
    }
}

