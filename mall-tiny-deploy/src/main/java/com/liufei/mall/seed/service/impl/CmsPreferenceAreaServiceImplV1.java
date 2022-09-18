package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsPreferenceAreaMapperV1;
import com.liufei.mall.seed.model.CmsPreferenceAreaDOV1;
import com.liufei.mall.seed.service.CmsPreferenceAreaServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsPreferenceArea service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsPreferenceAreaServiceImplV1 extends AbstractService<CmsPreferenceAreaDOV1> implements CmsPreferenceAreaServiceV1{

    @Resource
    private CmsPreferenceAreaMapperV1 cmsPreferenceAreaMapperV1;

}