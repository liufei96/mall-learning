package com.liufei.mall.tiny.controller;

import com.github.pagehelper.PageInfo;
import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.tiny.model.EsProductRelatedInfo;
import com.liufei.mall.tiny.nosql.elasticsearch.document.EsProduct;
import com.liufei.mall.tiny.service.EsProductService;
import com.liufei.mall.tiny.utils.PageInfoUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 搜索商品管理Controller
 * @date 2022/9/20
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

    @ApiOperation(value = "根据id删除商品")
    @DeleteMapping(value = "/delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        int row = esProductService.delete(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "根据id批量删除商品")
    @DeleteMapping(value = "/delete/batch")
    @ResponseBody
    public Result<Integer> delete(@RequestParam("ids") List<Long> ids) {
        int rows = esProductService.delete(ids);
        return ResultGenerator.genSuccessResult(rows);
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

    @ApiOperation(value = "综合搜索、筛选、排序")
    @ApiImplicitParam(name = "sort", value = "排序字段:0->按相关度；1->按新品；2->按销量；3->价格从低到高；4->价格从高到低",
            defaultValue = "0", allowableValues = "0,1,2,3,4", paramType = "query", dataType = "integer")
    @GetMapping(value = "/search")
    public Result<PageInfo<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false) Long brandId,
                                                      @RequestParam(required = false) Long productCategoryId,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                                                      @RequestParam(required = false, defaultValue = "0") Integer sort) {
        Page<EsProduct> esProductPage = esProductService.search(keyword, brandId, productCategoryId, pageNum, pageSize, sort);
        return ResultGenerator.genSuccessResult(PageInfoUtils.restPage(esProductPage));
    }

    @ApiOperation(value = "根据商品id推荐商品")
    @GetMapping(value = "/recommend/{id}")
    public Result<PageInfo<EsProduct>> recommend(@PathVariable Long id,
                                                         @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                         @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.recommend(id, pageNum, pageSize);
        return ResultGenerator.genSuccessResult(PageInfoUtils.restPage(esProductPage));
    }

    @ApiOperation(value = "获取搜索的相关品牌、分类及筛选属性")
    @GetMapping(value = "/search/relate")
    public Result<EsProductRelatedInfo> searchRelatedInfo(@RequestParam(required = false) String keyword) {
        EsProductRelatedInfo productRelatedInfo = esProductService.searchRelatedInfo(keyword);
        return ResultGenerator.genSuccessResult(productRelatedInfo);
    }

}
