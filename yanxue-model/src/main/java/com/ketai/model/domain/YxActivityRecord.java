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
 * 研学(活动)风采表
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yx_activity_record")
@ApiModel(value="YxActivityRecord对象", description="研学(活动)风采表")
public class YxActivityRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "研学风采主键")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "活动ID")
    private Integer activityId;

    @ApiModelProperty(value = "评价内容")
    private String content;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人user_id")
    private Integer creator;

    @ApiModelProperty(value = "图片地址")
    private String imageUrl;

    @ApiModelProperty(value = "所属people id")
    private Integer ownerPeopleId;

    @ApiModelProperty(value = "所属peopletype")
    private String ownerPeopleType;

    @ApiModelProperty(value = "公开类型: 0仅自己可见， 1公开")
    private Integer publicStatus;

    @ApiModelProperty(value = "记录人peopleId")
    private Integer recordPeopleId;

    @ApiModelProperty(value = "身份名称")
    private String recordPeopleName;

    @ApiModelProperty(value = "记录人peopleType")
    private String recordPeopleType;

    @ApiModelProperty(value = "学生风采学年学期")
    private String schyearTerm;

    @ApiModelProperty(value = "状态: 0已删除, 1正常")
    private Integer status;

    @ApiModelProperty(value = "record活动风采 recordHome 首页8张风采 默认为record")
    private String type;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改人user_id")
    private Integer updator;


}
