package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsRoleMapperV1;
import com.liufei.mall.seed.model.UmsRoleDOV1;
import com.liufei.mall.seed.service.UmsRoleServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsRole service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsRoleServiceImplV1 extends AbstractService<UmsRoleDOV1> implements UmsRoleServiceV1{

    @Resource
    private UmsRoleMapperV1 umsRoleMapperV1;

}