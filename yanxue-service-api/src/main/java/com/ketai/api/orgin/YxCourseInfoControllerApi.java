package com.ketai.api.orgin;


import com.ketai.common.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "课程", description = "课程信息管理")
public interface YxCourseInfoControllerApi {


    @ApiOperation("根据课程名称分页查询")
    Result PageQuery(
            @ApiParam(name = "orgname",value = "基地名称",required = true)
                    String baseName,
            @ApiParam(name = "pageSize",value = "每页显示数",required = true)
                    Integer pageSize,
            @ApiParam(name = "nowPage",value = "当前页码",required = true)
                    Integer nowPage);
}
