package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.SmsHomeRecommendSubjectMapperV1;
import com.liufei.mall.seed.model.SmsHomeRecommendSubjectDOV1;
import com.liufei.mall.seed.service.SmsHomeRecommendSubjectServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description SmsHomeRecommendSubject service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class SmsHomeRecommendSubjectServiceImplV1 extends AbstractService<SmsHomeRecommendSubjectDOV1> implements SmsHomeRecommendSubjectServiceV1{

    @Resource
    private SmsHomeRecommendSubjectMapperV1 smsHomeRecommendSubjectMapperV1;

}