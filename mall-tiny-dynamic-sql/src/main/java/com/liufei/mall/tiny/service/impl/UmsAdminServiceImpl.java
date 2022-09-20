package com.liufei.mall.tiny.service.impl;

import com.liufei.mall.tiny.model.AdminRoleDto;
import com.liufei.mall.tiny.model.RoleStatDto;
import com.liufei.mall.tiny.model.UmsAdmin;
import com.liufei.mall.tiny.service.UmsAdminService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/20
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Override
    public UmsAdmin create(UmsAdmin umsAdmin) {
        return null;
    }

    @Override
    public UmsAdmin update(UmsAdmin umsAdmin) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public UmsAdmin select(Long id) {
        return null;
    }

    @Override
    public List<UmsAdmin> listAll(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<UmsAdmin> list(Integer pageNum, Integer pageSize, String username, List<Integer> statusList) {
        return null;
    }

    @Override
    public List<UmsAdmin> lambdaList(Integer pageNum, Integer pageSize, String username, List<Integer> statusList) {
        return null;
    }

    @Override
    public List<UmsAdmin> subList(Long roleId) {
        return null;
    }

    @Override
    public List<RoleStatDto> groupList() {
        return null;
    }

    @Override
    public int deleteByUsername(String username) {
        return 0;
    }

    @Override
    public AdminRoleDto selectWithRoleList(Long id) {
        return null;
    }

    @Override
    public int updateByIds(List<Long> ids, Integer status) {
        return 0;
    }
}
