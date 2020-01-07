package com.ketai.activity.families.response;

import com.ketai.activity.families.vo.ActivityCount;
import com.ketai.common.model.response.ResponseResult;
import com.ketai.common.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mrt on 2018/3/31.
 */
@Data
@NoArgsConstructor
public class CmsPageResult extends ResponseResult {
    ActivityCount activityCount;
    public CmsPageResult(ResultCode resultCode, ActivityCount activityCount) {
        super(resultCode);
        this.activityCount = activityCount;
    }
}
