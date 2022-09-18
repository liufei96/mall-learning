package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsMemberPriceMapperV1;
import com.liufei.mall.seed.model.PmsMemberPriceDOV1;
import com.liufei.mall.seed.service.PmsMemberPriceServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsMemberPrice service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsMemberPriceServiceImplV1 extends AbstractService<PmsMemberPriceDOV1> implements PmsMemberPriceServiceV1{

    @Resource
    private PmsMemberPriceMapperV1 pmsMemberPriceMapperV1;

}