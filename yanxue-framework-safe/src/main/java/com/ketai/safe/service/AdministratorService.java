package com.ketai.safe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ketai.safe.pojo.Administrator;

/**
 * @description: AdministratorService
 * @author: xuhao
 * @time: 2019/12/6 10:32
 */
public interface AdministratorService extends IService<Administrator> {
    /**
     * 根据用户名，密码登录
     * @param administrator
     * @return
     */
    Administrator findUserVoByUsernameAndPassword(Administrator administrator);
}
