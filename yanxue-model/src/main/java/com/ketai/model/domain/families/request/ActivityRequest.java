package com.ketai.model.domain.families.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ActivityRequest查询对象",description = "研学活动查询对象封装")
@Data
public class ActivityRequest {
    @ApiModelProperty(value = "区县名称")
    private String organName;

    @ApiModelProperty(value = "学习阶段")
    private Integer state;

    @ApiModelProperty(value = "学校名称")
    private String schName;

    @ApiModelProperty(value = "开始时间")
    private String serStartTime;

    @ApiModelProperty(value = "结束时间")
    private String serEndTime;

    @ApiModelProperty(value = "当前页")
    private Long nowPage;

    @ApiModelProperty(value = "每页大小")
    private Long pageSize;
}
