package com.liufei.mall.tiny.service.impl;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.tiny.model.OrderParam;
import com.liufei.mall.tiny.mq.CancelOrderSender;
import com.liufei.mall.tiny.service.OmsPortalOrderServiceV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/14
 */
@Service
public class OmsPortalOrderServiceV2Impl implements OmsPortalOrderServiceV2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceV2Impl.class);

    @Resource
    private CancelOrderSender cancelOrderSender;

    @Override
    public Result generateOrder(OrderParam orderParam) {
        //todo 执行一系类下单操作，具体参考mall项目
        LOGGER.info("process generateOrder");
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        sendDelayMessageCancelOrder(11L);
        return ResultGenerator.genSuccessResult("下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        //todo 执行一系类取消订单操作，具体参考mall项目
        LOGGER.info("process cancelOrder orderId:{}", orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设为60分钟(测试用的30秒)
        long delayTimes = 30 * 1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
