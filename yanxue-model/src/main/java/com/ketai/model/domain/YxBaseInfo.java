package com.ketai.model.domain;

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
 * 研学基地表
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="YxBaseInfo对象", description="研学基地表")
public class YxBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "相册url")
    private String albumUrl;

    @ApiModelProperty(value = "区编码")
    private String areaId;

    @ApiModelProperty(value = "区县")
    private String areaName;

    @ApiModelProperty(value = "基地电话区号")
    private String baseAreaPhone;

    @ApiModelProperty(value = "基地名称")
    private String baseName;

    @ApiModelProperty(value = "基地电话号码")
    private String basePhone;

    @ApiModelProperty(value = "基地标签，从 yx_dic表读取，多个值用逗号分隔")
    private String baseTags;

    @ApiModelProperty(value = "基地类型（1省内，2省外）")
    private String baseType;

    @ApiModelProperty(value = "封面照片url地址")
    private String coverPhotoUrl;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建人user_id")
    private Integer creator;

    @ApiModelProperty(value = "负责人")
    private String responsiblePerson;

    @ApiModelProperty(value = "状态; 0无效, 1有效")
    private Integer status;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改人")
    private Integer updator;


}
