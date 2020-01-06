package com.ketai.model.domain;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ActivityFileModel implements Serializable {
    /**
     * 活动照片表; 主键ID
     */
    @ApiModelProperty(value="活动照片表; 主键ID")
    private Integer id;

    /**
     * activity 活动封面 poorStudentChart贫困生表organizationContract承办机构合同,letterOfCommitment安全承诺书,practiceScheme实践方案practiceReportChart实践表文件,record风采
     */
    @ApiModelProperty(value="activity 活动封面 poorStudentChart贫困生表organizationContract承办机构合同,letterOfCommitment安全承诺书,practiceScheme实践方案practiceReportChart实践表文件,record风采")
    private String targetType;

    /**
     * (-9999:表示活动默认图片地址)第三方id: activity_id, record_id, 
     */
    @ApiModelProperty(value="(-9999:表示活动默认图片地址)第三方id: activity_id, record_id, ")
    private Integer targetId;

    /**
     * 相片地址
     */
    @ApiModelProperty(value="相片地址")
    private String fileUrl;

    /**
     * 图片尺寸 宽度 像素
     */
    @ApiModelProperty(value="图片尺寸 宽度 像素")
    private Integer width;

    /**
     * 图片尺寸 高度 像素
     */
    @ApiModelProperty(value="图片尺寸 高度 像素")
    private Integer height;

    /**
     * 文件大小 kb
     */
    @ApiModelProperty(value="文件大小 kb")
    private Integer size;

    /**
     * 0无效1有效
     */
    @ApiModelProperty(value="0无效1有效",hidden = true)
    private Byte status;

    /**
     * 创建人user_id
     */
    @ApiModelProperty(value="创建人user_id",hidden = true)
    private Integer creator;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间",hidden = true)
    private Date createTime;

    /**
     * 更新人user_id
     */
    @ApiModelProperty(value="更新人user_id",hidden = true)
    private Integer updator;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间",hidden = true)
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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