package com.ketai.activity.controller.school;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ketai.activity.service.YxActivityService;
import com.ketai.api.school.SchoolControllerApi;
import com.ketai.common.query.YxActivityQuery;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxActivity;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/admin/activity")
public class SchoolYxActivityController implements SchoolControllerApi {

}

