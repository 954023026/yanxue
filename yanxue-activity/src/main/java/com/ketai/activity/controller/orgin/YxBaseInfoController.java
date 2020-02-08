package com.ketai.activity.controller.orgin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.YxBaseInfoService;
import com.ketai.api.orgin.YxBaseInfoControllerApi;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.common.util.getDateFormat;
import com.ketai.model.domain.YxBaseInfo;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
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
                            @RequestParam(defaultValue = "0") Integer nowPage) throws ParseException {
        Page<YxBaseInfo> pageParam = new Page<>(nowPage, pageSize);
        yxBaseInfoService.pageQuery(pageParam,baseName,id);
        List<YxBaseInfo> records = pageParam.getRecords();
        for (YxBaseInfo yxBaseInfo : records) {
            yxBaseInfo.setCreateTime(yxBaseInfo.getCreateTime().substring(0,10));
        }
        if(!StringUtils.isEmpty(id)){
            getDateFormat.dealDateFormat(records.get(0).getCreateTime());
            return Result.ok(records.get(0));
        }

        return Result.ok(
                new ResultListPage(
                        records,pageParam.getPages(),pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));
    }
}
