package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsBrandMapperV1;
import com.liufei.mall.seed.model.PmsBrandDOV1;
import com.liufei.mall.seed.service.PmsBrandServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsBrand service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsBrandServiceImplV1 extends AbstractService<PmsBrandDOV1> implements PmsBrandServiceV1{

    @Resource
    private PmsBrandMapperV1 pmsBrandMapperV1;

}