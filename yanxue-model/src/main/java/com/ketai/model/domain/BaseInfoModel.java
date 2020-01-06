package com.ketai.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "研学基地")
public class BaseInfoModel implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Integer id  ;

    /**
     * 基地名称
     */
    @ApiModelProperty(value="基地名称")
    private String baseName = "";

    /**
     * 基地标签，从 yx_dic表读取，多个值用逗号分隔
     */
    @ApiModelProperty(value="基地标签，从 yx_dic表读取，多个值用逗号分隔")
    private String baseTags = "";

    /**
     * 基地类型（1省内，2省外）
     */
    @ApiModelProperty(value="基地类型（1省内，2省外）")
    private String baseType = "";

    /**
     * 基地电话区号
     */
    @ApiModelProperty(value="基地电话区号")
    private String baseAreaPhone = "";

    /**
     * 基地电话号码
     */
    @ApiModelProperty(value="基地电话号码")
    private String basePhone = "";

    /**
     * 区编码
     */
    @ApiModelProperty(value="区编码")
    private String areaId = "";

    /**
     * 区县
     */
    @ApiModelProperty(value="区县")
    private String areaName = "";

    /**
     * 详细地址
     */
    @ApiModelProperty(value="详细地址")
    private String address = "";

    /**
     * 封面照片url地址
     */
    @ApiModelProperty(value="封面照片url地址")
    private String coverPhotoUrl = "";

    /**
     * 相册url
     */
    @ApiModelProperty(value="相册url")
    private String albumUrl = "";

    /**
     * 状态; 0无效, 1有效
     */
    @ApiModelProperty(value="状态; 0无效, 1有效")
    private Byte status = 1;

    /**
     * 创建人user_id
     */
    @ApiModelProperty(value="创建人user_id")
    private Integer creator = 1;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime ;

    /**
     * 修改人
     */
    @ApiModelProperty(value="修改人")
    private Integer updator;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    /**
     * 负责人
     */
    @ApiModelProperty(value="负责人")
    private String responsiblePerson  = "";

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseTags() {
        return baseTags;
    }

    public void setBaseTags(String baseTags) {
        this.baseTags = baseTags;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public String getBaseAreaPhone() {
        return baseAreaPhone;
    }

    public void setBaseAreaPhone(String baseAreaPhone) {
        this.baseAreaPhone = baseAreaPhone;
    }

    public String getBasePhone() {
        return basePhone;
    }

    public void setBasePhone(String basePhone) {
        this.basePhone = basePhone;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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