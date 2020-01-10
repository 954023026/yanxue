package com.ketai.activity.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.activity.mapper.YxUndertakeOrgMapper;
import com.ketai.activity.service.YxUndertakeOrgService;
import com.ketai.common.response.Result;
import com.ketai.common.response.ResultListPage;
import com.ketai.model.domain.YxUndertakeOrg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 研学承办机构表 服务实现类
 * </p>
 *
 * @author 研学旅行网项目组
 * @since 2020-01-06
 */
@Service
public class YxUndertakeOrgServiceImpl extends ServiceImpl<YxUndertakeOrgMapper, YxUndertakeOrg> implements YxUndertakeOrgService {

    /**
     * 根据研学承办机构名称分页查询
     * @param pageParam
     * @param orgname
     * @auther 李
     */
    @Override
    public void pageQuery(Page<YxUndertakeOrg> pageParam, String orgname) {
        QueryWrapper<YxUndertakeOrg> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(orgname)){
            queryWrapper.like("orgname",orgname);
        }
        baseMapper.selectPage(pageParam,queryWrapper);
    }

    /**
     * 研学基地新增
     * @param yxUndertakeOrg
     * @return
     * @auther 李
     */
    @Override
    public Result saveYxUndertakeOrg(YxUndertakeOrg yxUndertakeOrg) {
        int insert = baseMapper.insert(yxUndertakeOrg);
        if (insert>0){
            return Result.ok(new ResultListPage(yxUndertakeOrg));
        }
        return Result.error();
    }

    /**
     * 根据id研学基地修改
     * @param yxUndertakeOrg
     * @return
     * @auther 李
     */
    @Override
    public Result saveAndFlush(YxUndertakeOrg yxUndertakeOrg) {
        int insert = baseMapper.updateById(yxUndertakeOrg);
        if (insert>0){
            return Result.ok(new ResultListPage(yxUndertakeOrg));
        }
        return Result.error();
    }
}
