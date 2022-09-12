package com.liufei.mall.tiny.controller;

import com.github.pagehelper.PageInfo;
import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.tiny.nosql.elasticsearch.document.EsProduct;
import com.liufei.mall.tiny.service.EsProductService;
import com.liufei.mall.tiny.utils.PageInfoUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 搜索商品管理Controller
 * @date 2022/9/12
 */
@RestController
@RequestMapping("/esProduct")
public class EsProductController {

    @Resource
    private EsProductService esProductService;

    @ApiOperation(value = "导入所有数据库中商品到ES")
    @PostMapping(value = "/importAll")
    public Result<Integer> importAllList() {
        int count = esProductService.importAll();
        return ResultGenerator.genSuccessResult(count);
    }

    @ApiOperation(value = "根据id批量删除商品")
    @DeleteMapping(value = "/delete/batch")
    public Result<Object> delete(@RequestParam("ids") List<Long> ids) {
        esProductService.delete(ids);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id创建商品")
    @PostMapping(value = "/create/{id}")
    public Result<EsProduct> create(@PathVariable Long id) {
        EsProduct esProduct = esProductService.create(id);
        if (esProduct != null) {
            return ResultGenerator.genSuccessResult(esProduct);
        } else {
            return ResultGenerator.genFailResult("创建商品失败，商品id=" + id);
        }
    }

    @ApiOperation(value = "简单搜索")
    @GetMapping(value = "/search/simple")
    public Result<PageInfo<EsProduct>> search(@RequestParam(required = false) String keyword,
                                              @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                              @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);
        return ResultGenerator.genSuccessResult(PageInfoUtils.restPage(esProductPage));
    }
}
