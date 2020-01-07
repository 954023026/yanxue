package com.ketai.activity.orgin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.orgin.service.YxCourseInfoService;
import com.ketai.api.orgin.YxCourseInfoControllerApi;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxCourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 研学课程信息
 */
@RestController("pc/base/course")
public class YxCourseInfoController implements YxCourseInfoControllerApi {

    @Autowired
    private YxCourseInfoService yxCourseInfoService;

    @GetMapping("/qryCourseInfoPageList")
    @Override
    public Result PageQuery(String baseName, Integer pageSize, Integer nowPage) {

        Page<YxCourseInfo> pageParam = new Page<>(nowPage, pageSize);
        yxCourseInfoService.pageQuery(pageParam,baseName);
        List<YxCourseInfo> records = pageParam.getRecords();
        return Result.ok(
                new ResultListPage(
                        records,pageParam.getPages(),pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));

    }
}
