package com.liufei.mall.tiny.service.impl;

import com.liufei.mall.seed.core.AbstractService;
import com.liufei.mall.seed.dao.UmsAdminMapperV1;
import com.liufei.mall.seed.model.UmsAdminDOV1;
import com.liufei.mall.seed.model.UmsPermissionDOV1;
import com.liufei.mall.tiny.dao.UmsAdminRoleRelationMapperV2;
import com.liufei.mall.tiny.service.UmsAdminServiceV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/10
 */
@Service
public class UmsAdminServiceV2Impl extends AbstractService<UmsAdminDOV1> implements UmsAdminServiceV2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceV2Impl.class);

    @Resource
    private UmsAdminMapperV1 umsAdminMapperV1;

    @Resource
    private UmsAdminRoleRelationMapperV2 umsAdminRoleRelationMapperV2;

    @Override
    public UmsAdminDOV1 getAdminByUsername(String username) {
        Condition condition = new Condition(UmsAdminDOV1.class);
        condition.createCriteria().andEqualTo("username", username)
                .andEqualTo("deleted", 0);
        List<UmsAdminDOV1> umsAdminDOV1s = umsAdminMapperV1.selectByCondition(condition);
        if (umsAdminDOV1s != null && umsAdminDOV1s.size() > 0) {
            return umsAdminDOV1s.get(0);
        }
        return null;
    }

    @Override
    public List<UmsPermissionDOV1> getPermissionList(Long adminId) {
        return umsAdminRoleRelationMapperV2.getPermissionList(adminId);
    }
}
