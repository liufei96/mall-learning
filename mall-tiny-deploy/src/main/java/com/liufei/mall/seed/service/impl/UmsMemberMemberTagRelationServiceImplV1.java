package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsMemberMemberTagRelationMapperV1;
import com.liufei.mall.seed.model.UmsMemberMemberTagRelationDOV1;
import com.liufei.mall.seed.service.UmsMemberMemberTagRelationServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsMemberMemberTagRelation service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsMemberMemberTagRelationServiceImplV1 extends AbstractService<UmsMemberMemberTagRelationDOV1> implements UmsMemberMemberTagRelationServiceV1{

    @Resource
    private UmsMemberMemberTagRelationMapperV1 umsMemberMemberTagRelationMapperV1;

}