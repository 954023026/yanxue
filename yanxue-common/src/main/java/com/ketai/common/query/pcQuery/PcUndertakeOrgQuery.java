package com.ketai.common.query.pcQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel(value = "PcUndertakeOrgQuery查询对象",description = "前台研学承办机构查询对象")
@Data
public class PcUndertakeOrgQuery implements Serializable {
    private static  final long serialVersionUID=1L;

    @ApiModelProperty(value = "当前页")
    private Integer nowPage=1;

    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize;

    @ApiModelProperty(value = "研学承办机构模糊查询值")
    private String orgname;

    @ApiModelProperty(value = "承办机构id")
    private Integer id;




}
