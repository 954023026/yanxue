package com.ketai.activity.controller.admin;

import com.ketai.activity.service.YxBaseInfoService;
import com.ketai.api.admin.AdminYxBaseInfoControllerApi;
import com.ketai.common.response.Result;
import com.ketai.model.domain.YxBaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 研学基地
 */
@RestController
@RequestMapping("admin/base")
public class AdminYxBaseInfoController implements AdminYxBaseInfoControllerApi {

    @Autowired
    private YxBaseInfoService yxBaseInfoService;

    /**
     * 基地新增和修改接口，涉及到 地址三级联查，图片上传接口
     * 根据是否有id来判断 新增或修改
     * @param yxBaseInfo
     * @return
     * @auther 李
     */

    @PostMapping("/saveBaseInfo")
    @Override
    public Result saveBaseInfo(@RequestBody YxBaseInfo yxBaseInfo) {
        if(!StringUtils.isEmpty(yxBaseInfo.getId())){
            return yxBaseInfoService.saveAndflush(yxBaseInfo);
        }
        //数据库id未自增，需要自己赋值
        yxBaseInfo.setId(UUID.randomUUID().hashCode());
        return yxBaseInfoService.saveBaseInfo(yxBaseInfo);
    }
}
