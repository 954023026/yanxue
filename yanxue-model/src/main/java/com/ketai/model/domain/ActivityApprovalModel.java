package com.ketai.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActivityApprovalModel implements Serializable {
    /**
     * 审批表主键
     */
    @ApiModelProperty(value="审批表主键")
    private Integer id;

    /**
     * 活动ID
     */
    @ApiModelProperty(value="活动ID")
    private Integer activityId;

    /**
     * 审批人身份id
     */
    @ApiModelProperty(value="审批人身份id")
    private Integer approverPeopleId;

    /**
     * 审批人类型
     */
    @ApiModelProperty(value="审批人类型")
    private String approverPeopleType;
    /**
     * 审批人名称
     */
    @ApiModelProperty(value="审批人名称")
    private String approveName;

    /**
     * 审批时间
     */
    @ApiModelProperty(value="审批时间")
    private Date approverTime;

    /**
     * 0无效1有效
     */
    @ApiModelProperty(value="0无效1有效",hidden = true)
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间",hidden = true)
    private Date updateTime;

    /**
     * 创建人userid
     */
    @ApiModelProperty(value="创建人userid",hidden = true)
    private Integer creator;

    /**
     * 更新人userid
     */
    @ApiModelProperty(value="更新人userid",hidden = true)
    private Integer updator;

    /**
     * 未通过理由
     */
    @ApiModelProperty(value="未通过理由")
    private String reasonsNotPassed;

    /**
     * 0未通过1已通过
     */
    @ApiModelProperty(value="0未通过1已通过")
    private Integer approverStatus;

    private static final long serialVersionUID = 1L;

}