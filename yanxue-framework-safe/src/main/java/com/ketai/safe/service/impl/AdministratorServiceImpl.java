package com.ketai.safe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.ExceptionThrowOut;
import com.ketai.safe.mapper.AdministratorMapper;
import com.ketai.safe.pojo.Administrator;
import com.ketai.safe.service.AdministratorService;
import org.springframework.stereotype.Service;

/**
 * @description: AdministratorServiceImpl
 * @author: xuhao
 * @time: 2019/12/6 10:34
 */
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, Administrator> implements AdministratorService {
    @Override
    public Administrator findUserVoByUsernameAndPassword(Administrator administrator) {
        QueryWrapper<Administrator> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_name", administrator.getAccountName()).eq("password", administrator.getPassword());
        Administrator administrator1 = baseMapper.selectOne(queryWrapper);
        if (administrator1 == null) {
            ExceptionThrowOut.cast(ResultCodeEnum.FETCH_USERINFO_ERROR);
        }
        return administrator1;
    }
}
