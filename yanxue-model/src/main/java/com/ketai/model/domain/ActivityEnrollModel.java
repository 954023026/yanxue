package com.ketai.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActivityEnrollModel implements Serializable {
    /**
     * 研学报名主键
     */
    @ApiModelProperty(value="研学报名主键")
    private Integer id;

    /**
     * 活动id
     */
    @ApiModelProperty(value="活动id")
    private Integer activityId;

    /**
     * 学校ID
     */
    @ApiModelProperty(value="学校ID")
    private Integer schId;

    /**
     * 学校名
     */
    @ApiModelProperty(value="学校名")
    private String schName;

    /**
     * 报名所属人姓名(一般为学生）
     */
    @ApiModelProperty(value="报名所属人姓名(一般为学生）")
    private String name;

    /**
     * 报名所属人对应id
     */
    @ApiModelProperty(value="报名所属人对应id")
    private Integer peopleId;

    /**
     * 报名所属人身份类型, 学生为Student, 老师为Teacher
     */
    @ApiModelProperty(value="报名所属人身份类型, 学生为Student, 老师为Teacher")
    private String peopleType;

    /**
     * 参赛者 班级ID
     */
    @ApiModelProperty(value="参赛者 班级ID")
    private Integer classId;

    /**
     * 帮报名人身份类型: student, parent, teache（一般为父母）
     */
    @ApiModelProperty(value="帮报名人身份类型: student, parent, teache（一般为父母）")
    private String crtPeopleType;

    /**
     * 帮报名人身份id; student_id, parent_id, teacher_id
     */
    @ApiModelProperty(value="帮报名人身份id; student_id, parent_id, teacher_id")
    private Integer crtPeopleId;

    /**
     * 帮报名人名称
     */
    @ApiModelProperty(value="帮报名人名称")
    private String crtPeopleName;

    /**
     * 报名状态; 0失败, 1成功
     */
    @ApiModelProperty(value="报名状态; 0失败, 1成功",hidden = true)
    private Byte status;

    /**
     * 创建人user_id
     */
    @ApiModelProperty(value="创建人user_id")
    private Integer creator;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间",hidden = true)
    private Date createTime;

    /**
     * 修改人user_id
     */
    @ApiModelProperty(value="修改人user_id",hidden = true)
    private Integer updator;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间",hidden = true)
    private Date updateTime;
    /**
     * 手机号码
     */
    @ApiModelProperty(value="手机号码")
    private String phoneNumber;

    private static final long serialVersionUID = 1L;

}