package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsProductAttributeValueMapperV1;
import com.liufei.mall.seed.model.PmsProductAttributeValueDOV1;
import com.liufei.mall.seed.service.PmsProductAttributeValueServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsProductAttributeValue service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsProductAttributeValueServiceImplV1 extends AbstractService<PmsProductAttributeValueDOV1> implements PmsProductAttributeValueServiceV1{

    @Resource
    private PmsProductAttributeValueMapperV1 pmsProductAttributeValueMapperV1;

}