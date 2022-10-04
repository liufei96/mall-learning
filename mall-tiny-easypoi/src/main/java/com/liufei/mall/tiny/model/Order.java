package com.liufei.mall.tiny.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
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

    @Excel(name = "ID", width = 10, needMerge = true)
    private Long id;

    @Excel(name = "订单号", width = 20, needMerge = true)
    private String orderSn;

    @Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss", needMerge = true)
    private Date createTime;

    @Excel(name = "收货地址", width = 20, needMerge = true)
    private String receiverAddress;

    @ExcelEntity(name = "会员信息")
    private Member member;

    @ExcelCollection(name = "商品列表")
    private List<Product> productList;

}
