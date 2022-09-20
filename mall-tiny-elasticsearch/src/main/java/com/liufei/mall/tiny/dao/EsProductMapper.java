package com.liufei.mall.tiny.dao;

import com.liufei.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 搜索系统中的商品管理自定义Dao
 * @date 2022/9/20
 */
public interface EsProductMapper {

    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
