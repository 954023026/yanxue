package com.ketai.api.front;

import com.ketai.common.query.pcQuery.PcBaseInfoQuery;
import com.ketai.common.query.pcQuery.PcUndertakeOrgQuery;
import com.ketai.common.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "研学承办机构操作接口===>pc端")
public interface FrontUndertakeControllerApi {
    @ApiOperation(value = "根据提交的表单信息分页查询研学承办机构信息（包括实践活动次数）")
    public Result qryUndertakeOrginInfoPage(
            @ApiParam(name = "pcBaseInfoQuery", value = "查询对象", required = false)
                    PcUndertakeOrgQuery pcUndertakeOrgQuery
    );

    @ApiOperation(value = "根据id查询研学承办机构信息")
    public Result qryUndertakeOrgInfo(
            @ApiParam(name = "id", value = "基地id", required = true)
            @PathVariable Integer id
    );

    @ApiOperation(value = "根据承办机构id分页查询研学承办机构评分信息")
    public Result qryUndertakeOrgEvaluatePage(
            @ApiParam(name = "pcUndertakeOrgQuery", value = "查询对象", required = false)
                    PcUndertakeOrgQuery pcUndertakeOrgQuery,
            @ApiParam(name = "undertakeOrgId", value = "研学承办机构id", required = true)
            @PathVariable Integer undertakeOrgId
    );

    @ApiOperation(value = "根据id查询研学承办机构评分(总的评分)信息")
    public Result qryUndertakeOrgEvaluateInfo(
            @ApiParam(name = "id", value = "承办机构id", required = true)
            @PathVariable Integer id
    );


}
