package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsTopicCategoryMapperV1;
import com.liufei.mall.seed.model.CmsTopicCategoryDOV1;
import com.liufei.mall.seed.service.CmsTopicCategoryServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsTopicCategory service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsTopicCategoryServiceImplV1 extends AbstractService<CmsTopicCategoryDOV1> implements CmsTopicCategoryServiceV1{

    @Resource
    private CmsTopicCategoryMapperV1 cmsTopicCategoryMapperV1;

}