package com.ketai.activity.controller.orgin;

import com.ketai.activity.service.impl.YxBaseOrganServiceImpl;
import com.ketai.activity.service.impl.YxBaseSchoolServiceImpl;
import com.ketai.api.orgin.YxBaseOrganControllerApi;
import com.ketai.common.response.Result;
import com.ketai.model.domain.YxBaseOrgan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("pc/")
public class YxBaseOrganController implements YxBaseOrganControllerApi {

    @Autowired
    private YxBaseOrganServiceImpl yxBaseOrganService;

    @Autowired
    private YxBaseSchoolServiceImpl yxBaseSchoolService;
    /**
     * 地址三级联查
     * @param parentCode
     * @return
     * @auther 李
     */
    @PostMapping("orgChildList")
    @Override
    public Result selByparentCode(Long parentCode) {
        //二级查询中根据parentCode查询，若查询不到数据则是三级查询
        List<YxBaseOrgan> yxBaseOrgans = yxBaseOrganService.selByParentCode(parentCode);
        if(yxBaseOrgans.size() == 0){//二级查询时查不到数据时，进行三级查询
            //三级查询时根据parentId进行查询
           return Result.ok(yxBaseSchoolService.selByParentId(parentCode));
        }
        return Result.ok(yxBaseOrgans);
    }
}
