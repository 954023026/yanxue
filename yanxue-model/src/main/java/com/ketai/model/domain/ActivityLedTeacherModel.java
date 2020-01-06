package com.ketai.model.domain;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ActivityLedTeacherModel implements Serializable {
    /**
     * 研学带队老师主键
     */
    @ApiModelProperty(value="研学带队老师主键")
    private Integer id;

    /**
     * 活动id
     */
    @ApiModelProperty(value="活动id")
    private Integer activityId;

    /**
     * 学校ID
     */
    @ApiModelProperty(value="学校ID")
    private Integer schId;

    /**
     * 学校名
     */
    @ApiModelProperty(value="学校名")
    private String schName;

    /**
     * 老师姓名
     */
    @ApiModelProperty(value="老师姓名")
    private String name;

    /**
     * 老师类型，1：带队老师2：随队老师
     */
    @ApiModelProperty(value="老师类型，1：带队老师2：随队老师")
    private String teacherType;

    /**
     * 状态; 0无效, 1有效
     */
    @ApiModelProperty(value="状态; 0无效, 1有效",hidden = true)
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
     * 修改时间
     */
    @ApiModelProperty(value="修改时间",hidden = true)
    private Date updateTime;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phoneNumber;

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

    public Integer getSchId() {
        return schId;
    }

    public void setSchId(Integer schId) {
        this.schId = schId;
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}