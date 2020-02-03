package com.ketai.activity.controller.admin;

import com.ketai.activity.service.YxCourseInfoService;
import com.ketai.api.admin.AdminYxCourseInfoControllerApi;
import com.ketai.common.response.Result;
import com.ketai.model.domain.YxCourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 研学课程
 */
@RestController
@RequestMapping("admin/base/course")
public class AdminYxCourseInfoController implements AdminYxCourseInfoControllerApi {

    @Autowired
    private YxCourseInfoService courseInfoService;

    /**
     * 根据是否有id来判断 新增或修改 研学课程
     * @param yxCourseInfo
     * @return
     * @auther 李
     */
    @PostMapping("/saveCourseInfo")
    @Override
    public Result saveBaseInfo(@RequestBody YxCourseInfo yxCourseInfo) {
        if(!StringUtils.isEmpty(yxCourseInfo.getId())){
            return courseInfoService.saveAndFulsh(yxCourseInfo);
        }
        yxCourseInfo.setId(UUID.randomUUID().hashCode());
        return courseInfoService.saveCourseInfo(yxCourseInfo);
    }
}
