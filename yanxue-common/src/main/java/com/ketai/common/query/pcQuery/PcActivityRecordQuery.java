package com.ketai.common.query.pcQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel(value = "pcActivityRecordQuery查询对象",description = "前台研学风采查询对象")
@Data
public class PcActivityRecordQuery implements Serializable {
    private static  final long serialVersionUID=1L;

    @ApiModelProperty(value = "当前页")
    private Integer nowPage=1;

    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize=4;

    @ApiModelProperty(value = "学习阶段1小学2初中4高中")
    private Integer studyStep;

    @ApiModelProperty(value = "record活动风采")
    private String type="recordHome";

    @ApiModelProperty(value = "活动id")
    private Integer activityId;

}
