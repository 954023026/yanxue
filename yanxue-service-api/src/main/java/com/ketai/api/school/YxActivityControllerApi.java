package com.ketai.api.school;


import com.ketai.common.query.YxActivityQuery;
import com.ketai.common.response.Result;
import com.ketai.model.domain.YxActivity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Api(value = "研学负责人操作", description = "研学负责人管理中心")
public interface YxActivityControllerApi {


    @ApiOperation("研学活动分页查询")
    public Result selectPage(
            @ApiParam(name = "nowPage", value = "当前页码", required = true) Integer nowPage,
            @ApiParam(name = "pageSize", value = "每页记录数", required = true)Integer pageSize,
            @ApiParam(name = "yxActivityQuery", value = "查询对象", required = false) YxActivityQuery yxActivityQuery
    );

    @ApiOperation("添加研学活动申报信息")
    public Result insert(
            @ApiParam(name = "yxActivity",value = "研学活动对象",required = true)YxActivity yxActivity
    );
}

