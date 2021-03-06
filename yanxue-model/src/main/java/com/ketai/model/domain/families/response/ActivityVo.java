package com.ketai.model.domain.families.response;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 活动表
 * </p>
 */
@Data
@ApiModel(value="ActivityVo对象", description="活动VO表")
public class ActivityVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "研学活动主键")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "研学主题名称")
    private String activityName;

    @ApiModelProperty(value = "审核状态1未提交2：待学生科审批3：学生科审核拒绝4：待局领导审批5：局领导审核拒绝6：审批已通过")
    private Integer auditStatus;

    @ApiModelProperty(value = "基地id")
    private Integer baseId;

    @ApiModelProperty(value = "基地名")
    private String baseName;

    @ApiModelProperty(value = "1:已有基地2：非已有基地")
    private Integer baseStatus;

    @ApiModelProperty(value = "合同价")
    private BigDecimal contractPrice;

    @ApiModelProperty(value = "创建人名称")
    private String creatName;

    @ApiModelProperty(value = "创建时间",example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT)
    private String createTime;

    @ApiModelProperty(value = "创建人id")
    private Integer creator;

    @ApiModelProperty(value = "封面图片地址")
    private String imageUrl;

    @ApiModelProperty(value = "带队老师人数")
    private Integer ledTeacherNumber;

    @ApiModelProperty(value = "安全承诺书文件 url")
    private String letterOfCommitment;

    @ApiModelProperty(value = "区县id")
    private Integer organId;

    @ApiModelProperty(value = "区县名")
    private String organName;

    @ApiModelProperty(value = "承办机构合同文件 url")
    private String organizationContract;

    @ApiModelProperty(value = "研学承办机构id")
    private Integer organizationId;

    @ApiModelProperty(value = "研学承办机构名称")
    private String organizationName;

    @ApiModelProperty(value = "参与年级，多个用，分隔如一年级和二年级   一年级，二年级")
    private String participationSchYear;

    @ApiModelProperty(value = "贫困生表文件 url")
    private String poorStudentChart;

    @ApiModelProperty(value = "实践表文件 url")
    private String practiceReportChart;

    @ApiModelProperty(value = "实践方案文件 url")
    private String practiceScheme;

    @ApiModelProperty(value = "收费标准")
    private BigDecimal price;

    @ApiModelProperty(value = "负责人姓名")
    private String principalName;

    @ApiModelProperty(value = "省内外，1省内2省外")
    private Integer province;

    @ApiModelProperty(value = "未通过理由")
    private String reasonsNotPassed;

    @ApiModelProperty(value = "学校id")
    private Integer schId;

    @ApiModelProperty(value = "学校名称")
    private String schName;

    @ApiModelProperty(value = "活动学年")
    private String schyear;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "活动结束时间")
    private String serEndTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "活动开始时间")
    private String serStartTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "报名结束时间")
    private String signEndTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "报名开始时间")
    private String signStartTime;

    @ApiModelProperty(value = "状态 0无效 1有效")
    private Integer status;

    @ApiModelProperty(value = "学生人数")
    private Integer studentNumber;

    @ApiModelProperty(value = "研学课程目标和涉及的学科")
    private String studiesGoal;

    @ApiModelProperty(value = "学习阶段1小学2初中4高中")
    private Integer studyStep;

    @ApiModelProperty(value = "学习阶段别名")
    private String studyStepName;

    @ApiModelProperty(value = "随队老师人数")
    private Integer teamTeacherNumber;

    @ApiModelProperty(value = "更新时间",example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "更新人id")
    private Integer updator;

    @ApiModelProperty(value = "随队老师人数")
    private Integer realityTeamTchNumber;

    @ApiModelProperty(value = "天数")
    private Integer days;

    @ApiModelProperty(value = "带队老师人数2")
    private Integer realityLedTchNumber;

    @ApiModelProperty(value = "随队老师人数2")
    private Integer realityTchNumber;

    @ApiModelProperty(value = "学生数量2")
    private Integer realityStuNumber;

    @ApiModelProperty(value = "风采数量")
    private Integer recordNumber;

    @ApiModelProperty(value = "状态")
    private String auditName;
}
