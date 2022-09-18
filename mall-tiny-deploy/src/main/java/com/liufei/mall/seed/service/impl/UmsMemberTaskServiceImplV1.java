package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsMemberTaskMapperV1;
import com.liufei.mall.seed.model.UmsMemberTaskDOV1;
import com.liufei.mall.seed.service.UmsMemberTaskServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsMemberTask service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsMemberTaskServiceImplV1 extends AbstractService<UmsMemberTaskDOV1> implements UmsMemberTaskServiceV1{

    @Resource
    private UmsMemberTaskMapperV1 umsMemberTaskMapperV1;

}