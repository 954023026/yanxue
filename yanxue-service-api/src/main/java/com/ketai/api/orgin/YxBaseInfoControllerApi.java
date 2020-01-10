package com.ketai.api.orgin;

import com.ketai.common.response.Result;
import com.ketai.model.domain.YxBaseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value = "基地", description = "基地信息管理")
public interface YxBaseInfoControllerApi {

    /**
     *  根据基地名称分页查询
     * @param baseName
     * @param pageSize
     * @param nowPage
     * @return
     */
    @ApiOperation("根据基地名称分页查询")
    Result PageQuery(
            @ApiParam(name = "baseName",value = "基地名称",required = true)
            String baseName,
            @ApiParam(name = "pageSize",value = "每页显示数",required = true)
            Integer pageSize,
            @ApiParam(name = "nowPage",value = "当前页码",required = true)
            Integer nowPage);
}
