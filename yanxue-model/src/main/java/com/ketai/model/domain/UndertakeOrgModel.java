package com.ketai.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "研学承办机构")
public class UndertakeOrgModel implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 研学承办机构名称
     */
    @ApiModelProperty(value="研学承办机构名称")
    private String orgname = "";

    /**
     * 机构电话区号
     */
    @ApiModelProperty(value="机构电话区号")
    private String orgAreaPhone = "";

    /**
     * 承办机构电话号码
     */
    @ApiModelProperty(value="承办机构电话号码")
    private String orgPhone = "";

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
    private Byte status =1;

    /**
     * 创建人user_id
     */
    @ApiModelProperty(value="创建人user_id")
    private Integer creator;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

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
    private String responsiblePerson = "";

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

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getOrgAreaPhone() {
        return orgAreaPhone;
    }

    public void setOrgAreaPhone(String orgAreaPhone) {
        this.orgAreaPhone = orgAreaPhone;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
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