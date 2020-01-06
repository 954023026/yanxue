package com.ketai.activity.school.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *  研学活动查询类
 **/
@ApiModel(value = "研学活动查询对象",description = "研学活动对象封装")
@Data
public class YxActivityQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "基地名称，模糊查询")
    private String baseName;

    @ApiModelProperty(value = "承办机构名称，模糊查询")
    private String organizationName;

    @ApiModelProperty(value = "审批状态，模糊查询")
    private String auditStatus;

    @ApiModelProperty(value = "研学主题名称，模糊查询")
    private String activityName;

    @ApiModelProperty(value = "活动开始时间，模糊查询")
    private String serStartTime;

    @ApiModelProperty(value = "活动结束时间，模糊查询")
    private String serEndTime;

}
