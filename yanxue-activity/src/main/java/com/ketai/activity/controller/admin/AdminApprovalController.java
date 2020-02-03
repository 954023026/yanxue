package com.ketai.activity.controller.admin;


import com.ketai.activity.service.impl.YxActivityServiceImpl;
import com.ketai.common.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/approval")
public class AdminApprovalController {

    @Autowired
    private YxActivityServiceImpl yxActivityService;

    /**
     * 局领导进行研学活动审核
     * 状态改（audit_status）为 5 或 6
     * 5：局领导审核拒绝，reasons_not_passed 未通过理由
     * 6：审批已通过，status 改为 1 有效
     * @return
     * @auther 李
     */
    @PostMapping("approval")
    public Result approval(Integer activityId, String reasonsNotPassed, Integer approverStatus){
        //拒绝理由不为空时，表示拒绝
        int approval = yxActivityService.approval(activityId, reasonsNotPassed, approverStatus);
        if(approval>0){
            return Result.ok("审核成功");
        }
        return Result.ok("审核失败");
    }
}
