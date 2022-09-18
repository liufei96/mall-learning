package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsMemberLevelMapperV1;
import com.liufei.mall.seed.model.UmsMemberLevelDOV1;
import com.liufei.mall.seed.service.UmsMemberLevelServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsMemberLevel service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsMemberLevelServiceImplV1 extends AbstractService<UmsMemberLevelDOV1> implements UmsMemberLevelServiceV1{

    @Resource
    private UmsMemberLevelMapperV1 umsMemberLevelMapperV1;

}