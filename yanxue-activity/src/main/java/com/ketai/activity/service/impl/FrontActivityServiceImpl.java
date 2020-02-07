package com.ketai.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.FrontActivityMapper;
import com.ketai.activity.service.FrontActivityService;
import com.ketai.activity.service.FrontYxActivityRecordService;
import com.ketai.activity.mapper.*;
import com.ketai.common.constant.CommonAuditStatus;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultMap;
import com.ketai.model.domain.*;
import com.ketai.common.query.pcQuery.PcActivityQuery;
import com.ketai.model.domain.families.ext.ActivityCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class FrontActivityServiceImpl extends ServiceImpl<FrontActivityMapper, YxActivity> implements FrontActivityService {

    //风采表
    @Autowired
    private FrontYxActivityRecordService recordService;
    //基地
    @Autowired
    private YxBaseInfoMapper yxBaseInfoMapper;
    //机构
    @Autowired
    private YxUndertakeOrgMapper yxUndertakeOrgMapper;
    //区县
    @Autowired
    private YxBaseOrganMapper yxBaseOrganMapper;

    @Autowired
    private YxEvaluateInfoMapper yxEvaluateInfoMapper;


    //分页查询
    @Override
    public void pageQuery(Page<YxActivity> pageParam, PcActivityQuery pcActivityQuery) {
        QueryWrapper<YxActivity> queryWrapper=new QueryWrapper<>();
        if (pcActivityQuery==null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }
        Integer baseId = pcActivityQuery.getBaseId();   //研学基地id
        Integer organId = pcActivityQuery.getOrganId(); //区域id
        Integer organizationId = pcActivityQuery.getOrganizationId(); //承办机构id
        String participationSchYear = pcActivityQuery.getParticipationSchYear();  //年级
        String activityName = pcActivityQuery.getActivityName();    //模糊查询值
        Integer studyStep = pcActivityQuery.getStudyStep(); //阶段筛选

        if (StringUtils.isEmpty(baseId)){
            queryWrapper.eq("base_id",baseId);
        }
        if (StringUtils.isEmpty(organId)){
            queryWrapper.eq("organ_id",organId);
        }
        if (StringUtils.isEmpty(organizationId)){
            queryWrapper.eq("organization_id",organizationId);
        }
        if (StringUtils.isEmpty(baseId)){
            queryWrapper.eq("participation_sch_year",participationSchYear);
        }
        if (StringUtils.isEmpty(studyStep)){
            queryWrapper.eq("study_step",studyStep);
        }
        if (StringUtils.isEmpty(activityName)){
            queryWrapper.like("activity_name",activityName);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }

    //根据研学id查询
    @Override
    public ResultMap getActivityDetailsByid(Integer id) {
        //研学实践信息
        QueryWrapper<YxActivity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        List<YxActivity> activityList = baseMapper.selectList(queryWrapper);
        //获取基地信息
        QueryWrapper<YxBaseInfo> queryWrapper1=new QueryWrapper<>();
        List<YxBaseInfo> baseInfoList = yxBaseInfoMapper.selectList(queryWrapper1);

        //获取评分信息
        QueryWrapper<YxEvaluateInfo> queryWrapper2=new QueryWrapper<>();
        List<YxEvaluateInfo> evaluateInfoList = yxEvaluateInfoMapper.selectList(queryWrapper2);

        return ResultMap.ok().data("activityModel",activityList)
                .data("baseInfoModelWithBLOBs",baseInfoList)
                .data("evaluateInfoModel",evaluateInfoList);

    }


    //获取所有筛选项
    @Override
    public Map<String,Object> getSelectItem() {
        //获取基地信息
        QueryWrapper<YxBaseInfo> queryWrapper1=new QueryWrapper<>();
        List<YxBaseInfo> baseInfoList = yxBaseInfoMapper.selectList(queryWrapper1);

        //获取机构信息
        QueryWrapper<YxUndertakeOrg> queryWrapper2=new QueryWrapper<>();
        List<YxUndertakeOrg> undertakeOrgList = yxUndertakeOrgMapper.selectList(queryWrapper2);

        //获取区（县）信息
        QueryWrapper<YxBaseOrgan> queryWrapper3=new QueryWrapper<>();
        List<YxBaseOrgan> baseOrganList = yxBaseOrganMapper.selectList(queryWrapper3);
        Map<String,Object> map=new HashMap<>();
        map.put("baseInfo",baseInfoList);
        map.put("undertakeOrgModels",undertakeOrgList);
        map.put("organs",baseOrganList);
        return map;

    }


    //获取所有学年
    @Override
    public Result getAllSchYear() {

        QueryWrapper<YxActivity> queryWrapper=new QueryWrapper<>();
        //queryWrapper.select("distinct schyear");//去重
        List<YxActivity> activityList = baseMapper.selectList(queryWrapper);
        int n=activityList.size();
        String [] schYearArr=new String[n]; //学年数组
        for (int i=0;i<activityList.size();i++){

            schYearArr[i]=activityList.get(i).getSchyear();
        }
        return Result.ok().data(schYearArr);
    }

    //获取统计总数
    @Override
    public ActivityCount getActivityStatisticsCount(String schyear) {
        ActivityCount activityCount=new ActivityCount();
        QueryWrapper<YxActivity> queryWrapper=new QueryWrapper<>();
        if (!StringUtils.isEmpty(schyear)){
            queryWrapper.eq("schyear",schyear);
        }
        //查询累计开展研基地场次
        activityCount.setAllBaseNumber(12);
        //查询累计开展研机构践场次
        activityCount.setAllUndertakeOrgNumber(12);
        //查询累计开展研学实践场次
        Integer actNumber = baseMapper.selectCount(queryWrapper.eq("audit_status", CommonAuditStatus.APPROVAL_PASSED_STATUS_6));
        activityCount.setAllActNumber(actNumber);
        return activityCount;
    }


    /**
     * 数据总览 TODO controlle 暂时未写
     * @auther 李
     */

    @Override
    public Result selDataOverview(String year) {
        QueryWrapper<YxActivity> q1 = new QueryWrapper<>();
        //1. 待审核,对于觉领导来讲，条件 audit_status = 4
        q1.eq("audit_status",4).like("create_time",year);
        Integer toAuditNumber = baseMapper.selectCount(q1);
        //2.累计开展研学实践场次,条件 audit_status = 6
        QueryWrapper<YxActivity> q2 = new QueryWrapper<>();
        //从前端传来时不需要根据年份来查
        if(!StringUtils.isEmpty(year)){
            q1.eq("audit_status",6);
        }
        q2.like("create_time",year);
        Integer practiceNumber = baseMapper.selectCount(q2);
        //3.累计开展研学学校,手写sql
        Integer schoolNumber = baseMapper.selCarryOutSchool(year);
        //4.师生参与研学实践人次,手写sql
        Integer teaAndStuNumber = baseMapper.selNumberOfTeaAndStu(year);
        //5.累计研学风采,来自风采表
        Integer recordNumber = recordService.selRecordNumber(year);
        //TODO 6.总共的 认证基地数

        //TODO 7.总共的 认证（承办机构）机构数

        ResultMap rm = new ResultMap();

        Map<String, Object> rr = new HashMap<>();
        rr.put("allRecordNumber",8);//首页展示风采条数
        rr.put("allSchNumber",schoolNumber); //总的学下或按年份查询的学校数量
        rr.put("allActNumber",practiceNumber); //累计开展研学实践场次
        rr.put("allStuNumber",0);   //TODO 总共学生认数
        rr.put("allTchNumber",0);    //TODO 总共老师认数
        rr.put("allPeopleNumber",teaAndStuNumber);  //总人数
        rr.put("allBaseNumber",0); //TODO 认证基地数
        rr.put("allUndertakeOrgNumber",0);  //TODO 认证（承办机构）机构数
        rr.put("authNumber",0);     //尚不清楚
        rr.put("audit2Number",0);   //尚不清楚
        rr.put("audit4Number",0);   //尚不清楚
        rm.setData(rr);
        return Result.ok(rm);
    }


}
