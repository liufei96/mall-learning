package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsSkuStockDOV1;
import com.liufei.mall.seed.service.PmsSkuStockServiceV1;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

import java.util.List;

/**
* @author liufei
* @version 1.0.0
* @description PmsSkuStock controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/sku/stock")
public class PmsSkuStockControllerV1 {

    @Resource
    private PmsSkuStockServiceV1 pmsSkuStockServiceV1;

    @ApiOperation(value = "Create PmsSkuStock", notes = "Create PmsSkuStock")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsSkuStockDOV1 pmsSkuStock) {
        int row = pmsSkuStockServiceV1.save(pmsSkuStock);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsSkuStock", notes = "batchCreate PmsSkuStock")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsSkuStockDOV1> pmsSkuStocks) {
        int rows = pmsSkuStockServiceV1.save(pmsSkuStocks);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsSkuStock", notes = "findById PmsSkuStock")
    @GetMapping("/{id}")
    public Result<PmsSkuStockDOV1> findById(@PathVariable Integer id) {
        PmsSkuStockDOV1 pmsSkuStock = pmsSkuStockServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsSkuStock);
    }

    @ApiOperation(value = "findByIds PmsSkuStock", notes = "findByIds PmsSkuStock")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsSkuStockDOV1>> findByIds(@PathVariable String ids) {
        List<PmsSkuStockDOV1> pmsSkuStocks = pmsSkuStockServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsSkuStocks);
    }

    @ApiOperation(value = "findByField PmsSkuStock", notes = "findByField PmsSkuStock")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsSkuStockDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsSkuStockDOV1 pmsSkuStock = pmsSkuStockServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsSkuStock);
    }

    @ApiOperation(value = "findAll PmsSkuStock", notes = "findAll PmsSkuStock")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsSkuStockDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsSkuStockDOV1> list = pmsSkuStockServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsSkuStock", notes = "listByCondition PmsSkuStock")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsSkuStockDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsSkuStockDOV1.class);
        List<PmsSkuStockDOV1> list = pmsSkuStockServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsSkuStock", notes = "update PmsSkuStock")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsSkuStockDOV1 pmsSkuStock) {
        int row = pmsSkuStockServiceV1.update(pmsSkuStock);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsSkuStock", notes = "updateByCondition PmsSkuStock")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsSkuStockDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsSkuStockDOV1.class);
        int rows = pmsSkuStockServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsSkuStock", notes = "delete PmsSkuStock")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsSkuStockServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsSkuStock", notes = "deleteByIds PmsSkuStock")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsSkuStockServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsSkuStock", notes = "deleteByCondition PmsSkuStock")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsSkuStockDOV1.class);
        int rows = pmsSkuStockServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsSkuStock", notes = "count PmsSkuStock")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsSkuStockDOV1.class);
        int count = pmsSkuStockServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}