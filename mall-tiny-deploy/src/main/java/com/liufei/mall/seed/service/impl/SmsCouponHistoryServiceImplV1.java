package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsCouponHistoryMapperV1;
import com.liufei.mall.seed.model.SmsCouponHistoryDOV1;
import com.liufei.mall.seed.service.SmsCouponHistoryServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsCouponHistory service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsCouponHistoryServiceImplV1 extends AbstractService<SmsCouponHistoryDOV1> implements SmsCouponHistoryServiceV1{

    @Resource
    private SmsCouponHistoryMapperV1 smsCouponHistoryMapperV1;

}