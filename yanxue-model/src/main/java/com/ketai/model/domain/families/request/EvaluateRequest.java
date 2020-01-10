package com.ketai.model.domain.families.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "EvaluateRequest查询对象",description = "研学评分查询对象封装")
@Data
public class EvaluateRequest {

    @ApiModelProperty(value = "研学基地名称")
    private String baseName;

    @ApiModelProperty(value = "当前页")
    private Long nowPage;

    @ApiModelProperty(value = "每页大小")
    private Long pageSize;
}
