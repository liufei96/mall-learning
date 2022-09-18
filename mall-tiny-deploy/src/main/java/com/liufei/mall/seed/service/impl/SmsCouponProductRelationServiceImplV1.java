package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsCouponProductRelationMapperV1;
import com.liufei.mall.seed.model.SmsCouponProductRelationDOV1;
import com.liufei.mall.seed.service.SmsCouponProductRelationServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsCouponProductRelation service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsCouponProductRelationServiceImplV1 extends AbstractService<SmsCouponProductRelationDOV1> implements SmsCouponProductRelationServiceV1{

    @Resource
    private SmsCouponProductRelationMapperV1 smsCouponProductRelationMapperV1;

}