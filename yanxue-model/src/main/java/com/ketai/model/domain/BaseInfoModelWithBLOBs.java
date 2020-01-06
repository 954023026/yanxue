package com.ketai.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(value = "研学基地简介")
public class BaseInfoModelWithBLOBs extends BaseInfoModel implements Serializable {
    /**
     * 基地简介
     */
    @ApiModelProperty(value="基地简介")
    private String baseSynopsis = "";

    /**
     * 详情
     */
    @ApiModelProperty(value="详情")
    private String details = "";
    /**
     * 基地活动数
     */
    @ApiModelProperty(value="基地活动数")
    private int baseActivityNumber;
    /**
     * 基地参与人数
     */
    @ApiModelProperty(value="基地参与人数")
    private int basePeopleNumber;

    private static final long serialVersionUID = 1L;

    public String getBaseSynopsis() {
        return baseSynopsis;
    }

    public void setBaseSynopsis(String baseSynopsis) {
        this.baseSynopsis = baseSynopsis;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public int getBaseActivityNumber() {
        return baseActivityNumber;
    }

    public void setBaseActivityNumber(int baseActivityNumber) {
        this.baseActivityNumber = baseActivityNumber;
    }

    public int getBasePeopleNumber() {
        return basePeopleNumber;
    }

    public void setBasePeopleNumber(int basePeopleNumber) {
        this.basePeopleNumber = basePeopleNumber;
    }
}