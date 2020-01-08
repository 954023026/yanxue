package com.ketai.activity.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.school.mapper.YxActivityMapper;
import com.ketai.activity.school.mapper.YxActivityRecordMapper;
import com.ketai.common.constant.CommonAuditStatus;
import com.ketai.common.query.YxActivityQuery;
import com.ketai.activity.school.service.YxActivityService;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.YxActivityRecord;
import com.ketai.model.domain.families.ext.ActivityCount;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class YxActivityServiceImpl extends ServiceImpl<YxActivityMapper, YxActivity> implements YxActivityService {

    @Autowired
    private YxActivityRecordMapper activityRecordMapper;

    @Autowired
    private YxActivityMapper activityMapper;

    /**
     * 研学活动分页查询
     *
     * @param pageParm
     * @param yxActivityQuery
     */
    @Override
    public void selectPage(Page<YxActivity> pageParm, YxActivityQuery yxActivityQuery) {
        QueryWrapper<YxActivity> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByAsc("sort");
        if (queryWrapper == null) {
            baseMapper.selectPage(pageParm, queryWrapper);
            return;
        }
        //获取研学活动主键id
        Integer id=yxActivityQuery.getId();
        //获取研学基地名称查询条件
        String baseName = yxActivityQuery.getBaseName();
        //获取承办基地名称查询条件
        String organizationName = yxActivityQuery.getOrganizationName();
        //获取审批状态查询条件
        String auditStatus = yxActivityQuery.getAuditStatus();
        //获取研学主题名称模糊查询条件
        String activityName = yxActivityQuery.getActivityName();

        //条件查询
        if (!StringUtils.isEmpty(id.toString())) {
            queryWrapper.eq("id", id);
        }
        if (!StringUtils.isEmpty(baseName)) {
            queryWrapper.like("base_name", baseName);
        }
        if (!StringUtils.isEmpty(organizationName)) {
            queryWrapper.eq("organization_name", organizationName);
        }
        if (!StringUtils.isEmpty(auditStatus)) {
            queryWrapper.eq("audit_status", auditStatus);
        }
        if (!StringUtils.isEmpty(activityName)) {
            queryWrapper.like("activity_name", activityName);
        }
        baseMapper.selectPage(pageParm, queryWrapper);
    }

    /**
     * 统计研学信息，周
     *
     * @param schyear
     * @return
     */
    @Override
    public ActivityCount findActivityNum(String schyear) {
        ActivityCount statisticsCount = new ActivityCount();
        QueryWrapper<YxActivity> queryWrapper = new QueryWrapper();
        QueryWrapper<YxActivity> queryWrapper2 = new QueryWrapper<>();
        QueryWrapper<YxActivityRecord> queryWrapper1 = new QueryWrapper<>();
        if (StringUtils.isNotBlank(schyear)) {
            queryWrapper2.eq("schyear", schyear);
            queryWrapper.eq("schyear", schyear);
            queryWrapper1.eq("schyear_term", schyear);
        }
        //查询待审核数量
        Integer authNumber = baseMapper.selectCount(queryWrapper.eq("audit_status", CommonAuditStatus.STAY_STUDENT_SECTION_APPROVAL_STATUS_2).or().eq("audit_status", CommonAuditStatus.STAY_BUREAU_LEADERSHIP_APPROVAL_STATUS_4));
        statisticsCount.setAuthNumber(authNumber);

        //查询累计开展研学实践场次
        Integer actNumber = baseMapper.selectCount(queryWrapper2.eq("audit_status", CommonAuditStatus.APPROVAL_PASSED_STATUS_6));
        statisticsCount.setAllActNumber(actNumber);

        //查询累计开展研学学校数量
        Integer schNumber = activityMapper.selectAllSchNumber(schyear);
        statisticsCount.setAllSchNumber(schNumber);
        //查询师生参与研学实践人次
        Integer peopleNumber = activityMapper.selectAllPeopleNumber(schyear);
        statisticsCount.setAllPeopleNumber(peopleNumber);

        //查询风采数量
        Integer recodeNumber = activityRecordMapper.selectCount(queryWrapper1.eq("TYPE", "record"));
        statisticsCount.setAllRecordNumber(recodeNumber);
        return statisticsCount;
    }


}
