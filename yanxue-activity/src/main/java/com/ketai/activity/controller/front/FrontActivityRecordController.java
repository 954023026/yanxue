package com.ketai.activity.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.FrontActivityService;
import com.ketai.activity.service.FrontYxActivityRecordService;
import com.ketai.api.front.FrontActivityControllerApi;
import com.ketai.api.front.FrontActivityRecordControllerApi;
import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.KetaiException;
import com.ketai.common.query.pcQuery.PcActivityQuery;
import com.ketai.common.query.pcQuery.PcActivityRecordQuery;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.common.response.ResultMap;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.YxActivityRecord;
import com.ketai.model.domain.families.ext.ActivityCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("pc/record")
public class FrontActivityRecordController implements FrontActivityRecordControllerApi {
    @Autowired
    private FrontYxActivityRecordService frontYxActivityRecordService;

    @PostMapping("selectRecordPage")
    @Override
    public Result selectRecordPage(PcActivityRecordQuery pcActivityRecordQuery) {
        if (pcActivityRecordQuery.getNowPage()<=0||pcActivityRecordQuery.getPageSize()<=0){
            //21003 参数错误
            throw new KetaiException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<YxActivityRecord> pageParam=new Page<>(pcActivityRecordQuery.getNowPage(),pcActivityRecordQuery.getPageSize());
        frontYxActivityRecordService.pageQuery(pageParam,pcActivityRecordQuery);
        return Result.ok(
                new ResultListPage(
                        pageParam.getRecords(),pageParam.getPages(),
                        pageParam.getTotal(),pageParam.getCurrent(),pageParam.getSize()));
    }


}
