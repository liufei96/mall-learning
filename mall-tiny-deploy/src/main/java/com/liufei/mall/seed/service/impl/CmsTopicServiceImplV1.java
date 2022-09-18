package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsTopicMapperV1;
import com.liufei.mall.seed.model.CmsTopicDOV1;
import com.liufei.mall.seed.service.CmsTopicServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsTopic service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsTopicServiceImplV1 extends AbstractService<CmsTopicDOV1> implements CmsTopicServiceV1{

    @Resource
    private CmsTopicMapperV1 cmsTopicMapperV1;

}