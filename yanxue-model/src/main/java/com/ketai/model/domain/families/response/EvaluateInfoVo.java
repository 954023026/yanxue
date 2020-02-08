package com.ketai.model.domain.families.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ketai.model.domain.YxEvaluateInfo;
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
public class EvaluateInfoVo extends YxEvaluateInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "研学基地名称")
    private String baseName;

    @ApiModelProperty(value = "评价人数")
    private Integer cnt;

    @ApiModelProperty(value = "研学活动名称")
    private String activityName;
}
