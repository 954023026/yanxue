package com.ketai.common.query.pcQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel(value = "pcEvaluateInfoQuery查询对象",description = "评分查询对象")
@Data
public class PcEvaluateInfoQuery implements Serializable {
    private static  final long serialVersionUID=1L;

    @ApiModelProperty(value = "当前页")
    private Integer nowPage=1;

    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize;

}
