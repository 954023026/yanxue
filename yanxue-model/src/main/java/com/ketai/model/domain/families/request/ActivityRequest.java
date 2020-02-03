package com.ketai.model.domain.families.request;

import com.ketai.common.model.request.RequestData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ActivityRequest查询对象",description = "研学活动查询对象封装")
@Data
public class ActivityRequest extends RequestData {
    @ApiModelProperty(value = "区县名称")
    private String organName;

    @ApiModelProperty(value = "学习阶段")
    private Integer state;

    @ApiModelProperty(value = "学校名称")
    private String schName;

}
