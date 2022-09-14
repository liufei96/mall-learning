package com.liufei.mall.tiny.mq;

import com.liufei.mall.tiny.service.OmsPortalOrderServiceV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liufei
 * @version 1.0.0
 * @description 取消订单消息的处理者
 * @date 2022/9/14
 */
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {

    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);

    @Resource
    private OmsPortalOrderServiceV2 portalOrderServiceV2;

    @RabbitHandler
    public void handle(Long orderId) {
        LOGGER.info("receive delay message orderId:{}", orderId);
        portalOrderServiceV2.cancelOrder(orderId);
    }

}
