package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsSubjectCategoryMapperV1;
import com.liufei.mall.seed.model.CmsSubjectCategoryDOV1;
import com.liufei.mall.seed.service.CmsSubjectCategoryServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsSubjectCategory service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsSubjectCategoryServiceImplV1 extends AbstractService<CmsSubjectCategoryDOV1> implements CmsSubjectCategoryServiceV1{

    @Resource
    private CmsSubjectCategoryMapperV1 cmsSubjectCategoryMapperV1;

}