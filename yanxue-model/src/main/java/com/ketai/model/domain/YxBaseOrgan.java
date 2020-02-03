package com.ketai.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 研学基地表
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="YxBaseOrgan对象", description="区(县)域表")
public class YxBaseOrgan implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "地区编码")
    private String code;

    @ApiModelProperty(value = "教育局名称")
    private String name;

    @ApiModelProperty(value = "教育局简称")
    private String shortName;

    @ApiModelProperty(value = "地区名称")
    private String regionName;

    @ApiModelProperty(value = "地区简称")
    private String regionShortName;

    @ApiModelProperty(value = "地区层级 2-省 4-市 6-区县")
    private Integer regionLevel;

    @ApiModelProperty(value = "上级编码")
    private String parentCode;

    @ApiModelProperty(value = "上级id")
    private Integer parent_id;

    @ApiModelProperty(value = "使用状态 1-有效，0-无效")
    private Integer status;

    @ApiModelProperty(value = "省级id")
    private Integer level2Id;

    @ApiModelProperty(value = "市级id")
    private Integer level4Id;

    @ApiModelProperty(value = "创建时间")
    private Date created_time;

    @ApiModelProperty(value = "修改时间")
    private Date updated_time;
}
