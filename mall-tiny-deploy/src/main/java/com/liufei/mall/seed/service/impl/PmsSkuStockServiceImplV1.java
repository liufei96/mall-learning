package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsSkuStockMapperV1;
import com.liufei.mall.seed.model.PmsSkuStockDOV1;
import com.liufei.mall.seed.service.PmsSkuStockServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsSkuStock service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsSkuStockServiceImplV1 extends AbstractService<PmsSkuStockDOV1> implements PmsSkuStockServiceV1{

    @Resource
    private PmsSkuStockMapperV1 pmsSkuStockMapperV1;

}