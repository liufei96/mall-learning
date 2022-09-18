package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsProductLadderMapperV1;
import com.liufei.mall.seed.model.PmsProductLadderDOV1;
import com.liufei.mall.seed.service.PmsProductLadderServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsProductLadder service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsProductLadderServiceImplV1 extends AbstractService<PmsProductLadderDOV1> implements PmsProductLadderServiceV1{

    @Resource
    private PmsProductLadderMapperV1 pmsProductLadderMapperV1;

}