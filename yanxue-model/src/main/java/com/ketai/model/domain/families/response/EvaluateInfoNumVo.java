package com.ketai.model.domain.families.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class EvaluateInfoNumVo implements Serializable {

    @ApiModelProperty(value = "星级")
    private Integer score;

    @ApiModelProperty(value = "星级数量")
    private Integer scores;

}
