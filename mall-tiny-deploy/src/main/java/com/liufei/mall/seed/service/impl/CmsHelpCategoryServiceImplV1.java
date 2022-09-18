package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsHelpCategoryMapperV1;
import com.liufei.mall.seed.model.CmsHelpCategoryDOV1;
import com.liufei.mall.seed.service.CmsHelpCategoryServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsHelpCategory service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsHelpCategoryServiceImplV1 extends AbstractService<CmsHelpCategoryDOV1> implements CmsHelpCategoryServiceV1{

    @Resource
    private CmsHelpCategoryMapperV1 cmsHelpCategoryMapperV1;

}