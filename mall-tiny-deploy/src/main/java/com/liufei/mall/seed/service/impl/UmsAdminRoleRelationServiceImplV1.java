package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsAdminRoleRelationMapperV1;
import com.liufei.mall.seed.model.UmsAdminRoleRelationDOV1;
import com.liufei.mall.seed.service.UmsAdminRoleRelationServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsAdminRoleRelation service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsAdminRoleRelationServiceImplV1 extends AbstractService<UmsAdminRoleRelationDOV1> implements UmsAdminRoleRelationServiceV1{

    @Resource
    private UmsAdminRoleRelationMapperV1 umsAdminRoleRelationMapperV1;

}