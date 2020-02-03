package com.ketai.activity.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.YxEvaluateInfoService;
import com.ketai.api.admin.AdminEvaluateControllerApi;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.families.request.EvaluateRequest;
import com.ketai.model.domain.families.response.ActivityVo;
import com.ketai.model.domain.families.response.EvaluateInfoVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:
 *  研学评分相关操作
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2020-01-09 14:25
 */
@RestController
@RequestMapping("/admin/base/evaluate/")
public class AdminEvaluateController implements AdminEvaluateControllerApi {
    @Autowired
    private YxEvaluateInfoService evaluateInfoService;

    /**
     * 分页查询研学评价
     * @param evaluateRequest
     * @return
     * @author 周
     */
    @PostMapping("qryBaseEvaluatePage")
    @Override
    public Result qryBaseEvaluatePage(EvaluateRequest evaluateRequest) {
        Page<ActivityVo> pageParam = new Page<>(evaluateRequest.getNowPage(), evaluateRequest.getPageSize());
        return Result.ok(new ResultListPage(evaluateInfoService.qryBaseEvaluatePage(pageParam, evaluateRequest),
                pageParam.getPages(), pageParam.getTotal(), evaluateRequest.getNowPage(), evaluateRequest.getPageSize()));
    }

    /**
     * 查询研学基地评分每组评分数量统计
     * @return
     * @author 周
     */
    @PostMapping("qryBaseEvaluateGroupCnt")
    @Override
    public Result qryBaseEvaluateGroupCnt(){
        return Result.ok(evaluateInfoService.queryBaseEvaluateGroupCnt());
    }


    /**
     * 分页查询研学详情评分
     * @param evaluateRequest
     * @return
     * @author 周
     */
    @PostMapping("qryEvaluateInfoPage")
    @Override
    public Result qryEvaluateInfoPage(EvaluateRequest evaluateRequest) {
        Page<ActivityVo> pageParam = new Page<>(evaluateRequest.getNowPage(), evaluateRequest.getPageSize());
        return Result.ok(new ResultListPage(evaluateInfoService.qryEvaluateInfoPage(pageParam, evaluateRequest),
                pageParam.getPages(), pageParam.getTotal(), evaluateRequest.getNowPage(), evaluateRequest.getPageSize()));
    }
}
