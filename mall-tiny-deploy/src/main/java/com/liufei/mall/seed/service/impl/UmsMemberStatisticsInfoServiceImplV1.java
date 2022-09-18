package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.UmsMemberStatisticsInfoMapperV1;
import com.liufei.mall.seed.model.UmsMemberStatisticsInfoDOV1;
import com.liufei.mall.seed.service.UmsMemberStatisticsInfoServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description UmsMemberStatisticsInfo service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class UmsMemberStatisticsInfoServiceImplV1 extends AbstractService<UmsMemberStatisticsInfoDOV1> implements UmsMemberStatisticsInfoServiceV1{

    @Resource
    private UmsMemberStatisticsInfoMapperV1 umsMemberStatisticsInfoMapperV1;

}