package com.ketai.activity.controller.admin;


import com.ketai.activity.service.YxActivityRecordService;
import com.ketai.api.admin.AdminActivityRecordControllerApi;
import com.ketai.common.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 添加风采图片
     * @param imageUrl
     * @return
     * @author 周
     */
    @PostMapping("addRecord")
    @Override
    public Result addRecord(@RequestParam("imageUrl") String imageUrl) {
        recordService.addRecord(imageUrl);
        return Result.ok();
    }

    /**
     * 删除风采照片
     * @param recordId
     * @return
     * @author 周
     */
    @PostMapping("deleteRecordHome")
    @Override
    public Result deleteRecordHome(@RequestParam("recordId") Integer recordId) {
        recordService.removeById(recordId);
        return Result.ok();
    }
}

