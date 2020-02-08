package com.ketai.api.front;

import com.ketai.common.query.pcQuery.PcActivityQuery;
import com.ketai.common.query.pcQuery.PcBaseInfoQuery;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "研学基地操作接口===>pc端")
public interface FrontBaseInfoControllerApi {
    @ApiOperation(value = "分页条件查询")
    public Result qryBaseInfoPage(
            @ApiParam(name = "pcBaseInfoQuery", value = "查询对象", required = false)
                    PcBaseInfoQuery pcBaseInfoQuery
    );

    @ApiOperation(value = "根据基地id分页查询研学基地评分信息")
    public Result qryBaseEvaluatePage(
            @ApiParam(name = "nowPage", value = "当前页码", required = true)
            @PathVariable Integer nowPage,
            @ApiParam(name = "pageSize", value = "每页记录数", required = true)
            @PathVariable Integer pageSize,
            @ApiParam(name = "baseId", value = "基地id", required = true)
            @PathVariable Integer baseId
    );

    @ApiOperation(value = "根据id查询研学基地信息")
    public Result qryBaseInfo(
            @ApiParam(name = "id", value = "基地id", required = true)
            @PathVariable Integer id);

    @ApiOperation(value = "根据id查询研学基地评分(总的评分)信息")
    public Result qryBaseEvaluateInfo(
            @ApiParam(name = "id", value = "基地id", required = true)
            @PathVariable Integer id);
}
