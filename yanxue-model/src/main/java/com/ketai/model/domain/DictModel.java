package com.ketai.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "字典表")
public class DictModel implements Serializable {
    /**
     * 主键ID
     */
    @ApiModelProperty(value="主键ID")
    private Integer id;

    /**
     * 类型
     */
    @ApiModelProperty(value="类型")
    private String dicType;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String dicName;

    /**
     * 编号
     */
    @ApiModelProperty(value="编号")
    private Integer dicCode;

    /**
     * 描述
     */
    @ApiModelProperty(value="描述")
    private String dicDesc;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer orderBy;

    /**
     * 是否删除 0：否；1：是
     */
    @ApiModelProperty(value="是否删除 0：否；1：是")
    private Byte isDelete;

    /**
     * 创建者
     */
    @ApiModelProperty(value="创建者")
    private Integer creator;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新者
     */
    @ApiModelProperty(value="更新者")
    private Integer updator;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public Integer getDicCode() {
        return dicCode;
    }

    public void setDicCode(Integer dicCode) {
        this.dicCode = dicCode;
    }

    public String getDicDesc() {
        return dicDesc;
    }

    public void setDicDesc(String dicDesc) {
        this.dicDesc = dicDesc;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdator() {
        return updator;
    }

    public void setUpdator(Integer updator) {
        this.updator = updator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}