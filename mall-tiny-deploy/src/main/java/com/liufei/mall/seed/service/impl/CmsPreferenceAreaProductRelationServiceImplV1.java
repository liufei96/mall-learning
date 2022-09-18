package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsPreferenceAreaProductRelationMapperV1;
import com.liufei.mall.seed.model.CmsPreferenceAreaProductRelationDOV1;
import com.liufei.mall.seed.service.CmsPreferenceAreaProductRelationServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsPreferenceAreaProductRelation service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsPreferenceAreaProductRelationServiceImplV1 extends AbstractService<CmsPreferenceAreaProductRelationDOV1> implements CmsPreferenceAreaProductRelationServiceV1{

    @Resource
    private CmsPreferenceAreaProductRelationMapperV1 cmsPreferenceAreaProductRelationMapperV1;

}