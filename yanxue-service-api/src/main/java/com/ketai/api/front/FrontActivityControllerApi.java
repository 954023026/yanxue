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
        @ApiParam(name = "pcActivityQuery", value = "查询对象", required = false)
        PcActivityQuery pcActivityQuery
    );

    @ApiOperation(value = "根据id查询研学详情")
    public Result activityDetailsById(
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
