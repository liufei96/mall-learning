package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsProductFullReductionMapperV1;
import com.liufei.mall.seed.model.PmsProductFullReductionDOV1;
import com.liufei.mall.seed.service.PmsProductFullReductionServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsProductFullReduction service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsProductFullReductionServiceImplV1 extends AbstractService<PmsProductFullReductionDOV1> implements PmsProductFullReductionServiceV1{

    @Resource
    private PmsProductFullReductionMapperV1 pmsProductFullReductionMapperV1;

}