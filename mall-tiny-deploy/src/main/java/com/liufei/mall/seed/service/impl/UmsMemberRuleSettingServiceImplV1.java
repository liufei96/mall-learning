package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsMemberRuleSettingMapperV1;
import com.liufei.mall.seed.model.UmsMemberRuleSettingDOV1;
import com.liufei.mall.seed.service.UmsMemberRuleSettingServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsMemberRuleSetting service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsMemberRuleSettingServiceImplV1 extends AbstractService<UmsMemberRuleSettingDOV1> implements UmsMemberRuleSettingServiceV1{

    @Resource
    private UmsMemberRuleSettingMapperV1 umsMemberRuleSettingMapperV1;

}