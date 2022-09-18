package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsProductAttributeMapperV1;
import com.liufei.mall.seed.model.PmsProductAttributeDOV1;
import com.liufei.mall.seed.service.PmsProductAttributeServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsProductAttribute service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsProductAttributeServiceImplV1 extends AbstractService<PmsProductAttributeDOV1> implements PmsProductAttributeServiceV1{

    @Resource
    private PmsProductAttributeMapperV1 pmsProductAttributeMapperV1;

}