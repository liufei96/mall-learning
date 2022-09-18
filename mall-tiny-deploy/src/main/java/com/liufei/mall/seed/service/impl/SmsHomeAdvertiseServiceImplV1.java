package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsHomeAdvertiseMapperV1;
import com.liufei.mall.seed.model.SmsHomeAdvertiseDOV1;
import com.liufei.mall.seed.service.SmsHomeAdvertiseServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsHomeAdvertise service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsHomeAdvertiseServiceImplV1 extends AbstractService<SmsHomeAdvertiseDOV1> implements SmsHomeAdvertiseServiceV1{

    @Resource
    private SmsHomeAdvertiseMapperV1 smsHomeAdvertiseMapperV1;

}