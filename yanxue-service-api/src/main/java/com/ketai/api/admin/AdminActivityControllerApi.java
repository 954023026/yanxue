package com.ketai.api.admin;

import com.ketai.common.query.YxActivityQuery;
import com.ketai.common.response.Result;
import com.ketai.model.domain.YxActivity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2020-01-06 19:51
 */
@Api(value = "研学活动操作", description = "研学活动管理中心")
public interface AdminActivityControllerApi {

    @ApiOperation("列表统计总数")
    public Result getActivityStatisticsCount(@ApiParam(name = "schyear", value = "年份", required = false)String schyear);


    @ApiOperation("活动统计")
    public Result activityStatistics();

    @ApiOperation("研学活动分页查询")
    public Result selectPage(
            @ApiParam(name = "nowPage", value = "当前页码", required = true) Integer nowPage,
            @ApiParam(name = "pageSize", value = "每页记录数", required = true)Integer pageSize,
            @ApiParam(name = "yxActivityQuery", value = "查询对象", required = false) YxActivityQuery yxActivityQuery
    );

    @ApiOperation("添加研学活动申报信息")
    public Result insert(
            @ApiParam(name = "yxActivityQuery",value = "研学活动拓展对象",required = true) YxActivityQuery yxActivityQuery
    );

    @ApiOperation("提交活动")
    public Result submitActivity(@RequestBody Integer id );

    @ApiOperation("根据id查询所有")
    Result activityInfo(Integer id);
}
