package com.ketai.activity.controller.admin;

import com.ketai.activity.service.YxUndertakeOrgService;
import com.ketai.api.admin.YxUndertakeOrgControllerApi;
import com.ketai.common.response.Result;
import com.ketai.model.domain.YxUndertakeOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 研学承办机构
 */
@RestController()
@RequestMapping("admin/base/undertakeOrg")
public class AdminYxUndertakeOrgController implements YxUndertakeOrgControllerApi {

    @Autowired
    private YxUndertakeOrgService yxUndertakeOrgService;

    @PostMapping("saveUndertakeOrgInfo")
    @Override
    public Result saveBaseInfo(@RequestBody YxUndertakeOrg yxUndertakeOrg) {
        if(!StringUtils.isEmpty(yxUndertakeOrg.getId())){
            return yxUndertakeOrgService.saveAndFlush(yxUndertakeOrg);
        }
        yxUndertakeOrg.setId(UUID.randomUUID().hashCode());
        return yxUndertakeOrgService.saveYxUndertakeOrg(yxUndertakeOrg);
    }
}
