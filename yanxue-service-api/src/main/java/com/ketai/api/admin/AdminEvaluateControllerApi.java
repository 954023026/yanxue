package com.ketai.api.admin;

import com.ketai.common.response.Result;
import com.ketai.model.domain.families.request.EvaluateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 描述:
 * 研学评分相关操作
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2020-01-09 14:25
 */
@Api(value = "研学评价", description = "研学评分相关操作")
public interface AdminEvaluateControllerApi {

    @ApiOperation("根据基地名称分页查询研学基地评分信息服务")
    public Result qryBaseEvaluatePage(@ApiParam(name = "activityRequest", value = "查询对象", required = true) EvaluateRequest evaluateRequest);

    @ApiOperation(value = "查询各星级的数量")
    Result qryBaseEvaluateGroupCnt();

    @ApiOperation(value = "分页查询研学评分")
    Result qryEvaluateInfoPage(@ApiParam(name = "activityRequest", value = "查询对象",required = true) EvaluateRequest evaluateRequest);

    @ApiOperation(value = "隐藏显示评论信息")
    Result changeEvaluateState(  @ApiParam(name = "activityRequest", value = "隐藏显示评论接收类",required = true) EvaluateRequest evaluateRequest);
}
