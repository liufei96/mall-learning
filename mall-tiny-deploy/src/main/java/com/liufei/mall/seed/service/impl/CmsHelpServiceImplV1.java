package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsHelpMapperV1;
import com.liufei.mall.seed.model.CmsHelpDOV1;
import com.liufei.mall.seed.service.CmsHelpServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsHelp service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsHelpServiceImplV1 extends AbstractService<CmsHelpDOV1> implements CmsHelpServiceV1{

    @Resource
    private CmsHelpMapperV1 cmsHelpMapperV1;

}