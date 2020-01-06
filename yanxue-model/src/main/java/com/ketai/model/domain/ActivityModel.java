package com.ketai.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ActivityModel implements Serializable {
    /**
     * 研学活动主键
     */
    @ApiModelProperty(value="研学活动主键")
    private Integer id;

    /**
     * 研学主题名称
     */
    @ApiModelProperty(value="研学主题名称")
    private String activityName;

    /**
     * 学校id
     */
    @ApiModelProperty(value="学校id")
    private Integer schId;

    /**
     * 学校名称
     */
    @ApiModelProperty(value="学校名称")
    private String schName;

    /**
     * 学习阶段1小学2初中4高中
     */
    @ApiModelProperty(value="学习阶段1小学2初中4高中")
    private Integer studyStep;

    /**
     * 状态 0无效 1有效
     */
    @ApiModelProperty(value="状态 0无效 1有效",hidden = true)
    private Integer status;

    /**
     * 创建人id
     */
    @ApiModelProperty(value="创建人id",hidden = true)
    private Integer creator;
    /**
     * 创建人名称
     */
    @ApiModelProperty(value="创建人名称")
    private String creatName;

    /**
     * 更新人id
     */
    @ApiModelProperty(value="更新人id",hidden = true)
    private Integer updator;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="更新时间",hidden = true)
    private Date updateTime;

    /**
     * 审核状态1未提交2：待学生科审批3：学生科审核拒绝4：待局领导审批5：局领导审核拒绝6：审批已通过
     */
    @ApiModelProperty(value="审核状态1未提交2：待学生科审批3：学生科审核拒绝4：待局领导审批5：局领导审核拒绝6：审批已通过")
    private Integer auditStatus;

    /**
     * 未通过理由
     */
    @ApiModelProperty(value="未通过理由")
    private String reasonsNotPassed;

    /**
     * 基地id
     */
    @ApiModelProperty(value="基地id")
    private Integer baseId;

    /**
     * 基地名
     */
    @ApiModelProperty(value="基地名")
    private String baseName;

    /**
     * 省内外，1省内2省外
     */
    @ApiModelProperty(value="省内外，1省内2省外")
    private Byte province;

    /**
     * 1:已有基地2：非已有基地
     */
    @ApiModelProperty(value="1:已有基地2：非已有基地")
    private Integer baseStatus;

    /**
     * 研学承办机构id
     */
    @ApiModelProperty(value="研学承办机构id")
    private Integer organizationId;
    /**
     * 研学承办机构名称
     */
    @ApiModelProperty(value="研学承办机构名称")
    private String organizationName;

    /**
     * 活动开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="活动开始时间")
    private Date serStartTime;

    /**
     * 活动结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="活动结束时间")
    private Date serEndTime;

    /**
     * 负责人姓名
     */
    @ApiModelProperty(value="负责人姓名")
    private String principalName;

    /**
     * 收费标准
     */
    @ApiModelProperty(value="收费标准")
    private BigDecimal price;

    /**
     * 合同价
     */
    @ApiModelProperty(value="合同价")
    private BigDecimal contractPrice;

    /**
     * 研学课程目标和涉及的学科
     */
    @ApiModelProperty(value="研学课程目标和涉及的学科")
    private String studiesGoal;

    /**
     * 带队老师人数
     */
    @ApiModelProperty(value="带队老师人数")
    private Integer ledTeacherNumber;

    /**
     * 随队老师人数
     */
    @ApiModelProperty(value="随队老师人数")
    private Integer teamTeacherNumber;

    /**
     * 学生人数
     */
    @ApiModelProperty(value="学生人数")
    private Integer studentNumber;

    /**
     * 参与年级，多个用，分隔如一年级和二年级   一年级，二年级
     */
    @ApiModelProperty(value="参与年级，多个用，分隔如一年级和二年级   一年级，二年级")
    private String participationSchYear;

    /**
     * 实践表文件 url
     */
    @ApiModelProperty(value="实践表文件 url")
    private String practiceReportChart;

    /**
     * 实践方案文件 url
     */
    @ApiModelProperty(value="实践方案文件 url")
    private String practiceScheme;

    /**
     * 安全承诺书文件 url
     */
    @ApiModelProperty(value="安全承诺书文件 url")
    private String letterOfCommitment;

    /**
     * 承办机构合同文件 url
     */
    @ApiModelProperty(value="承办机构合同文件 url")
    private String organizationContract;

    /**
     * 贫困生表文件 url
     */
    @ApiModelProperty(value="贫困生表文件 url")
    private String poorStudentChart;

    /**
     * 区县id
     */
    @ApiModelProperty(value="区县id")
    private Integer organId;

    /**
     * 区县名
     */
    @ApiModelProperty(value="区县名")
    private String organName;

    /**
     * 封面图片地址
     */
    @ApiModelProperty(value="封面图片地址")
    private String imageUrl;

    /**
     * 报名开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="报名开始时间")
    private Date signStartTime;

    /**
     * 报名结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="报名结束时间")
    private Date signEndTime;
    /**
     * 活动学年
     */
    @ApiModelProperty(value="活动学年",hidden = true)
    private String schyear;
    /**
     * 学习阶段别名
     */
    @ApiModelProperty(value="学习阶段别名")
    private String studyStepName;


    private static final long serialVersionUID = 1L;


}