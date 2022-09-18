package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsProductAttributeCategoryMapperV1;
import com.liufei.mall.seed.model.PmsProductAttributeCategoryDOV1;
import com.liufei.mall.seed.service.PmsProductAttributeCategoryServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsProductAttributeCategory service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsProductAttributeCategoryServiceImplV1 extends AbstractService<PmsProductAttributeCategoryDOV1> implements PmsProductAttributeCategoryServiceV1{

    @Resource
    private PmsProductAttributeCategoryMapperV1 pmsProductAttributeCategoryMapperV1;

}