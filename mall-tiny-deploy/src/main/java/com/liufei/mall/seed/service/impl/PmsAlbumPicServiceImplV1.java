package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsAlbumPicMapperV1;
import com.liufei.mall.seed.model.PmsAlbumPicDOV1;
import com.liufei.mall.seed.service.PmsAlbumPicServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsAlbumPic service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsAlbumPicServiceImplV1 extends AbstractService<PmsAlbumPicDOV1> implements PmsAlbumPicServiceV1{

    @Resource
    private PmsAlbumPicMapperV1 pmsAlbumPicMapperV1;

}