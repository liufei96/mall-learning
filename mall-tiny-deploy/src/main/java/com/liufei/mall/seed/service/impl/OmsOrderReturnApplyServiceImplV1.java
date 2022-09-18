package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.OmsOrderReturnApplyMapperV1;
import com.liufei.mall.seed.model.OmsOrderReturnApplyDOV1;
import com.liufei.mall.seed.service.OmsOrderReturnApplyServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description OmsOrderReturnApply service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class OmsOrderReturnApplyServiceImplV1 extends AbstractService<OmsOrderReturnApplyDOV1> implements OmsOrderReturnApplyServiceV1{

    @Resource
    private OmsOrderReturnApplyMapperV1 omsOrderReturnApplyMapperV1;

}