package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsFlashPromotionMapperV1;
import com.liufei.mall.seed.model.SmsFlashPromotionDOV1;
import com.liufei.mall.seed.service.SmsFlashPromotionServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsFlashPromotion service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsFlashPromotionServiceImplV1 extends AbstractService<SmsFlashPromotionDOV1> implements SmsFlashPromotionServiceV1{

    @Resource
    private SmsFlashPromotionMapperV1 smsFlashPromotionMapperV1;

}