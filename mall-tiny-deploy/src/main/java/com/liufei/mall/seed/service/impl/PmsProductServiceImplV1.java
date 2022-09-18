package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsProductMapperV1;
import com.liufei.mall.seed.model.PmsProductDOV1;
import com.liufei.mall.seed.service.PmsProductServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsProduct service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsProductServiceImplV1 extends AbstractService<PmsProductDOV1> implements PmsProductServiceV1{

    @Resource
    private PmsProductMapperV1 pmsProductMapperV1;

}