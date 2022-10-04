package com.liufei.mall.tiny.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 订单
 * @date 2022/10/4
 */
@Data
@EqualsAndHashCode(callSuper = false) // 生成equals和hashCode方法，如果callSuper为false,则不会涉及父类的属性
public class Order {

    private Long id;

    private String orderSn;

    private Date createTime;

    private String receiverAddress;

    private Member member;

    private List<Product> productList;
}
