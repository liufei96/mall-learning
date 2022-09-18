package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsHomeNewProductMapperV1;
import com.liufei.mall.seed.model.SmsHomeNewProductDOV1;
import com.liufei.mall.seed.service.SmsHomeNewProductServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsHomeNewProduct service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsHomeNewProductServiceImplV1 extends AbstractService<SmsHomeNewProductDOV1> implements SmsHomeNewProductServiceV1{

    @Resource
    private SmsHomeNewProductMapperV1 smsHomeNewProductMapperV1;

}