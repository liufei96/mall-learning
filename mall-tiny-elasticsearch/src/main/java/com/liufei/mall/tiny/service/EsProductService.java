package com.liufei.mall.tiny.service;

import com.liufei.mall.tiny.model.EsProductRelatedInfo;
import com.liufei.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/20
 */
public interface EsProductService {

    int importAll();

    int delete(Long id);

    int delete(List<Long> ids);

    EsProduct create(Long id);

    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

    Page<EsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

    Page<EsProduct> recommend(Long id, Integer pageNum, Integer pageSize);

    EsProductRelatedInfo searchRelatedInfo(String keyword);
}
