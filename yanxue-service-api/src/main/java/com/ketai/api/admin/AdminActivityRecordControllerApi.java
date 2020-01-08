package com.ketai.api.admin;


import com.ketai.common.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 研学(活动)风采表 前端控制器
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Api(value = "研学活动风采操作", description = "研学活动风采接口")
public interface AdminActivityRecordControllerApi {

    @ApiOperation("添加风采图片")
    public Result addRecord(
            @ApiParam(value = "图片地址", required = true)String imageUrl
    );

    @ApiOperation("删除风采图片")
    Result deleteRecordHome(@ApiParam(value = "图片id", required = true) Integer recordId);

}

