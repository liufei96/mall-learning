package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsHomeRecommendProductMapperV1;
import com.liufei.mall.seed.model.SmsHomeRecommendProductDOV1;
import com.liufei.mall.seed.service.SmsHomeRecommendProductServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsHomeRecommendProduct service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsHomeRecommendProductServiceImplV1 extends AbstractService<SmsHomeRecommendProductDOV1> implements SmsHomeRecommendProductServiceV1{

    @Resource
    private SmsHomeRecommendProductMapperV1 smsHomeRecommendProductMapperV1;

}