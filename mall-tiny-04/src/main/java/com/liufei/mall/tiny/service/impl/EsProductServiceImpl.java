package com.liufei.mall.tiny.service.impl;

import com.liufei.mall.tiny.dao.EsProductMapper;
import com.liufei.mall.tiny.nosql.elasticsearch.document.EsProduct;
import com.liufei.mall.tiny.nosql.elasticsearch.repository.EsProductRepository;
import com.liufei.mall.tiny.service.EsProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 商品搜索管理Service实现类
 * @date 2022/9/12
 */
@Service
public class EsProductServiceImpl implements EsProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EsProductServiceImpl.class);

    @Resource
    private EsProductMapper productMapper;

    @Resource
    private EsProductRepository productRepository;

    @Override
    public int importAll() {
        List<EsProduct> esProductList = productMapper.getAllEsProductList(null);
        Iterable<EsProduct> esProductIterable = productRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> esProductList = productMapper.getAllEsProductList(id);
        if (!esProductList.isEmpty()) {
            EsProduct esProduct = esProductList.get(0);
            result = productRepository.save(esProduct);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        List<EsProduct> esProductList = new ArrayList<>();
        for (Long id : ids) {
            EsProduct esProduct = new EsProduct();
            esProduct.setId(id);
            esProductList.add(esProduct);
        }
        productRepository.deleteAll(esProductList);
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return productRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, pageable);
    }
}
