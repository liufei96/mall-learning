package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsProductCategoryAttributeRelationMapperV1;
import com.liufei.mall.seed.model.PmsProductCategoryAttributeRelationDOV1;
import com.liufei.mall.seed.service.PmsProductCategoryAttributeRelationServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsProductCategoryAttributeRelation service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsProductCategoryAttributeRelationServiceImplV1 extends AbstractService<PmsProductCategoryAttributeRelationDOV1> implements PmsProductCategoryAttributeRelationServiceV1{

    @Resource
    private PmsProductCategoryAttributeRelationMapperV1 pmsProductCategoryAttributeRelationMapperV1;

}