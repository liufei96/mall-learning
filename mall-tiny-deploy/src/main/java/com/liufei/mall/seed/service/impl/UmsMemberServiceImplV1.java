package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsMemberMapperV1;
import com.liufei.mall.seed.model.UmsMemberDOV1;
import com.liufei.mall.seed.service.UmsMemberServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsMember service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsMemberServiceImplV1 extends AbstractService<UmsMemberDOV1> implements UmsMemberServiceV1{

    @Resource
    private UmsMemberMapperV1 umsMemberMapperV1;

}