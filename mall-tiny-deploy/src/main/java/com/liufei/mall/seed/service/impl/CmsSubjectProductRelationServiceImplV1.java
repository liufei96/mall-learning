package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsSubjectProductRelationMapperV1;
import com.liufei.mall.seed.model.CmsSubjectProductRelationDOV1;
import com.liufei.mall.seed.service.CmsSubjectProductRelationServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsSubjectProductRelation service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsSubjectProductRelationServiceImplV1 extends AbstractService<CmsSubjectProductRelationDOV1> implements CmsSubjectProductRelationServiceV1{

    @Resource
    private CmsSubjectProductRelationMapperV1 cmsSubjectProductRelationMapperV1;

}