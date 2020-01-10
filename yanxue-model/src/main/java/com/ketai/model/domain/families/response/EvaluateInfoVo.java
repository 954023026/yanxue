package com.ketai.model.domain.families.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 研学活动评分表
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Data
@ApiModel(description = "研学活动评分Vo类")
public class EvaluateInfoVo implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "本次基地id")
    private Integer baseId;

    @ApiModelProperty(value = "研学基地名称")
    private String baseName;

    @ApiModelProperty(value = "评价人数")
    private Integer cnt;

    @ApiModelProperty(value = "基地管理评分（1-5分）")
    private BigDecimal baseManageScore;

    @ApiModelProperty(value = "研学课程评分（1-5分）")
    private BigDecimal courseScore;


    @ApiModelProperty(value = "安全措施评分1-5分")
    private BigDecimal safetyScore;

    @ApiModelProperty(value = "总评分（前面五项算平均分，四舍五入保留小数点一位）")
    private BigDecimal score;

    @ApiModelProperty(value = "服务态度评分（1-5分）")
    private BigDecimal serviceScore;

    @ApiModelProperty(value = "承办机构服务态度评分（1-5分）")
    private BigDecimal undertakeServiceScore;


}
