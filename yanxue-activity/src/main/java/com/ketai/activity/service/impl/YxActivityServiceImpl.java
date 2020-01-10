package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxActivityMapper;
import com.ketai.activity.mapper.YxActivityRecordMapper;
import com.ketai.activity.service.YxActivityService;
import com.ketai.common.constant.CommonAuditStatus;
import com.ketai.common.query.YxActivityQuery;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.YxActivityRecord;
import com.ketai.model.domain.families.ext.ActivityCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
@Transactional
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
        queryWrapper.orderByDesc("id");
        if (queryWrapper == null) {
            baseMapper.selectPage(pageParm, queryWrapper);
            return;
        }
        //获取研学活动主键id
        Integer id=yxActivityQuery.getId();
        //获取研学基地名称查询条件024.
        String baseName = yxActivityQuery.getBaseName();
        //获取承办基地名称查询条件
        String organizationName = yxActivityQuery.getOrganizationName();
        //获取审批状态查询条件
        Integer auditStatus = yxActivityQuery.getAuditStatus();
        //获取研学主题名称模糊查询条件
        String activityName = yxActivityQuery.getActivityName();

        //条件查询
        if (!StringUtils.isEmpty(id)){
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
        if (StringUtils.isEmpty(schyear)) {
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

    /**
     * 根据id查询研学活动信息
     * @param id
     * @return
     */
    @Override
    public YxActivity activityInfo(Integer id) {
        System.out.println("获取的id："+id);
        return  baseMapper.selectById(id);
    }


    /**
     * 根据研学活动id更改审批状态
     * @param id
     */
    @Override
    public void submitActivity(Integer id) {
        System.out.println("测试获取的研学活动id："+id);
        YxActivity yxActivity =new YxActivity();
        yxActivity.setId(id);
        //更改状态为2：待学生科审批
        yxActivity.setAuditStatus(2);
        System.out.println("测试："+yxActivity);
        baseMapper.updateById(yxActivity);
    }
}
