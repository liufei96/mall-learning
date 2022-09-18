package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsFeightTemplateMapperV1;
import com.liufei.mall.seed.model.PmsFeightTemplateDOV1;
import com.liufei.mall.seed.service.PmsFeightTemplateServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsFeightTemplate service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsFeightTemplateServiceImplV1 extends AbstractService<PmsFeightTemplateDOV1> implements PmsFeightTemplateServiceV1{

    @Resource
    private PmsFeightTemplateMapperV1 pmsFeightTemplateMapperV1;

}