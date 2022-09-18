package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsHomeRecommendProductDOV1;
import com.liufei.mall.seed.service.SmsHomeRecommendProductServiceV1;

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
* @description SmsHomeRecommendProduct controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/home/recommend/product")
public class SmsHomeRecommendProductControllerV1 {

    @Resource
    private SmsHomeRecommendProductServiceV1 smsHomeRecommendProductServiceV1;

    @ApiOperation(value = "Create SmsHomeRecommendProduct", notes = "Create SmsHomeRecommendProduct")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsHomeRecommendProductDOV1 smsHomeRecommendProduct) {
        int row = smsHomeRecommendProductServiceV1.save(smsHomeRecommendProduct);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsHomeRecommendProduct", notes = "batchCreate SmsHomeRecommendProduct")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsHomeRecommendProductDOV1> smsHomeRecommendProducts) {
        int rows = smsHomeRecommendProductServiceV1.save(smsHomeRecommendProducts);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsHomeRecommendProduct", notes = "findById SmsHomeRecommendProduct")
    @GetMapping("/{id}")
    public Result<SmsHomeRecommendProductDOV1> findById(@PathVariable Integer id) {
        SmsHomeRecommendProductDOV1 smsHomeRecommendProduct = smsHomeRecommendProductServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsHomeRecommendProduct);
    }

    @ApiOperation(value = "findByIds SmsHomeRecommendProduct", notes = "findByIds SmsHomeRecommendProduct")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsHomeRecommendProductDOV1>> findByIds(@PathVariable String ids) {
        List<SmsHomeRecommendProductDOV1> smsHomeRecommendProducts = smsHomeRecommendProductServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsHomeRecommendProducts);
    }

    @ApiOperation(value = "findByField SmsHomeRecommendProduct", notes = "findByField SmsHomeRecommendProduct")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsHomeRecommendProductDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsHomeRecommendProductDOV1 smsHomeRecommendProduct = smsHomeRecommendProductServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsHomeRecommendProduct);
    }

    @ApiOperation(value = "findAll SmsHomeRecommendProduct", notes = "findAll SmsHomeRecommendProduct")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsHomeRecommendProductDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsHomeRecommendProductDOV1> list = smsHomeRecommendProductServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsHomeRecommendProduct", notes = "listByCondition SmsHomeRecommendProduct")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsHomeRecommendProductDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsHomeRecommendProductDOV1.class);
        List<SmsHomeRecommendProductDOV1> list = smsHomeRecommendProductServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsHomeRecommendProduct", notes = "update SmsHomeRecommendProduct")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsHomeRecommendProductDOV1 smsHomeRecommendProduct) {
        int row = smsHomeRecommendProductServiceV1.update(smsHomeRecommendProduct);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsHomeRecommendProduct", notes = "updateByCondition SmsHomeRecommendProduct")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsHomeRecommendProductDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsHomeRecommendProductDOV1.class);
        int rows = smsHomeRecommendProductServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsHomeRecommendProduct", notes = "delete SmsHomeRecommendProduct")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsHomeRecommendProductServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsHomeRecommendProduct", notes = "deleteByIds SmsHomeRecommendProduct")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsHomeRecommendProductServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsHomeRecommendProduct", notes = "deleteByCondition SmsHomeRecommendProduct")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsHomeRecommendProductDOV1.class);
        int rows = smsHomeRecommendProductServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsHomeRecommendProduct", notes = "count SmsHomeRecommendProduct")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsHomeRecommendProductDOV1.class);
        int count = smsHomeRecommendProductServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}