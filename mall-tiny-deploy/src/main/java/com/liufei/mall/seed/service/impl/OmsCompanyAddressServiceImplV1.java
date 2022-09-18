package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.OmsCompanyAddressMapperV1;
import com.liufei.mall.seed.model.OmsCompanyAddressDOV1;
import com.liufei.mall.seed.service.OmsCompanyAddressServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description OmsCompanyAddress service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class OmsCompanyAddressServiceImplV1 extends AbstractService<OmsCompanyAddressDOV1> implements OmsCompanyAddressServiceV1{

    @Resource
    private OmsCompanyAddressMapperV1 omsCompanyAddressMapperV1;

}