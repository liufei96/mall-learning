package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsMemberReceiveAddressMapperV1;
import com.liufei.mall.seed.model.UmsMemberReceiveAddressDOV1;
import com.liufei.mall.seed.service.UmsMemberReceiveAddressServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsMemberReceiveAddress service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsMemberReceiveAddressServiceImplV1 extends AbstractService<UmsMemberReceiveAddressDOV1> implements UmsMemberReceiveAddressServiceV1{

    @Resource
    private UmsMemberReceiveAddressMapperV1 umsMemberReceiveAddressMapperV1;

}