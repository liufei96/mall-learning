package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.OmsOrderItemMapperV1;
import com.liufei.mall.seed.model.OmsOrderItemDOV1;
import com.liufei.mall.seed.service.OmsOrderItemServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description OmsOrderItem service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class OmsOrderItemServiceImplV1 extends AbstractService<OmsOrderItemDOV1> implements OmsOrderItemServiceV1{

    @Resource
    private OmsOrderItemMapperV1 omsOrderItemMapperV1;

}