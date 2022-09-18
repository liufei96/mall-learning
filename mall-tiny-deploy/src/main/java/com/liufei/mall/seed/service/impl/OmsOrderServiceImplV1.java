package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.OmsOrderMapperV1;
import com.liufei.mall.seed.model.OmsOrderDOV1;
import com.liufei.mall.seed.service.OmsOrderServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description OmsOrder service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class OmsOrderServiceImplV1 extends AbstractService<OmsOrderDOV1> implements OmsOrderServiceV1{

    @Resource
    private OmsOrderMapperV1 omsOrderMapperV1;

}