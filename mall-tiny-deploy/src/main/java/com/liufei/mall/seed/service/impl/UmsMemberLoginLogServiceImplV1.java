package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsMemberLoginLogMapperV1;
import com.liufei.mall.seed.model.UmsMemberLoginLogDOV1;
import com.liufei.mall.seed.service.UmsMemberLoginLogServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsMemberLoginLog service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsMemberLoginLogServiceImplV1 extends AbstractService<UmsMemberLoginLogDOV1> implements UmsMemberLoginLogServiceV1{

    @Resource
    private UmsMemberLoginLogMapperV1 umsMemberLoginLogMapperV1;

}