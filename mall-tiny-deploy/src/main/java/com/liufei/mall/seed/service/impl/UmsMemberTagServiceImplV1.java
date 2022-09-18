package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsMemberTagMapperV1;
import com.liufei.mall.seed.model.UmsMemberTagDOV1;
import com.liufei.mall.seed.service.UmsMemberTagServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsMemberTag service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsMemberTagServiceImplV1 extends AbstractService<UmsMemberTagDOV1> implements UmsMemberTagServiceV1{

    @Resource
    private UmsMemberTagMapperV1 umsMemberTagMapperV1;

}