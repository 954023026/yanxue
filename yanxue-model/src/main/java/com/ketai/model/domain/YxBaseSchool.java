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
 * 学校表
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="YxBaseSchool对象", description="学校表")
public class YxBaseSchool implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "学校代码（外部代码）全国学籍系统中的代码")
    private String code;

    @ApiModelProperty(value = "学校名称")
    private String name;

    @ApiModelProperty(value = "学校简称")
    private String shortName;

    @ApiModelProperty(value = "上级机构id 如果是普通学校上级机构为教育局，如果非普通学校上级机构表示学校id")
    private Integer parentId;

    @ApiModelProperty(value = "所属区域编码")
    private String regionCode;

    @ApiModelProperty(value = "学习阶段 1-小学 2-初中 4-高中")
    private Integer studyStep;

    @ApiModelProperty(value = "使用状态 1-有效 0-无效")
    private Boolean status;

    @ApiModelProperty(value = "类型 1-普通学校 2-教育集团 3-教学点")
    private Boolean type;

    private Integer creator;

    private Date createdTime;

    private Integer operator;

    private Date updatedTime;

    @ApiModelProperty(value = "系统账号")
    private String sysAccount;


}
