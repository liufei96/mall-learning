package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsSubjectMapperV1;
import com.liufei.mall.seed.model.CmsSubjectDOV1;
import com.liufei.mall.seed.service.CmsSubjectServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsSubject service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsSubjectServiceImplV1 extends AbstractService<CmsSubjectDOV1> implements CmsSubjectServiceV1{

    @Resource
    private CmsSubjectMapperV1 cmsSubjectMapperV1;

}