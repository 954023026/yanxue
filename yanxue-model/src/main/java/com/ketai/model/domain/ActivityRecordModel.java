package com.ketai.model.domain;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ActivityRecordModel implements Serializable {
    /**
     * 研学风采主键
     */
    @ApiModelProperty(value="研学风采主键")
    private Integer id;

    /**
     * 活动ID
     */
    @ApiModelProperty(value="活动ID")
    private Integer activityId;

    /**
     * record活动风采 recordHome 首页8张风采 默认为record
     */
    @ApiModelProperty(value="record活动风采 recordHome 首页8张风采 默认为record",hidden = true)
    private String type;

    /**
     * 所属peopletype
     */
    @ApiModelProperty(value="所属peopletype")
    private String ownerPeopleType;

    /**
     * 所属people id
     */
    @ApiModelProperty(value="所属people id")
    private Integer ownerPeopleId;

    /**
     * 记录人peopleType
     */
    @ApiModelProperty(value="记录人peopleType")
    private String recordPeopleType;

    /**
     * 记录人peopleId
     */
    @ApiModelProperty(value="记录人peopleId")
    private Integer recordPeopleId;

    /**
     * 身份名称
     */
    @ApiModelProperty(value="身份名称")
    private String recordPeopleName;

    /**
     * 学生风采学年学期
     */
    @ApiModelProperty(value="学生风采学年学期",hidden = true)
    private String schyearTerm;

    /**
     * 评价内容
     */
    @ApiModelProperty(value="评价内容")
    private String content;

    /**
     * 公开类型: 0仅自己可见， 1公开
     */
    @ApiModelProperty(value="公开类型: 0仅自己可见， 1公开",hidden = true)
    private Byte publicStatus;

    /**
     * 状态: 0已删除, 1正常
     */
    @ApiModelProperty(value="状态: 0已删除, 1正常",hidden = true)
    private Byte status;

    /**
     * 创建人user_id
     */
    @ApiModelProperty(value="创建人user_id",hidden = true)
    private Integer creator;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 修改人user_id
     */
    @ApiModelProperty(value="修改人user_id",hidden = true)
    private Integer updator;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间",hidden = true)
    private Date updateTime;

    /**
     * 图片地址
     */
    @ApiModelProperty(value="图片地址")
    private String imageUrl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerPeopleType() {
        return ownerPeopleType;
    }

    public void setOwnerPeopleType(String ownerPeopleType) {
        this.ownerPeopleType = ownerPeopleType;
    }

    public Integer getOwnerPeopleId() {
        return ownerPeopleId;
    }

    public void setOwnerPeopleId(Integer ownerPeopleId) {
        this.ownerPeopleId = ownerPeopleId;
    }

    public String getRecordPeopleType() {
        return recordPeopleType;
    }

    public void setRecordPeopleType(String recordPeopleType) {
        this.recordPeopleType = recordPeopleType;
    }

    public Integer getRecordPeopleId() {
        return recordPeopleId;
    }

    public void setRecordPeopleId(Integer recordPeopleId) {
        this.recordPeopleId = recordPeopleId;
    }

    public String getRecordPeopleName() {
        return recordPeopleName;
    }

    public void setRecordPeopleName(String recordPeopleName) {
        this.recordPeopleName = recordPeopleName;
    }

    public String getSchyearTerm() {
        return schyearTerm;
    }

    public void setSchyearTerm(String schyearTerm) {
        this.schyearTerm = schyearTerm;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getPublicStatus() {
        return publicStatus;
    }

    public void setPublicStatus(Byte publicStatus) {
        this.publicStatus = publicStatus;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}