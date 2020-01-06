package com.ketai.model.domain;

import java.math.BigDecimal;
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
 * 研学活动评分表
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="YxEvaluateInfo对象", description="研学活动评分表")
public class YxEvaluateInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "本次活动id")
    private Integer activityId;

    @ApiModelProperty(value = "本次基地id")
    private Integer baseId;

    @ApiModelProperty(value = "基地管理评分（1-5分）")
    private BigDecimal baseManageScore;

    @ApiModelProperty(value = "评分内容")
    private String context;

    @ApiModelProperty(value = "研学课程评分（1-5分）")
    private BigDecimal courseScore;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人user_id")
    private Integer creator;

    @ApiModelProperty(value = "显示1；隐藏0")
    private String display;

    @ApiModelProperty(value = "评分人ID")
    private Integer peopleId;

    @ApiModelProperty(value = "评分人姓名")
    private String peopleName;

    @ApiModelProperty(value = "评分人类型")
    private String peopleType;

    @ApiModelProperty(value = "安全措施评分1-5分")
    private BigDecimal safetyScore;

    @ApiModelProperty(value = "所属学校ID")
    private Integer schoolId;

    @ApiModelProperty(value = "总评分（前面五项算平均分，四舍五入保留小数点一位）")
    private BigDecimal score;

    @ApiModelProperty(value = "服务态度评分（1-5分）")
    private BigDecimal serviceScore;

    @ApiModelProperty(value = "状态; 0无效, 1有效")
    private Integer status;

    @ApiModelProperty(value = "承办机构ID")
    private Integer undertakeOrgId;

    @ApiModelProperty(value = "承办机构服务态度评分（1-5分）")
    private BigDecimal undertakeServiceScore;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改人")
    private Integer updator;


}
