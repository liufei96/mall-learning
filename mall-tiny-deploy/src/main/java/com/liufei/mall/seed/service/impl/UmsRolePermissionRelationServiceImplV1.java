package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsRolePermissionRelationMapperV1;
import com.liufei.mall.seed.model.UmsRolePermissionRelationDOV1;
import com.liufei.mall.seed.service.UmsRolePermissionRelationServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsRolePermissionRelation service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsRolePermissionRelationServiceImplV1 extends AbstractService<UmsRolePermissionRelationDOV1> implements UmsRolePermissionRelationServiceV1{

    @Resource
    private UmsRolePermissionRelationMapperV1 umsRolePermissionRelationMapperV1;

}