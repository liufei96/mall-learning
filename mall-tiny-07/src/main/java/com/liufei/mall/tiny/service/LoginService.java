package com.liufei.mall.tiny.service;

import com.liufei.mall.seed.model.UmsAdminDOV1;

/**
 * @author liufei
 * @version 1.0.0
 * @description 登录接口
 * @date 2022/9/11
 */
public interface LoginService {

    /**
     * 注册功能
     */
    UmsAdminDOV1 register(UmsAdminDOV1 umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

}
