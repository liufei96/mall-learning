package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsPermissionMapperV1;
import com.liufei.mall.seed.model.UmsPermissionDOV1;
import com.liufei.mall.seed.service.UmsPermissionServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsPermission service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsPermissionServiceImplV1 extends AbstractService<UmsPermissionDOV1> implements UmsPermissionServiceV1{

    @Resource
    private UmsPermissionMapperV1 umsPermissionMapperV1;

}