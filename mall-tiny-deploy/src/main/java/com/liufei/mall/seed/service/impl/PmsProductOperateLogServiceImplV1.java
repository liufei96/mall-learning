package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsProductOperateLogMapperV1;
import com.liufei.mall.seed.model.PmsProductOperateLogDOV1;
import com.liufei.mall.seed.service.PmsProductOperateLogServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsProductOperateLog service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsProductOperateLogServiceImplV1 extends AbstractService<PmsProductOperateLogDOV1> implements PmsProductOperateLogServiceV1{

    @Resource
    private PmsProductOperateLogMapperV1 pmsProductOperateLogMapperV1;

}