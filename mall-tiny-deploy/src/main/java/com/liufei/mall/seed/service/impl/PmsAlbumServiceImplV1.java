package com.liufei.mall.seed.service.impl;

import com.liufei.mall.seed.dao.PmsAlbumMapperV1;
import com.liufei.mall.seed.model.PmsAlbumDOV1;
import com.liufei.mall.seed.service.PmsAlbumServiceV1;
import com.liufei.mall.seed.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author liufei
* @version 1.0.0
* @description PmsAlbum service implements for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@Service
public class PmsAlbumServiceImplV1 extends AbstractService<PmsAlbumDOV1> implements PmsAlbumServiceV1{

    @Resource
    private PmsAlbumMapperV1 pmsAlbumMapperV1;

}