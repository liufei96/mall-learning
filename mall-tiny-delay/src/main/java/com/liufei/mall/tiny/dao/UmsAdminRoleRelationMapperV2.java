package com.liufei.mall.tiny.dao;

import com.liufei.mall.seed.model.UmsPermissionDOV1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 后台用户与角色管理自定义mapper
 * @date 2022/9/10
 */
public interface UmsAdminRoleRelationMapperV2 {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermissionDOV1> getPermissionList(@Param("adminId") Long adminId);
}
