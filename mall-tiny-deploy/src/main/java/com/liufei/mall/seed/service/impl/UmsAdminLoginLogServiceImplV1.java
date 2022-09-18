package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsAdminLoginLogMapperV1;
import com.liufei.mall.seed.model.UmsAdminLoginLogDOV1;
import com.liufei.mall.seed.service.UmsAdminLoginLogServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsAdminLoginLog service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsAdminLoginLogServiceImplV1 extends AbstractService<UmsAdminLoginLogDOV1> implements UmsAdminLoginLogServiceV1{

    @Resource
    private UmsAdminLoginLogMapperV1 umsAdminLoginLogMapperV1;

}