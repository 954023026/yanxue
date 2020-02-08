package com.ketai.safe.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @description: Administrator
 * @author: xuhao
 * @time: 2020/2/5 15:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yx_administrator")
@ApiModel(value="yx_administrator管理員", description="管理员表")
public class Administrator {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.INPUT)
    private Integer userId;

    @ApiModelProperty(value = "创建时间",example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "用户角色")
    private String peopleType;

    @ApiModelProperty(value = "角色id")
    private String peopleId;

    @ApiModelProperty(value = "用户角色名称")
    private String peopleName;

    @ApiModelProperty(value = "账户")
    private String accountName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "更新时间",example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
