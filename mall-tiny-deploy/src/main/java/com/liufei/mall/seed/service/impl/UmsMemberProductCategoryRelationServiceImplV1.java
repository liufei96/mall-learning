package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsMemberProductCategoryRelationMapperV1;
import com.liufei.mall.seed.model.UmsMemberProductCategoryRelationDOV1;
import com.liufei.mall.seed.service.UmsMemberProductCategoryRelationServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsMemberProductCategoryRelation service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsMemberProductCategoryRelationServiceImplV1 extends AbstractService<UmsMemberProductCategoryRelationDOV1> implements UmsMemberProductCategoryRelationServiceV1{

    @Resource
    private UmsMemberProductCategoryRelationMapperV1 umsMemberProductCategoryRelationMapperV1;

}