package com.ketai.activity.controller.orgin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.YxCourseInfoService;
import com.ketai.api.orgin.YxCourseInfoControllerApi;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxCourseInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 研学课程信息
 */
@RestController()
@RequestMapping("pc/base/course")
public class YxCourseInfoController implements YxCourseInfoControllerApi {

    @Autowired
    private YxCourseInfoService yxCourseInfoService;

    @PostMapping("/qryCourseInfoPage")
    @Override
    public Result PageQuery(String baseName, Integer id,
                            @RequestParam(defaultValue = "5")Integer pageSize,
                            @RequestParam(defaultValue = "0")Integer nowPage) {
        Page<YxCourseInfo> pageParam = new Page<>(nowPage, pageSize);
        yxCourseInfoService.pageQuery(pageParam,id,baseName);
        List<YxCourseInfo> records = pageParam.getRecords();
        if(!StringUtils.isEmpty(id)){
            return Result.ok(records.get(0));
        }
        return Result.ok(
                new ResultListPage(
                        records,pageParam.getPages(),pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));
    }
}
