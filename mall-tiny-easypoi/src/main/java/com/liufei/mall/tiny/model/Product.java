package com.liufei.mall.tiny.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author liufei
 * @version 1.0.0
 * @description 商品
 * @date 2022/10/4
 */
@Data
@EqualsAndHashCode(callSuper = false) // 生成equals和hashCode方法，如果callSuper为false,则不会涉及父类的属性
public class Product {

    @Excel(name = "ID", width = 10)
    private Long id;

    @Excel(name = "商品SN", width = 20)
    private String productSn;

    @Excel(name = "商品名称", width = 20)
    private String name;

    @Excel(name = "商品副标题", width = 30)
    private String subTitle;

    @Excel(name = "品牌名称", width = 20)
    private String brandName;

    @Excel(name = "商品价格", width = 10)
    private BigDecimal price;

    @Excel(name = "购买数量", width = 10, suffix = "件")
    private Integer count;

}
