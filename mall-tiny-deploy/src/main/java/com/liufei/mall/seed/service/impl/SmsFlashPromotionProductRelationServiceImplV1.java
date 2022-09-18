package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsFlashPromotionProductRelationMapperV1;
import com.liufei.mall.seed.model.SmsFlashPromotionProductRelationDOV1;
import com.liufei.mall.seed.service.SmsFlashPromotionProductRelationServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsFlashPromotionProductRelation service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsFlashPromotionProductRelationServiceImplV1 extends AbstractService<SmsFlashPromotionProductRelationDOV1> implements SmsFlashPromotionProductRelationServiceV1{

    @Resource
    private SmsFlashPromotionProductRelationMapperV1 smsFlashPromotionProductRelationMapperV1;

}