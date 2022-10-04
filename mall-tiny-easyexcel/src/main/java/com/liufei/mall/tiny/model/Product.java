package com.liufei.mall.tiny.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/10/4
 */
@Data
@EqualsAndHashCode(callSuper = false) // 生成equals和hashCode方法，如果callSuper为false,则不会涉及父类的属性
public class Product {

    private Long id;

    private String productSn;

    private String name;

    private String subTitle;

    private String brandName;

    private BigDecimal price;

    private Integer count;

}
