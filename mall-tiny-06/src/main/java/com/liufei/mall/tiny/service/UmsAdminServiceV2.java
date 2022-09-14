package com.liufei.mall.tiny.service;

import com.liufei.mall.seed.model.UmsAdminDOV1;
import com.liufei.mall.seed.model.UmsPermissionDOV1;

import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description  后台管理员Service
 * @date 2022/9/10
 */
public interface UmsAdminServiceV2 {

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdminDOV1 getAdminByUsername(String username);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermissionDOV1> getPermissionList(Long adminId);
}
