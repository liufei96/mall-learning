package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsHomeAdvertiseDOV1;
import com.liufei.mall.seed.service.SmsHomeAdvertiseServiceV1;

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
* @description SmsHomeAdvertise controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/home/advertise")
public class SmsHomeAdvertiseControllerV1 {

    @Resource
    private SmsHomeAdvertiseServiceV1 smsHomeAdvertiseServiceV1;

    @ApiOperation(value = "Create SmsHomeAdvertise", notes = "Create SmsHomeAdvertise")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsHomeAdvertiseDOV1 smsHomeAdvertise) {
        int row = smsHomeAdvertiseServiceV1.save(smsHomeAdvertise);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsHomeAdvertise", notes = "batchCreate SmsHomeAdvertise")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsHomeAdvertiseDOV1> smsHomeAdvertises) {
        int rows = smsHomeAdvertiseServiceV1.save(smsHomeAdvertises);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsHomeAdvertise", notes = "findById SmsHomeAdvertise")
    @GetMapping("/{id}")
    public Result<SmsHomeAdvertiseDOV1> findById(@PathVariable Integer id) {
        SmsHomeAdvertiseDOV1 smsHomeAdvertise = smsHomeAdvertiseServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsHomeAdvertise);
    }

    @ApiOperation(value = "findByIds SmsHomeAdvertise", notes = "findByIds SmsHomeAdvertise")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsHomeAdvertiseDOV1>> findByIds(@PathVariable String ids) {
        List<SmsHomeAdvertiseDOV1> smsHomeAdvertises = smsHomeAdvertiseServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsHomeAdvertises);
    }

    @ApiOperation(value = "findByField SmsHomeAdvertise", notes = "findByField SmsHomeAdvertise")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsHomeAdvertiseDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsHomeAdvertiseDOV1 smsHomeAdvertise = smsHomeAdvertiseServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsHomeAdvertise);
    }

    @ApiOperation(value = "findAll SmsHomeAdvertise", notes = "findAll SmsHomeAdvertise")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsHomeAdvertiseDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsHomeAdvertiseDOV1> list = smsHomeAdvertiseServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsHomeAdvertise", notes = "listByCondition SmsHomeAdvertise")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsHomeAdvertiseDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsHomeAdvertiseDOV1.class);
        List<SmsHomeAdvertiseDOV1> list = smsHomeAdvertiseServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsHomeAdvertise", notes = "update SmsHomeAdvertise")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsHomeAdvertiseDOV1 smsHomeAdvertise) {
        int row = smsHomeAdvertiseServiceV1.update(smsHomeAdvertise);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsHomeAdvertise", notes = "updateByCondition SmsHomeAdvertise")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsHomeAdvertiseDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsHomeAdvertiseDOV1.class);
        int rows = smsHomeAdvertiseServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsHomeAdvertise", notes = "delete SmsHomeAdvertise")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsHomeAdvertiseServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsHomeAdvertise", notes = "deleteByIds SmsHomeAdvertise")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsHomeAdvertiseServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsHomeAdvertise", notes = "deleteByCondition SmsHomeAdvertise")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsHomeAdvertiseDOV1.class);
        int rows = smsHomeAdvertiseServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsHomeAdvertise", notes = "count SmsHomeAdvertise")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsHomeAdvertiseDOV1.class);
        int count = smsHomeAdvertiseServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}