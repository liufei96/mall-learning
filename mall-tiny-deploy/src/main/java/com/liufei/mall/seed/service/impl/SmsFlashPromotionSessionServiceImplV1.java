package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsFlashPromotionSessionMapperV1;
import com.liufei.mall.seed.model.SmsFlashPromotionSessionDOV1;
import com.liufei.mall.seed.service.SmsFlashPromotionSessionServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsFlashPromotionSession service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsFlashPromotionSessionServiceImplV1 extends AbstractService<SmsFlashPromotionSessionDOV1> implements SmsFlashPromotionSessionServiceV1{

    @Resource
    private SmsFlashPromotionSessionMapperV1 smsFlashPromotionSessionMapperV1;

}