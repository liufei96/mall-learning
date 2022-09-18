package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsFlashPromotionLogMapperV1;
import com.liufei.mall.seed.model.SmsFlashPromotionLogDOV1;
import com.liufei.mall.seed.service.SmsFlashPromotionLogServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsFlashPromotionLog service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsFlashPromotionLogServiceImplV1 extends AbstractService<SmsFlashPromotionLogDOV1> implements SmsFlashPromotionLogServiceV1{

    @Resource
    private SmsFlashPromotionLogMapperV1 smsFlashPromotionLogMapperV1;

}