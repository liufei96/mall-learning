package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsCommentMapperV1;
import com.liufei.mall.seed.model.PmsCommentDOV1;
import com.liufei.mall.seed.service.PmsCommentServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsComment service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsCommentServiceImplV1 extends AbstractService<PmsCommentDOV1> implements PmsCommentServiceV1{

    @Resource
    private PmsCommentMapperV1 pmsCommentMapperV1;

}