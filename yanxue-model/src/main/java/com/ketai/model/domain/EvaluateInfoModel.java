package com.ketai.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@ApiModel(value = "研学活动评分")
public class EvaluateInfoModel implements Serializable {
    /**
     * 研学活动基地评分表
     */
    @ApiModelProperty(value="研学活动基地评分表")
    private Integer id;

    /**
     * 评分内容
     */
    @ApiModelProperty(value="评分内容")
    private String context = "";

    /**
     * 本次基地id
     */
    @ApiModelProperty(value="本次基地id")
    private Integer baseId ;

    /**
     * 本次活动id
     */
    @ApiModelProperty(value="本次活动id")
    private Integer activityId ;

    /**
     * 安全措施评分1-5分
     */
    @ApiModelProperty(value="安全措施评分1-5分")
    private BigDecimal safetyScore = new BigDecimal(1);

    /**
     * 服务态度评分（1-5分）
     */
    @ApiModelProperty(value="服务态度评分（1-5分）")
    private BigDecimal serviceScore = new BigDecimal(1);

    /**
     * 研学课程评分（1-5分）
     */
    @ApiModelProperty(value="研学课程评分（1-5分）")
    private BigDecimal courseScore = new BigDecimal(1);

    /**
     * 基地管理评分（1-5分）
     */
    @ApiModelProperty(value="基地管理评分（1-5分）")
    private BigDecimal baseManageScore = new BigDecimal(1);


    @ApiModelProperty(value="承办机构服务态度评分（1-5分）")
    private BigDecimal undertakeServiceScore = new BigDecimal(1);

    /**
     * 总评分（前面五项算平均分，四舍五入保留小数点一位）
     */
    @ApiModelProperty(value="总评分（前面五项算平均分，四舍五入保留小数点一位）")
    private BigDecimal score ;

    /**
     * 所属学校ID
     */
    @ApiModelProperty(value="所属学校ID")
    private Integer schoolId  ;

    /**
     * 显示1；隐藏0
     */
    @ApiModelProperty(value="显示1；隐藏0")
    private String display = "1";

    /**
     * 状态; 0无效, 1有效
     */
    @ApiModelProperty(value="状态; 0无效, 1有效")
    private Byte status = 1;

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
     * 承办机构ID
     */
    @ApiModelProperty(value="承办机构ID")
    private Integer undertakeOrgId;

    public BigDecimal getUndertakeServiceScore() {
        undertakeServiceScore = undertakeServiceScore.setScale(0,RoundingMode.HALF_UP);
        return undertakeServiceScore;
    }

    public void setUndertakeServiceScore(BigDecimal undertakeServiceScore) {
        this.undertakeServiceScore = undertakeServiceScore;
    }

    /**
     * 评分人ID
     */
    @ApiModelProperty(value="评分人ID")
    private Integer peopleId;

    /**
     * 评分人类型
     */
    @ApiModelProperty(value="评分人类型")
    private String peopleType;

    /**
     * 评分人姓名
     */
    @ApiModelProperty(value="评分人姓名")
    private String peopleName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public BigDecimal getSafetyScore() {
        safetyScore = safetyScore.setScale(0,RoundingMode.HALF_UP);
        return safetyScore;
    }

    public void setSafetyScore(BigDecimal safetyScore) {
        this.safetyScore = safetyScore;
    }

    public BigDecimal getServiceScore() {
        serviceScore =  serviceScore.setScale(0,RoundingMode.HALF_UP);
        return serviceScore;
    }

    public void setServiceScore(BigDecimal serviceScore) {
        this.serviceScore = serviceScore;
    }

    public BigDecimal getCourseScore() {
        courseScore = courseScore.setScale(0,RoundingMode.HALF_UP);
        return courseScore;
    }

    public void setCourseScore(BigDecimal courseScore) {
        this.courseScore = courseScore;
    }

    public BigDecimal getBaseManageScore() {
        baseManageScore = baseManageScore.setScale(0,RoundingMode.HALF_UP);
        return baseManageScore;
    }

    public void setBaseManageScore(BigDecimal baseManageScore) {
        this.baseManageScore = baseManageScore;
    }

    public BigDecimal getScore() {
        BigDecimal _score = new BigDecimal(1)  ;
        BigDecimal b = new BigDecimal(5); //  被除数
        int scale = 1; //
         _score = this.safetyScore.add(this.serviceScore).add(this.courseScore).add(this.baseManageScore).add(this.undertakeServiceScore).divide(b);
        //_score = this.safetyScore.add(this.serviceScore).add(this.courseScore).add(this.baseManageScore).add(this.undertakeServiceScore);
       // int a = _score.intValue();
        _score = _score.setScale(scale,RoundingMode.HALF_UP);
        return _score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
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

    public Integer getUndertakeOrgId() {
        return undertakeOrgId;
    }

    public void setUndertakeOrgId(Integer undertakeOrgId) {
        this.undertakeOrgId = undertakeOrgId;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public String getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(String peopleType) {
        this.peopleType = peopleType;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }
}