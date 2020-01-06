package com.ketai.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "研学课程")
public class CourseInfoModel implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id")
    private Integer id ;

    /**
     * 课程名称
     */
    @ApiModelProperty(value="课程名称")
    private String courseName= "";

    /**
     * 课程时长
     */
    @ApiModelProperty(value="课程时长")
    private String courseDuration= "";

    /**
     * 适合年级
     */
    @ApiModelProperty(value="适合年级")
    private String courseGrade= "";

    /**
     * 可参加人数
     */
    @ApiModelProperty(value="可参加人数")
    private String courseNum= "";

    /**
     * 课程类型
     */
    @ApiModelProperty(value="课程类型")
    private String courseType= "";

    /**
     * 封面照片url地址
     */
    @ApiModelProperty(value="封面照片url地址")
    private String coverPhotoUrl= "";

    /**
     * 状态; 0无效,1有效
     */
    @ApiModelProperty(value="状态; 0无效,1有效")
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
     * 所属课程ID
     */
    @ApiModelProperty(value="所属课程ID")
    private String baseId = "";

    /**
     * 详情
     */
    @ApiModelProperty(value="详情")
    private String details = "";

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
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

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}