package com.ketai.common.query.pcQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel(value = "pcActivityQuery查询对象",description = "前台研学实践查询对象")
@Data
public class PcBaseInfoQuery implements Serializable {
    private static  final long serialVersionUID=1L;

    @ApiModelProperty(value = "当前页")
    private Integer nowPage=1;

    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize=3;

    @ApiModelProperty(value = "区县id")
    private String areaId;

    @ApiModelProperty(value = "基地名称")
    private String baseName;

    @ApiModelProperty(value = "基地标签")
    private String baseTags;

    @ApiModelProperty(value = "基地类型")
    private String baseType;


}
