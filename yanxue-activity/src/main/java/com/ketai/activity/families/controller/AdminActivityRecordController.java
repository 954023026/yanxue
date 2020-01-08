package com.ketai.activity.families.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ketai.activity.families.service.YxActivityRecordService;
import com.ketai.api.admin.AdminActivityRecordControllerApi;
import com.ketai.common.exception.ExceptionThrowOut;
import com.ketai.common.response.Result;
import com.ketai.model.domain.YxActivityRecord;
import com.ketai.model.domain.families.response.FileSystemCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 研学(活动)风采表 前端控制器
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/admin/record/")
public class AdminActivityRecordController implements AdminActivityRecordControllerApi {
    @Autowired
    private YxActivityRecordService recordService;

    @PostMapping("addRecord")
    @Override
    public Result addRecord(@RequestParam("imageUrl") String imageUrl) {
        recordService.addRecord(imageUrl);
        return Result.ok();
    }

    @PostMapping("deleteRecordHome")
    @Override
    public Result deleteRecordHome(@RequestParam("recordId") Integer recordId) {
        recordService.removeById(recordId);
        return Result.ok();
    }
}

