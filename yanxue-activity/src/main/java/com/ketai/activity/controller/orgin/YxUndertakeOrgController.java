package com.ketai.activity.controller.orgin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.YxUndertakeOrgService;
import com.ketai.api.orgin.YxUndertakeOrgApi;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxUndertakeOrg;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.swing.StringUIClientPropertyKey;

import java.util.List;

/**
 * 研学承办机构信息
 */
@RestController()
@RequestMapping("pc/base/undertakeOrg")
public class YxUndertakeOrgController implements YxUndertakeOrgApi {

    @Autowired
    private YxUndertakeOrgService yxUndertakeOrgService;

    /**
     * 根据研学基地名称分页查询
     * @param baseName
     * @param pageSize
     * @param nowPage
     * @return
     * @auther 李
     */
    @PostMapping("qryUndertakeOrgInfoPage")
    @Override
    public Result PageQuery(String baseName,Integer id,
                            @RequestParam(defaultValue = "5") Integer pageSize,
                            @RequestParam(defaultValue = "0") Integer nowPage) {
        Page<YxUndertakeOrg> pageParam = new Page<>(nowPage, pageSize);
        yxUndertakeOrgService.pageQuery(pageParam,id,baseName);
        List<YxUndertakeOrg> records = pageParam.getRecords();
        if(!StringUtils.isEmpty(id)){
            return Result.ok(records.get(0));
        }
        return Result.ok(
                new ResultListPage(
                        records,pageParam.getPages(),pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));
    }

}
