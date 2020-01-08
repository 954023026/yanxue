package com.ketai.common.query.pcQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel(value = "pcActivityQuery查询对象",description = "前台研学实践查询对象")
@Data
public class PcActivityQuery implements Serializable {
    private static  final long serialVersionUID=1L;

    @ApiModelProperty(value = "研学活动名称模糊查询值")
    private String activityName;

    @ApiModelProperty(value = "区县id")
    private Integer organId;

    @ApiModelProperty(value = "参与年级，多个用，分隔如一年级和二年级   一年级，二年级")
    private String participationSchYear;

    @ApiModelProperty(value = "学习阶段1小学2初中4高中")
    private Integer studyStep;

    @ApiModelProperty(value = "基地id")
    private Integer baseId;

    @ApiModelProperty(value = "研学承办机构id")
    private Integer organizationId;
}
