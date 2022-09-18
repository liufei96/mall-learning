package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsIntegrationConsumeSettingMapperV1;
import com.liufei.mall.seed.model.UmsIntegrationConsumeSettingDOV1;
import com.liufei.mall.seed.service.UmsIntegrationConsumeSettingServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsIntegrationConsumeSetting service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsIntegrationConsumeSettingServiceImplV1 extends AbstractService<UmsIntegrationConsumeSettingDOV1> implements UmsIntegrationConsumeSettingServiceV1{

    @Resource
    private UmsIntegrationConsumeSettingMapperV1 umsIntegrationConsumeSettingMapperV1;

}