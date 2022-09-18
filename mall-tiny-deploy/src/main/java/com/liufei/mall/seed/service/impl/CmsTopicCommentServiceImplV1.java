package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsTopicCommentMapperV1;
import com.liufei.mall.seed.model.CmsTopicCommentDOV1;
import com.liufei.mall.seed.service.CmsTopicCommentServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsTopicComment service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsTopicCommentServiceImplV1 extends AbstractService<CmsTopicCommentDOV1> implements CmsTopicCommentServiceV1{

    @Resource
    private CmsTopicCommentMapperV1 cmsTopicCommentMapperV1;

}