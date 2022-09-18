package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsCouponProductRelationDOV1;
import com.liufei.mall.seed.service.SmsCouponProductRelationServiceV1;

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
* @description SmsCouponProductRelation controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/coupon/product/relation")
public class SmsCouponProductRelationControllerV1 {

    @Resource
    private SmsCouponProductRelationServiceV1 smsCouponProductRelationServiceV1;

    @ApiOperation(value = "Create SmsCouponProductRelation", notes = "Create SmsCouponProductRelation")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsCouponProductRelationDOV1 smsCouponProductRelation) {
        int row = smsCouponProductRelationServiceV1.save(smsCouponProductRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsCouponProductRelation", notes = "batchCreate SmsCouponProductRelation")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsCouponProductRelationDOV1> smsCouponProductRelations) {
        int rows = smsCouponProductRelationServiceV1.save(smsCouponProductRelations);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsCouponProductRelation", notes = "findById SmsCouponProductRelation")
    @GetMapping("/{id}")
    public Result<SmsCouponProductRelationDOV1> findById(@PathVariable Integer id) {
        SmsCouponProductRelationDOV1 smsCouponProductRelation = smsCouponProductRelationServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsCouponProductRelation);
    }

    @ApiOperation(value = "findByIds SmsCouponProductRelation", notes = "findByIds SmsCouponProductRelation")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsCouponProductRelationDOV1>> findByIds(@PathVariable String ids) {
        List<SmsCouponProductRelationDOV1> smsCouponProductRelations = smsCouponProductRelationServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsCouponProductRelations);
    }

    @ApiOperation(value = "findByField SmsCouponProductRelation", notes = "findByField SmsCouponProductRelation")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsCouponProductRelationDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsCouponProductRelationDOV1 smsCouponProductRelation = smsCouponProductRelationServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsCouponProductRelation);
    }

    @ApiOperation(value = "findAll SmsCouponProductRelation", notes = "findAll SmsCouponProductRelation")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsCouponProductRelationDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsCouponProductRelationDOV1> list = smsCouponProductRelationServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsCouponProductRelation", notes = "listByCondition SmsCouponProductRelation")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsCouponProductRelationDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsCouponProductRelationDOV1.class);
        List<SmsCouponProductRelationDOV1> list = smsCouponProductRelationServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsCouponProductRelation", notes = "update SmsCouponProductRelation")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsCouponProductRelationDOV1 smsCouponProductRelation) {
        int row = smsCouponProductRelationServiceV1.update(smsCouponProductRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsCouponProductRelation", notes = "updateByCondition SmsCouponProductRelation")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsCouponProductRelationDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsCouponProductRelationDOV1.class);
        int rows = smsCouponProductRelationServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsCouponProductRelation", notes = "delete SmsCouponProductRelation")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsCouponProductRelationServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsCouponProductRelation", notes = "deleteByIds SmsCouponProductRelation")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsCouponProductRelationServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsCouponProductRelation", notes = "deleteByCondition SmsCouponProductRelation")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsCouponProductRelationDOV1.class);
        int rows = smsCouponProductRelationServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsCouponProductRelation", notes = "count SmsCouponProductRelation")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsCouponProductRelationDOV1.class);
        int count = smsCouponProductRelationServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}