package com.ketai.api.front;

import com.ketai.common.response.Result;
import com.ketai.common.query.pcQuery.PcActivityQuery;
import com.ketai.common.response.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "研学活动操作接口===>pc端")
public interface FrontActivityControllerApi {
    @ApiOperation(value = "分页条件查询")
    public Result selectPage(
        @ApiParam(name = "page", value = "当前页码", required = true)
        @PathVariable Integer page,
        @ApiParam(name = "limit", value = "每页记录数", required = true)
        @PathVariable Integer limit,
        @ApiParam(name = "pcActivityQuery", value = "查询对象", required = false)
        PcActivityQuery pcActivityQuery
    );

    @ApiOperation(value = "根据id查询研学详情")
    public ResultMap selectById(
            @ApiParam(name="id",value = "研学实践id",required = true)
            @PathVariable Integer id
    );

    @ApiOperation(value = "获取所有的筛选项")
    public Result getSelectItem();

    @ApiOperation(value = "获取所有活动学年")
    public Result getAllSchYear();

    @ApiOperation(value = "获取统计总数")
    public Result getActivityStatisticsCount(String schyear);
}
