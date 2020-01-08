package com.ketai.activity.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.front.mapper.FrontActivityMapper;
import com.ketai.activity.front.service.FrontActivityService;
import com.ketai.activity.front.service.FrontYxActivityRecordService;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultMap;
import com.ketai.model.domain.YxActivity;
import com.ketai.common.query.pcQuery.PcActivityQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
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
    public void getActivityDetailsByid(Integer id) {

    }


    //数据总览 TODO controlle 暂时未写
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
