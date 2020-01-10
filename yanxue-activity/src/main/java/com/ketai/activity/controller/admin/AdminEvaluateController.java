package com.ketai.activity.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.YxEvaluateInfoService;
import com.ketai.api.admin.AdminEvaluateControllerApi;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.families.request.EvaluateRequest;
import com.ketai.model.domain.families.response.ActivityVo;
import com.ketai.model.domain.families.response.EvaluateInfoVo;
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
     */
    @PostMapping("qryBaseEvaluatePage")
    @Override
    public Result qryBaseEvaluatePage(EvaluateRequest evaluateRequest) {
        Page<ActivityVo> pageParam = new Page<>(evaluateRequest.getNowPage(), evaluateRequest.getPageSize());
        List<EvaluateInfoVo> evaluatePage= evaluateInfoService.qryBaseEvaluatePage(pageParam, evaluateRequest);
        return Result.ok(new ResultListPage(evaluatePage, pageParam.getPages(), pageParam.getTotal(), evaluateRequest.getNowPage(), evaluateRequest.getPageSize()));
    }
}
