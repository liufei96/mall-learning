package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsSubjectCommentMapperV1;
import com.liufei.mall.seed.model.CmsSubjectCommentDOV1;
import com.liufei.mall.seed.service.CmsSubjectCommentServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsSubjectComment service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsSubjectCommentServiceImplV1 extends AbstractService<CmsSubjectCommentDOV1> implements CmsSubjectCommentServiceV1{

    @Resource
    private CmsSubjectCommentMapperV1 cmsSubjectCommentMapperV1;

}