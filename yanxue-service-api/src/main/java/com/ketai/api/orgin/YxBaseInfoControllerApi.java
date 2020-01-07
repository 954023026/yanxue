package com.ketai.api.orgin;

import com.ketai.common.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "基地", description = "基地信息管理")
public interface YxBaseInfoControllerApi {

    @ApiOperation("根据基地名称分页查询")
    Result PageQuery(
            @ApiParam(name = "baseName",value = "基地名称",required = true)
            String baseName,
            @ApiParam(name = "pageSize",value = "每页显示数",required = true)
            Integer pageSize,
            @ApiParam(name = "nowPage",value = "当前页码",required = true)
            Integer nowPage);
}
