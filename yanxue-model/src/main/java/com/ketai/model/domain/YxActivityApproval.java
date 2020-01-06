package com.ketai.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 活动批准表
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yx_activity_approval")
@ApiModel(value="YxActivityApproval对象", description="活动批准表")
public class YxActivityApproval implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批表主键")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "活动ID")
    private Integer activityId;

    @ApiModelProperty(value = "审批人名称")
    private String approveName;

    @ApiModelProperty(value = "审批人身份id")
    private Integer approverPeopleId;

    @ApiModelProperty(value = "审批人类型")
    private String approverPeopleType;

    @ApiModelProperty(value = "0未通过1已通过")
    private Integer approverStatus;

    @ApiModelProperty(value = "审批时间")
    private Date approverTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人userid")
    private Integer creator;

    @ApiModelProperty(value = "未通过理由")
    private String reasonsNotPassed;

    @ApiModelProperty(value = "0无效1有效")
    private Integer status;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人userid")
    private Integer updator;


}
