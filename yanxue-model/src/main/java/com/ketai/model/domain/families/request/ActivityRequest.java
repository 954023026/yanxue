package com.ketai.model.domain.families.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ActivityRequest查询对象",description = "研学活动查询对象封装")
@Data
public class ActivityRequest {

    @ApiModelProperty(value = "基地名称")
    private String baseName;

    @ApiModelProperty(value = "区县名称")
    private String organName;

    @ApiModelProperty(value = "学习阶段")
    private Integer studyStep;

    @ApiModelProperty(value = "研学状态")
    private Integer auditStatus;

    @ApiModelProperty(value = "研学状态2,研学归档页面中的字段")
    private Integer auditName;

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
