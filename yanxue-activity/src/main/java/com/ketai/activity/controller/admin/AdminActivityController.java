package com.ketai.activity.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.YxActivityService;
import com.ketai.common.query.YxActivityQuery;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.families.ext.ActivityCount;
import com.ketai.api.admin.AdminActivityControllerApi;
import com.ketai.common.response.Result;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2020-01-06 19:51
 */
@RestController
@RequestMapping("/admin/activity/")
public class AdminActivityController implements AdminActivityControllerApi {

    @Autowired
    private YxActivityService activityService;


    @PostMapping("getActivityStatisticsCount")
    @Override
    public Result getActivityStatisticsCount(
            @RequestParam(value = "schyear",required = false) String schyear
    ){
        ActivityCount activityNum = activityService.findActivityNum(schyear);
        return Result.ok(activityNum);
    }

    @Override
    public Result activityStatistics() {


        return Result.ok();
    }


    /**
     * 研学活动分页查询
     */
    @PostMapping("selectPage")
    @Override
    public Result selectPage(
            @RequestParam("nowPage") Integer nowPage,
            @RequestParam("pageSize") Integer pageSize,
            YxActivityQuery yxActivityQuery
    ) {
        System.out.println("--开始研学活动分页查询--");
        Page<YxActivity> pageParam = new Page<>(nowPage, pageSize);
        activityService.selectPage(pageParam, yxActivityQuery);
        List<YxActivity> records = pageParam.getRecords();

        return Result.ok(
                new ResultListPage(
                        records, pageParam.getPages(), pageParam.getTotal(), pageParam.getCurrent(), pageParam.getSize()));

    }

    /**
     * 添加研学活动申报信息
     *
     * @param yxActivityQuery
     * @return
     */
    @PutMapping("insert")
    @Override
    public Result insert(@ApiParam YxActivityQuery yxActivityQuery) {
       try{
           System.out.println("开始新增申报信息");
           YxActivity yxActivity = new YxActivity();
           BeanUtils.copyProperties(yxActivityQuery,yxActivity);
           //创建研学活动保存申报信息，默认审批状态为：未提交
           //审核状态  1：未提交，2：待学生科审批，3：学生科审核拒绝，4：待局领导审批，5：局领导审核拒绝，6：审批已通过
           yxActivity.setAuditStatus(1);
           System.out.println("测试研学基地名称："+yxActivity.getActivityName());
           activityService.updateById(yxActivity);
           System.out.println("测试是否新增成功："+yxActivity);
           return Result.ok();
       }catch (Exception e){
           return Result.error().message("添加申报信息失败，请重新填写申报信息");
       }
    }

    /**
     * 研学申报活动信息提交
     * @param id
     * @return
     */
    @PutMapping("submitActivity")
    @Override
    public Result submitActivity(@RequestBody Integer id ){
       try{
           System.out.println("提交研学申报活动信息，等待学生科审批，未提交状态变为待学生科审批");
           activityService.submitActivity(id);
           return Result.ok();
       }catch (Exception e){
           return Result.error().message("未知错误");
       }
    }
}
