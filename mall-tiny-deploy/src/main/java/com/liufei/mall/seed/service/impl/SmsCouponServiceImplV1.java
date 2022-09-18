package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsCouponMapperV1;
import com.liufei.mall.seed.model.SmsCouponDOV1;
import com.liufei.mall.seed.service.SmsCouponServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsCoupon service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsCouponServiceImplV1 extends AbstractService<SmsCouponDOV1> implements SmsCouponServiceV1{

    @Resource
    private SmsCouponMapperV1 smsCouponMapperV1;

}