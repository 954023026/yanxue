package com.ketai.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "研学承办机构简介")
public class UndertakeOrgModelWithBLOBs extends UndertakeOrgModel implements Serializable {
    /**
     * 研学承办机构简介
     */
    @ApiModelProperty(value="研学承办机构简介")
    private String orgSynopsis;

    /**
     * 详情
     */
    @ApiModelProperty(value="详情")
    private String details;

    private static final long serialVersionUID = 1L;

    public String getOrgSynopsis() {
        return orgSynopsis;
    }

    public void setOrgSynopsis(String orgSynopsis) {
        this.orgSynopsis = orgSynopsis;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}