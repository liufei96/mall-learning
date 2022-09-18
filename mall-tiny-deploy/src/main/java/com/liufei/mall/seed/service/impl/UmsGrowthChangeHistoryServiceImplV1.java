package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsGrowthChangeHistoryMapperV1;
import com.liufei.mall.seed.model.UmsGrowthChangeHistoryDOV1;
import com.liufei.mall.seed.service.UmsGrowthChangeHistoryServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsGrowthChangeHistory service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsGrowthChangeHistoryServiceImplV1 extends AbstractService<UmsGrowthChangeHistoryDOV1> implements UmsGrowthChangeHistoryServiceV1{

    @Resource
    private UmsGrowthChangeHistoryMapperV1 umsGrowthChangeHistoryMapperV1;

}