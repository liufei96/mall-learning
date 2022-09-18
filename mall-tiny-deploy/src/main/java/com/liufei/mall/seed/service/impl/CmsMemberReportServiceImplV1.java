package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.CmsMemberReportMapperV1;
import com.liufei.mall.seed.model.CmsMemberReportDOV1;
import com.liufei.mall.seed.service.CmsMemberReportServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description CmsMemberReport service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class CmsMemberReportServiceImplV1 extends AbstractService<CmsMemberReportDOV1> implements CmsMemberReportServiceV1{

    @Resource
    private CmsMemberReportMapperV1 cmsMemberReportMapperV1;

}