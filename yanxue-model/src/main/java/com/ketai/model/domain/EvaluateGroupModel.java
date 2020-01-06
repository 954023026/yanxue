package com.ketai.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;


@ApiModel(value = "研学活动评分")
public class EvaluateGroupModel implements Serializable {

    /**
     * 评分
     */
    @ApiModelProperty(value="评分")
    private String score = "0" ;
    /**
     * 评分数量
     */
    @ApiModelProperty(value="评分数量")
    private Integer cnt = 0 ;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }
}
