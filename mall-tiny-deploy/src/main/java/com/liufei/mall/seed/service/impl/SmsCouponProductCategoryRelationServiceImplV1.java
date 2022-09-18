package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsCouponProductCategoryRelationMapperV1;
import com.liufei.mall.seed.model.SmsCouponProductCategoryRelationDOV1;
import com.liufei.mall.seed.service.SmsCouponProductCategoryRelationServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsCouponProductCategoryRelation service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsCouponProductCategoryRelationServiceImplV1 extends AbstractService<SmsCouponProductCategoryRelationDOV1> implements SmsCouponProductCategoryRelationServiceV1{

    @Resource
    private SmsCouponProductCategoryRelationMapperV1 smsCouponProductCategoryRelationMapperV1;

}