package com.ketai.api.admin;


import com.ketai.common.response.Result;
import com.ketai.model.domain.YxBaseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;


@Api(value = "基地", description = "Admin基地信息管理")
public interface AdminYxBaseInfoControllerApi {

    /**
     * 研学基地新增或修改
     * @param yxBaseInfo
     * @return
     * @auther 李
     */
    @ApiOperation("根据是否含有id进行新增或修改")
    Result saveBaseInfo(
            @ApiParam(name = "yxBaseInfo",value = "研学基地基本信息")
            @RequestBody YxBaseInfo yxBaseInfo
    );
}
