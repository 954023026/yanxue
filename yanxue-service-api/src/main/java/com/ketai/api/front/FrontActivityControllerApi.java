package com.ketai.api.front;

import com.ketai.common.response.Result;
import com.ketai.model.domain.pcQuery.PcActivityQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "研学活动操作接口===>pc端")
public interface FrontActivityControllerApi {
    @ApiOperation(value = "分页条件查询")
    public Result selectPage(Integer page, Integer limit, PcActivityQuery pcActivityQuery);

    @ApiOperation(value = "根据id查询研学详情")
    public Result selectById(Integer id);
}
