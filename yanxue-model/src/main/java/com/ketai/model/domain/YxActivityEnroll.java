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
 * 活动报名表
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yx_activity_enroll")
@ApiModel(value="YxActivityEnroll对象", description="活动报名表")
public class YxActivityEnroll implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "研学报名主键")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "活动id")
    private Integer activityId;

    @ApiModelProperty(value = "参赛者 班级ID")
    private Integer classId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人user_id")
    private Integer creator;

    @ApiModelProperty(value = "帮报名人身份id; student_id, parent_id, teacher_id")
    private Integer crtPeopleId;

    @ApiModelProperty(value = "帮报名人名称")
    private String crtPeopleName;

    @ApiModelProperty(value = "帮报名人身份类型: student, parent, teache（一般为父母）")
    private String crtPeopleType;

    @ApiModelProperty(value = "报名所属人姓名(一般为学生）")
    private String name;

    @ApiModelProperty(value = "报名所属人对应id")
    private Integer peopleId;

    @ApiModelProperty(value = "报名所属人身份类型, 学生为Student, 老师为Teacher")
    private String peopleType;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "学校ID")
    private Integer schId;

    @ApiModelProperty(value = "学校名")
    private String schName;

    @ApiModelProperty(value = "报名状态; 0失败, 1成功")
    private Integer status;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改人user_id")
    private Integer updator;


}
