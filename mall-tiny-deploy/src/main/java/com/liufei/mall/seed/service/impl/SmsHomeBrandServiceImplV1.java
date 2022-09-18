package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsHomeBrandMapperV1;
import com.liufei.mall.seed.model.SmsHomeBrandDOV1;
import com.liufei.mall.seed.service.SmsHomeBrandServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsHomeBrand service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsHomeBrandServiceImplV1 extends AbstractService<SmsHomeBrandDOV1> implements SmsHomeBrandServiceV1{

    @Resource
    private SmsHomeBrandMapperV1 smsHomeBrandMapperV1;

}