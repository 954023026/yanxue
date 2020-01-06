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
 * 活动带队老师表
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yx_activity_ledteacher")
@ApiModel(value="YxActivityLedteacher对象", description="活动带队老师表")
public class YxActivityLedteacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "研学带队老师主键")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "活动id")
    private Integer activityId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人user_id")
    private Integer creator;

    @ApiModelProperty(value = "老师姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "学校ID")
    private Integer schId;

    @ApiModelProperty(value = "学校名")
    private String schName;

    @ApiModelProperty(value = "状态; 0无效, 1有效")
    private Integer status;

    @ApiModelProperty(value = "老师类型，1：带队老师2：随队老师")
    private String teacherType;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改人user_id")
    private Integer updator;


}
