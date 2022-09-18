package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsAdminPermissionRelationMapperV1;
import com.liufei.mall.seed.model.UmsAdminPermissionRelationDOV1;
import com.liufei.mall.seed.service.UmsAdminPermissionRelationServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsAdminPermissionRelation service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsAdminPermissionRelationServiceImplV1 extends AbstractService<UmsAdminPermissionRelationDOV1> implements UmsAdminPermissionRelationServiceV1{

    @Resource
    private UmsAdminPermissionRelationMapperV1 umsAdminPermissionRelationMapperV1;

}