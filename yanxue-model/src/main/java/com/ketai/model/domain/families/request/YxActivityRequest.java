package com.ketai.model.domain.families.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *  研学活动条件封装
 *
 **/
@ApiModel(description = "研学活动条件对象封装")
@Data
public class YxActivityRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "区县名称")
    private String organName;

    @ApiModelProperty(value = "学习阶段")
    private String state;

    @ApiModelProperty(value = "学校名称")
    private String schName;

    @ApiModelProperty(value = "活动开始时间")
    private String serStartTime;

    @ApiModelProperty(value = "活动结束时间")
    private String serEndTime;

}
