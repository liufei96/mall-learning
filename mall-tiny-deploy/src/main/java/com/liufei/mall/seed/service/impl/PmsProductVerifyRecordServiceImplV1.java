package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsProductVerifyRecordMapperV1;
import com.liufei.mall.seed.model.PmsProductVerifyRecordDOV1;
import com.liufei.mall.seed.service.PmsProductVerifyRecordServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsProductVerifyRecord service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsProductVerifyRecordServiceImplV1 extends AbstractService<PmsProductVerifyRecordDOV1> implements PmsProductVerifyRecordServiceV1{

    @Resource
    private PmsProductVerifyRecordMapperV1 pmsProductVerifyRecordMapperV1;

}