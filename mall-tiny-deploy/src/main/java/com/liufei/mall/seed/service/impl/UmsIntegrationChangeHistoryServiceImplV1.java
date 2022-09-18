package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsIntegrationChangeHistoryMapperV1;
import com.liufei.mall.seed.model.UmsIntegrationChangeHistoryDOV1;
import com.liufei.mall.seed.service.UmsIntegrationChangeHistoryServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsIntegrationChangeHistory service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsIntegrationChangeHistoryServiceImplV1 extends AbstractService<UmsIntegrationChangeHistoryDOV1> implements UmsIntegrationChangeHistoryServiceV1{

    @Resource
    private UmsIntegrationChangeHistoryMapperV1 umsIntegrationChangeHistoryMapperV1;

}