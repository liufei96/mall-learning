package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsHomeBrandDOV1;
import com.liufei.mall.seed.service.SmsHomeBrandServiceV1;

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
* @description SmsHomeBrand controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/home/brand")
public class SmsHomeBrandControllerV1 {

    @Resource
    private SmsHomeBrandServiceV1 smsHomeBrandServiceV1;

    @ApiOperation(value = "Create SmsHomeBrand", notes = "Create SmsHomeBrand")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsHomeBrandDOV1 smsHomeBrand) {
        int row = smsHomeBrandServiceV1.save(smsHomeBrand);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsHomeBrand", notes = "batchCreate SmsHomeBrand")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsHomeBrandDOV1> smsHomeBrands) {
        int rows = smsHomeBrandServiceV1.save(smsHomeBrands);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsHomeBrand", notes = "findById SmsHomeBrand")
    @GetMapping("/{id}")
    public Result<SmsHomeBrandDOV1> findById(@PathVariable Integer id) {
        SmsHomeBrandDOV1 smsHomeBrand = smsHomeBrandServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsHomeBrand);
    }

    @ApiOperation(value = "findByIds SmsHomeBrand", notes = "findByIds SmsHomeBrand")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsHomeBrandDOV1>> findByIds(@PathVariable String ids) {
        List<SmsHomeBrandDOV1> smsHomeBrands = smsHomeBrandServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsHomeBrands);
    }

    @ApiOperation(value = "findByField SmsHomeBrand", notes = "findByField SmsHomeBrand")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsHomeBrandDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsHomeBrandDOV1 smsHomeBrand = smsHomeBrandServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsHomeBrand);
    }

    @ApiOperation(value = "findAll SmsHomeBrand", notes = "findAll SmsHomeBrand")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsHomeBrandDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsHomeBrandDOV1> list = smsHomeBrandServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsHomeBrand", notes = "listByCondition SmsHomeBrand")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsHomeBrandDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsHomeBrandDOV1.class);
        List<SmsHomeBrandDOV1> list = smsHomeBrandServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsHomeBrand", notes = "update SmsHomeBrand")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsHomeBrandDOV1 smsHomeBrand) {
        int row = smsHomeBrandServiceV1.update(smsHomeBrand);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsHomeBrand", notes = "updateByCondition SmsHomeBrand")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsHomeBrandDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsHomeBrandDOV1.class);
        int rows = smsHomeBrandServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsHomeBrand", notes = "delete SmsHomeBrand")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsHomeBrandServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsHomeBrand", notes = "deleteByIds SmsHomeBrand")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsHomeBrandServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsHomeBrand", notes = "deleteByCondition SmsHomeBrand")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsHomeBrandDOV1.class);
        int rows = smsHomeBrandServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsHomeBrand", notes = "count SmsHomeBrand")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsHomeBrandDOV1.class);
        int count = smsHomeBrandServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}