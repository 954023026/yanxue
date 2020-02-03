package com.ketai.api.front;

import com.ketai.common.query.pcQuery.PcActivityRecordQuery;
import com.ketai.common.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "研学风采操作接口===>pc端")
public interface FrontActivityRecordControllerApi {
    @ApiOperation(value = "分页条件查询")
    public Result selectRecordPage(
            @ApiParam(name = "nowPage", value = "当前页码", required = true)
            @PathVariable Integer nowPage,
            @ApiParam(name = "pageSize", value = "每页记录数", required = true)
            @PathVariable Integer pageSize,
            @ApiParam(name = "pcActivityRecordQuery", value = "查询对象", required = false)
                    PcActivityRecordQuery pcActivityRecordQuery);

}
