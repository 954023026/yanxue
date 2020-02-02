package com.ketai.api.orgin;

import com.ketai.common.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

import javax.swing.*;

/**
 * 区(县)域表
 */
@Api(value = "基地", description = "基地信息管理")
public interface YxBaseOrganControllerApi {

    /**
     *  根据parentCode 或 partentId进行查询区域信息
     * @param code
     * @return
     */
    Result selByparentCode(
            @ApiParam(name = "code",value = "父级编码或父级id")
                    Long code);
}
