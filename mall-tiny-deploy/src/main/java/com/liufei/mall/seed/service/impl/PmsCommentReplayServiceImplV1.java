package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsCommentReplayMapperV1;
import com.liufei.mall.seed.model.PmsCommentReplayDOV1;
import com.liufei.mall.seed.service.PmsCommentReplayServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsCommentReplay service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsCommentReplayServiceImplV1 extends AbstractService<PmsCommentReplayDOV1> implements PmsCommentReplayServiceV1{

    @Resource
    private PmsCommentReplayMapperV1 pmsCommentReplayMapperV1;

}