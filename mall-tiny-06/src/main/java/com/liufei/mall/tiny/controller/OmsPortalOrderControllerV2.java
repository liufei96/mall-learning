package com.liufei.mall.tiny.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.tiny.model.OrderParam;
import com.liufei.mall.tiny.service.OmsPortalOrderServiceV2;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liufei
 * @version 1.0.0
 * @description 订单生成
 * @date 2022/9/14
 */
@RestController
@RequestMapping("/v2/order")
public class OmsPortalOrderControllerV2 {

    @Resource
    private OmsPortalOrderServiceV2 portalOrderServiceV2;

    @ApiOperation("根据购物车信息生成订单")
    @PostMapping(value = "/generateOrder")
    public Result generateOrder(@RequestBody OrderParam orderParam) {
        return portalOrderServiceV2.generateOrder(orderParam);
    }
}
