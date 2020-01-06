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
 * 活动照片表
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yx_activity_file")
@ApiModel(value="YxActivityFile对象", description="活动照片表")
public class YxActivityFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人user_id")
    private Integer creator;

    @ApiModelProperty(value = "相片地址")
    private String fileUrl;

    @ApiModelProperty(value = "图片尺寸 高度 像素")
    private Integer height;

    @ApiModelProperty(value = "文件大小 kb")
    private Integer size;

    @ApiModelProperty(value = "0无效1有效")
    private Integer status;

    @ApiModelProperty(value = "(-9999:表示活动默认图片地址)第三方id: activity_id, record_id")
    private Integer targetId;

    @ApiModelProperty(value = "activity 活动封面 poorStudentChart贫困生表organizationContract承办机构合同,letterOfCommitment安全承诺书,practiceScheme实践方案practiceReportChart实践表文件,record风采")
    private String targetType;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人user_id")
    private Integer updator;

    @ApiModelProperty(value = "图片尺寸 宽度 像素")
    private Integer width;


}
