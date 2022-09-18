package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.OmsOrderSettingMapperV1;
import com.liufei.mall.seed.model.OmsOrderSettingDOV1;
import com.liufei.mall.seed.service.OmsOrderSettingServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description OmsOrderSetting service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class OmsOrderSettingServiceImplV1 extends AbstractService<OmsOrderSettingDOV1> implements OmsOrderSettingServiceV1{

    @Resource
    private OmsOrderSettingMapperV1 omsOrderSettingMapperV1;

}