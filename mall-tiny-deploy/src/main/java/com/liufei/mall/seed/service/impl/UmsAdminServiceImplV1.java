package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsAdminMapperV1;
import com.liufei.mall.seed.model.UmsAdminDOV1;
import com.liufei.mall.seed.service.UmsAdminServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsAdmin service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsAdminServiceImplV1 extends AbstractService<UmsAdminDOV1> implements UmsAdminServiceV1{

    @Resource
    private UmsAdminMapperV1 umsAdminMapperV1;

}