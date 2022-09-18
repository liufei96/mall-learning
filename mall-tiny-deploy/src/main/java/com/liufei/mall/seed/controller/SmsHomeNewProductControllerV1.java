package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsHomeNewProductDOV1;
import com.liufei.mall.seed.service.SmsHomeNewProductServiceV1;

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
* @description SmsHomeNewProduct controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/home/new/product")
public class SmsHomeNewProductControllerV1 {

    @Resource
    private SmsHomeNewProductServiceV1 smsHomeNewProductServiceV1;

    @ApiOperation(value = "Create SmsHomeNewProduct", notes = "Create SmsHomeNewProduct")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsHomeNewProductDOV1 smsHomeNewProduct) {
        int row = smsHomeNewProductServiceV1.save(smsHomeNewProduct);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsHomeNewProduct", notes = "batchCreate SmsHomeNewProduct")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsHomeNewProductDOV1> smsHomeNewProducts) {
        int rows = smsHomeNewProductServiceV1.save(smsHomeNewProducts);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsHomeNewProduct", notes = "findById SmsHomeNewProduct")
    @GetMapping("/{id}")
    public Result<SmsHomeNewProductDOV1> findById(@PathVariable Integer id) {
        SmsHomeNewProductDOV1 smsHomeNewProduct = smsHomeNewProductServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsHomeNewProduct);
    }

    @ApiOperation(value = "findByIds SmsHomeNewProduct", notes = "findByIds SmsHomeNewProduct")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsHomeNewProductDOV1>> findByIds(@PathVariable String ids) {
        List<SmsHomeNewProductDOV1> smsHomeNewProducts = smsHomeNewProductServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsHomeNewProducts);
    }

    @ApiOperation(value = "findByField SmsHomeNewProduct", notes = "findByField SmsHomeNewProduct")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsHomeNewProductDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsHomeNewProductDOV1 smsHomeNewProduct = smsHomeNewProductServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsHomeNewProduct);
    }

    @ApiOperation(value = "findAll SmsHomeNewProduct", notes = "findAll SmsHomeNewProduct")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsHomeNewProductDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsHomeNewProductDOV1> list = smsHomeNewProductServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsHomeNewProduct", notes = "listByCondition SmsHomeNewProduct")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsHomeNewProductDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsHomeNewProductDOV1.class);
        List<SmsHomeNewProductDOV1> list = smsHomeNewProductServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsHomeNewProduct", notes = "update SmsHomeNewProduct")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsHomeNewProductDOV1 smsHomeNewProduct) {
        int row = smsHomeNewProductServiceV1.update(smsHomeNewProduct);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsHomeNewProduct", notes = "updateByCondition SmsHomeNewProduct")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsHomeNewProductDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsHomeNewProductDOV1.class);
        int rows = smsHomeNewProductServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsHomeNewProduct", notes = "delete SmsHomeNewProduct")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsHomeNewProductServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsHomeNewProduct", notes = "deleteByIds SmsHomeNewProduct")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsHomeNewProductServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsHomeNewProduct", notes = "deleteByCondition SmsHomeNewProduct")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsHomeNewProductDOV1.class);
        int rows = smsHomeNewProductServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsHomeNewProduct", notes = "count SmsHomeNewProduct")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsHomeNewProductDOV1.class);
        int count = smsHomeNewProductServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}