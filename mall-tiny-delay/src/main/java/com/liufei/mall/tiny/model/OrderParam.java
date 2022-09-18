package com.liufei.mall.tiny.model;

import lombok.Data;

/**
 * @author liufei
 * @version 1.0.0
 * @description 生成订单时传入的参数
 * @date 2022/9/14
 */
@Data
public class OrderParam {

    //收货地址id
    private Long memberReceiveAddressId;

    //优惠券id
    private Long couponId;

    //使用的积分数
    private Integer useIntegration;

    //支付方式
    private Integer payType;
}
