package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.OmsOrderReturnReasonMapperV1;
import com.liufei.mall.seed.model.OmsOrderReturnReasonDOV1;
import com.liufei.mall.seed.service.OmsOrderReturnReasonServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description OmsOrderReturnReason service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class OmsOrderReturnReasonServiceImplV1 extends AbstractService<OmsOrderReturnReasonDOV1> implements OmsOrderReturnReasonServiceV1{

    @Resource
    private OmsOrderReturnReasonMapperV1 omsOrderReturnReasonMapperV1;

}