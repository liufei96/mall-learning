package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.OmsCartItemMapperV1;
import com.liufei.mall.seed.model.OmsCartItemDOV1;
import com.liufei.mall.seed.service.OmsCartItemServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description OmsCartItem service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class OmsCartItemServiceImplV1 extends AbstractService<OmsCartItemDOV1> implements OmsCartItemServiceV1{

    @Resource
    private OmsCartItemMapperV1 omsCartItemMapperV1;

}