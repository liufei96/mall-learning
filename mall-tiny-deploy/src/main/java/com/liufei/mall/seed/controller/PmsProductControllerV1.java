package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsProductDOV1;
import com.liufei.mall.seed.service.PmsProductServiceV1;

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
* @description PmsProduct controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/product")
public class PmsProductControllerV1 {

    @Resource
    private PmsProductServiceV1 pmsProductServiceV1;

    @ApiOperation(value = "Create PmsProduct", notes = "Create PmsProduct")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsProductDOV1 pmsProduct) {
        int row = pmsProductServiceV1.save(pmsProduct);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsProduct", notes = "batchCreate PmsProduct")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsProductDOV1> pmsProducts) {
        int rows = pmsProductServiceV1.save(pmsProducts);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsProduct", notes = "findById PmsProduct")
    @GetMapping("/{id}")
    public Result<PmsProductDOV1> findById(@PathVariable Integer id) {
        PmsProductDOV1 pmsProduct = pmsProductServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsProduct);
    }

    @ApiOperation(value = "findByIds PmsProduct", notes = "findByIds PmsProduct")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsProductDOV1>> findByIds(@PathVariable String ids) {
        List<PmsProductDOV1> pmsProducts = pmsProductServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsProducts);
    }

    @ApiOperation(value = "findByField PmsProduct", notes = "findByField PmsProduct")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsProductDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsProductDOV1 pmsProduct = pmsProductServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsProduct);
    }

    @ApiOperation(value = "findAll PmsProduct", notes = "findAll PmsProduct")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsProductDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsProductDOV1> list = pmsProductServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsProduct", notes = "listByCondition PmsProduct")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsProductDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsProductDOV1.class);
        List<PmsProductDOV1> list = pmsProductServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsProduct", notes = "update PmsProduct")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsProductDOV1 pmsProduct) {
        int row = pmsProductServiceV1.update(pmsProduct);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsProduct", notes = "updateByCondition PmsProduct")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsProductDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsProductDOV1.class);
        int rows = pmsProductServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsProduct", notes = "delete PmsProduct")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsProductServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsProduct", notes = "deleteByIds PmsProduct")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsProductServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsProduct", notes = "deleteByCondition PmsProduct")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductDOV1.class);
        int rows = pmsProductServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsProduct", notes = "count PmsProduct")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductDOV1.class);
        int count = pmsProductServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}