package com.ketai.activity.controller.orgin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.YxBaseInfoService;
import com.ketai.api.orgin.YxBaseInfoControllerApi;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxBaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 研学基地信息
 */
@RestController()
@RequestMapping("pc/base/baseManage")
public class YxBaseInfoController implements YxBaseInfoControllerApi {

    @Autowired
    private YxBaseInfoService yxBaseInfoService;

    //根据基地名称分页查询，
    @PostMapping("/qryBaseInfoPage")
    @Override
    public Result PageQuery(String baseName,Integer id,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            @RequestParam(defaultValue = "0") Integer nowPage) {
        Page<YxBaseInfo> pageParam = new Page<>(nowPage, pageSize);
        yxBaseInfoService.pageQuery(pageParam,baseName,id);
        List<YxBaseInfo> records = pageParam.getRecords();
        if(!StringUtils.isEmpty(id)){
            return Result.ok(records.get(0));
        }
        return Result.ok(
                new ResultListPage(
                        records,pageParam.getPages(),pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));
    }
}
