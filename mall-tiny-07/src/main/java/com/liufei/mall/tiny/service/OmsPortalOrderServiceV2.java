package com.liufei.mall.tiny.service;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.tiny.model.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liufei
 * @version 1.0.0
 * @description 前台订单管理Service
 * @date 2022/9/14
 */
public interface OmsPortalOrderServiceV2 {

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    Result generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

}
