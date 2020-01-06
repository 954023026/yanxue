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
 * 研学课程表
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="YxCourseInfo对象", description="研学课程表")
public class YxCourseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "所属课程ID")
    private String baseId;

    @ApiModelProperty(value = "课程时长")
    private String courseDuration;

    @ApiModelProperty(value = "适合年级")
    private String courseGrade;

    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @ApiModelProperty(value = "可参加人数")
    private String courseNum;

    @ApiModelProperty(value = "课程类型")
    private String courseType;

    @ApiModelProperty(value = "封面照片url地址")
    private String coverPhotoUrl;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人user_id")
    private Integer creator;

    @ApiModelProperty(value = "详情")
    private String details;

    @ApiModelProperty(value = "状态; 0无效,1有效")
    private Integer status;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改人")
    private Integer updator;
}
