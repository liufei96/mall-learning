package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsCouponDOV1;
import com.liufei.mall.seed.service.SmsCouponServiceV1;

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
* @description SmsCoupon controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/coupon")
public class SmsCouponControllerV1 {

    @Resource
    private SmsCouponServiceV1 smsCouponServiceV1;

    @ApiOperation(value = "Create SmsCoupon", notes = "Create SmsCoupon")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsCouponDOV1 smsCoupon) {
        int row = smsCouponServiceV1.save(smsCoupon);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsCoupon", notes = "batchCreate SmsCoupon")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsCouponDOV1> smsCoupons) {
        int rows = smsCouponServiceV1.save(smsCoupons);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsCoupon", notes = "findById SmsCoupon")
    @GetMapping("/{id}")
    public Result<SmsCouponDOV1> findById(@PathVariable Integer id) {
        SmsCouponDOV1 smsCoupon = smsCouponServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsCoupon);
    }

    @ApiOperation(value = "findByIds SmsCoupon", notes = "findByIds SmsCoupon")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsCouponDOV1>> findByIds(@PathVariable String ids) {
        List<SmsCouponDOV1> smsCoupons = smsCouponServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsCoupons);
    }

    @ApiOperation(value = "findByField SmsCoupon", notes = "findByField SmsCoupon")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsCouponDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsCouponDOV1 smsCoupon = smsCouponServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsCoupon);
    }

    @ApiOperation(value = "findAll SmsCoupon", notes = "findAll SmsCoupon")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsCouponDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsCouponDOV1> list = smsCouponServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsCoupon", notes = "listByCondition SmsCoupon")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsCouponDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsCouponDOV1.class);
        List<SmsCouponDOV1> list = smsCouponServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsCoupon", notes = "update SmsCoupon")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsCouponDOV1 smsCoupon) {
        int row = smsCouponServiceV1.update(smsCoupon);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsCoupon", notes = "updateByCondition SmsCoupon")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsCouponDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsCouponDOV1.class);
        int rows = smsCouponServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsCoupon", notes = "delete SmsCoupon")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsCouponServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsCoupon", notes = "deleteByIds SmsCoupon")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsCouponServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsCoupon", notes = "deleteByCondition SmsCoupon")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsCouponDOV1.class);
        int rows = smsCouponServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsCoupon", notes = "count SmsCoupon")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsCouponDOV1.class);
        int count = smsCouponServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}