package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.OmsOrderOperateHistoryMapperV1;
import com.liufei.mall.seed.model.OmsOrderOperateHistoryDOV1;
import com.liufei.mall.seed.service.OmsOrderOperateHistoryServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description OmsOrderOperateHistory service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class OmsOrderOperateHistoryServiceImplV1 extends AbstractService<OmsOrderOperateHistoryDOV1> implements OmsOrderOperateHistoryServiceV1{

    @Resource
    private OmsOrderOperateHistoryMapperV1 omsOrderOperateHistoryMapperV1;

}