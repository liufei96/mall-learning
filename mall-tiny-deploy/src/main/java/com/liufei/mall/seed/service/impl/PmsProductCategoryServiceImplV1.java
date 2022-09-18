package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsProductCategoryMapperV1;
import com.liufei.mall.seed.model.PmsProductCategoryDOV1;
import com.liufei.mall.seed.service.PmsProductCategoryServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsProductCategory service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsProductCategoryServiceImplV1 extends AbstractService<PmsProductCategoryDOV1> implements PmsProductCategoryServiceV1{

    @Resource
    private PmsProductCategoryMapperV1 pmsProductCategoryMapperV1;

}