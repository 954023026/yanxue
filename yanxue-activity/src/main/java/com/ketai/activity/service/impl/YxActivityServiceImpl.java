package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxActivityMapper;
import com.ketai.activity.mapper.YxActivityRecordMapper;
import com.ketai.activity.service.YxActivityService;
import com.ketai.common.constant.CommonAuditStatus;
import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.ExceptionThrowOut;
import com.ketai.common.model.response.CommonCode;
import com.ketai.common.query.YxActivityQuery;
import com.ketai.model.domain.YxActivity;
import com.ketai.model.domain.YxActivityRecord;
import com.ketai.model.domain.YxBaseSchool;
import com.ketai.model.domain.families.ext.ActivityCount;
import com.ketai.model.domain.families.request.ActivityRequest;
import com.ketai.model.domain.families.response.ActivityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Integer id = yxActivityQuery.getId();
        //获取研学基地名称查询条件024.
        String baseName = yxActivityQuery.getBaseName();
        //获取承办基地名称查询条件
        String organizationName = yxActivityQuery.getOrganizationName();
        //获取审批状态查询条件
        Integer auditStatus = yxActivityQuery.getAuditStatus();
        //获取研学主题名称模糊查询条件
        String activityName = yxActivityQuery.getActivityName();

        //条件查询
        if (!StringUtils.isEmpty(id)) {
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

    /**
     * 根据研学活动id更改审批状态
     * 局领导进行审批
     * @param activityId
     * @param reasonsNotPassed
     * @param approverStatus
     * @return
     */
    @Override
    public int approval(Integer activityId, String reasonsNotPassed, Integer approverStatus) {
        YxActivity yxActivity =new YxActivity();
        yxActivity.setId(activityId);
        if(approverStatus == 0){//拒绝
            yxActivity.setAuditStatus(5);
            yxActivity.setReasonsNotPassed(reasonsNotPassed);
            return baseMapper.updateById(yxActivity);
        }
        yxActivity.setAuditStatus(6);//通过
        yxActivity.setStatus(1);//有效
        return baseMapper.updateById(yxActivity);
    }

    @Override
    public List<YxActivity> selByStatus() {
        QueryWrapper<YxActivity>  qq = new QueryWrapper<>();
        qq.eq("audit_status",6).eq("status",1);
        return baseMapper.selectList(qq);
    }

    /**
     * 分页查询研学信息,周
     * @param pageParam
     * @param activityRequest
     * @return
     */
    @Override
    public List<ActivityVo> pageStatisticsQuery(Page<ActivityVo> pageParam, ActivityRequest activityRequest) {
        QueryWrapper<YxActivity> queryWrapper = new QueryWrapper<>();
        //queryWrapper.orderByDesc("create_time");
        //学习阶段
        Integer state = activityRequest.getState();
        //学校名称
        String schName = activityRequest.getSchName();

        //开始时间
        String serStartTime = activityRequest.getSerStartTime();
        //结束
        String serEndTime = activityRequest.getSerEndTime();
        //区县名称
        String organName = activityRequest.getOrganName();
        //类型为已通过
        //queryWrapper.eq("audit_status", 6);
        if (!StringUtils.isEmpty(state)) {
            queryWrapper.eq("study_step", state);
        }
        if (!StringUtils.isEmpty(schName)) {
            queryWrapper.like("sch_name", schName);
        }
        if (!StringUtils.isEmpty(serStartTime)) {
            queryWrapper.gt("sign_start_time", serStartTime);
        }
        if (!StringUtils.isEmpty(serEndTime)) {
            queryWrapper.lt("sign_start_time", serEndTime);
        }
        if (!StringUtils.isEmpty(organName)) {
            queryWrapper.eq("organ_name", organName);
        }
        List<ActivityVo> byPage = activityMapper.findByPage(pageParam, queryWrapper);
        //todo 抛出指定异常
        if (byPage == null){
            ExceptionThrowOut.cast(CommonCode.SERVER_ERROR);
        }
        byPage.forEach(activityVo -> {
            //带队老师人数
            activityVo.setRealityLedTchNumber(activityVo.getLedTeacherNumber());
            //随队老师人数
            activityVo.setRealityTeamTchNumber(activityVo.getTeamTeacherNumber());
            //老师数
            activityVo.setRealityTchNumber(activityVo.getLedTeacherNumber() + activityVo.getTeamTeacherNumber());
            //学生人数
            activityVo.setRealityStuNumber(activityVo.getStudentNumber());
            String[] auditNames = {"未提交", "待学生科审批", "学生科审核拒绝", "待局领导审批", "局领导审核拒绝", "审批已通过", "已归档", "已结束"};
            //获取状态id
            Integer auditStatus = activityVo.getAuditStatus();
            String auditName = auditNames[auditStatus - 1];
            //状态
            activityVo.setAuditName(auditName);
            //时间加减，获取天数
            Integer day = Math.toIntExact((activityVo.getSerEndTime().getTime() - activityVo.getSerStartTime().getTime()) / (24 * 60 * 60 * 1000));
            activityVo.setDays(day);
        });
        return byPage;
    }

    /**
     *  查询年份信息
     * @return
     * @author 周
     */
    @Override
    public List<String> getAllSchYear() {
        QueryWrapper<YxActivity> queryWrapper = new QueryWrapper();
        //根据年份分组查询
        queryWrapper.groupBy("schyear");
        //根据年份升序排序
        queryWrapper.orderByAsc("schyear");
        //查询年份列
        queryWrapper.select("schyear");
        List<YxActivity> activities = baseMapper.selectList(queryWrapper);
        //将返回的集合对象里面的年份单独保存到一个list集合，返回
        if (activities == null){
            ExceptionThrowOut.cast(CommonCode.SERVER_ERROR);
        }
        return activities.stream().map(YxActivity::getSchyear).collect(Collectors.toList());
    }

}
