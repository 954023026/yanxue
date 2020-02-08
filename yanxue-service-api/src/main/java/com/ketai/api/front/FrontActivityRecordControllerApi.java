package com.ketai.api.front;

import com.ketai.common.query.pcQuery.PcActivityRecordQuery;
import com.ketai.common.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "研学风采操作接口===>pc端")
public interface FrontActivityRecordControllerApi {
    @ApiOperation(value = "分页条件查询")
    public Result selectRecordPage(
            @ApiParam(name = "pcActivityRecordQuery", value = "查询对象", required = false)
                    PcActivityRecordQuery pcActivityRecordQuery);

}
