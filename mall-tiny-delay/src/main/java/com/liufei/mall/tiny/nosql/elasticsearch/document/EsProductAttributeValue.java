package com.liufei.mall.tiny.nosql.elasticsearch.document;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author liufei
 * @version 1.0.0
 * @description 搜索中的商品属性信息
 * @date 2022/9/12
 */
@Data
public class EsProductAttributeValue {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long productAttributeId;

    //属性值
    @Field(type = FieldType.Keyword)
    private String value;

    //属性参数：0->规格；1->参数
    private Integer type;
    //属性名称

    @Field(type=FieldType.Keyword)
    private String name;

}
