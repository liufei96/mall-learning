package com.liufei.mall.tiny.model;

import lombok.Data;

import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 搜索相关商品品牌名称，分类名称及属性
 * @date 2022/9/20
 */
@Data
public class EsProductRelatedInfo {

    private List<String> brandNames;

    private List<String> productCategoryNames;

    private List<ProductAttr> productAttrs;

    @Data
    public static class ProductAttr {
        private Long attrId;
        private String attrName;
        private List<String> attrValues;
    }
}
