package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsCouponProductCategoryRelationDOV1;
import com.liufei.mall.seed.service.SmsCouponProductCategoryRelationServiceV1;

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
* @description SmsCouponProductCategoryRelation controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/coupon/product/category/relation")
public class SmsCouponProductCategoryRelationControllerV1 {

    @Resource
    private SmsCouponProductCategoryRelationServiceV1 smsCouponProductCategoryRelationServiceV1;

    @ApiOperation(value = "Create SmsCouponProductCategoryRelation", notes = "Create SmsCouponProductCategoryRelation")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsCouponProductCategoryRelationDOV1 smsCouponProductCategoryRelation) {
        int row = smsCouponProductCategoryRelationServiceV1.save(smsCouponProductCategoryRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsCouponProductCategoryRelation", notes = "batchCreate SmsCouponProductCategoryRelation")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsCouponProductCategoryRelationDOV1> smsCouponProductCategoryRelations) {
        int rows = smsCouponProductCategoryRelationServiceV1.save(smsCouponProductCategoryRelations);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsCouponProductCategoryRelation", notes = "findById SmsCouponProductCategoryRelation")
    @GetMapping("/{id}")
    public Result<SmsCouponProductCategoryRelationDOV1> findById(@PathVariable Integer id) {
        SmsCouponProductCategoryRelationDOV1 smsCouponProductCategoryRelation = smsCouponProductCategoryRelationServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsCouponProductCategoryRelation);
    }

    @ApiOperation(value = "findByIds SmsCouponProductCategoryRelation", notes = "findByIds SmsCouponProductCategoryRelation")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsCouponProductCategoryRelationDOV1>> findByIds(@PathVariable String ids) {
        List<SmsCouponProductCategoryRelationDOV1> smsCouponProductCategoryRelations = smsCouponProductCategoryRelationServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsCouponProductCategoryRelations);
    }

    @ApiOperation(value = "findByField SmsCouponProductCategoryRelation", notes = "findByField SmsCouponProductCategoryRelation")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsCouponProductCategoryRelationDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsCouponProductCategoryRelationDOV1 smsCouponProductCategoryRelation = smsCouponProductCategoryRelationServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsCouponProductCategoryRelation);
    }

    @ApiOperation(value = "findAll SmsCouponProductCategoryRelation", notes = "findAll SmsCouponProductCategoryRelation")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsCouponProductCategoryRelationDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsCouponProductCategoryRelationDOV1> list = smsCouponProductCategoryRelationServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsCouponProductCategoryRelation", notes = "listByCondition SmsCouponProductCategoryRelation")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsCouponProductCategoryRelationDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsCouponProductCategoryRelationDOV1.class);
        List<SmsCouponProductCategoryRelationDOV1> list = smsCouponProductCategoryRelationServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsCouponProductCategoryRelation", notes = "update SmsCouponProductCategoryRelation")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsCouponProductCategoryRelationDOV1 smsCouponProductCategoryRelation) {
        int row = smsCouponProductCategoryRelationServiceV1.update(smsCouponProductCategoryRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsCouponProductCategoryRelation", notes = "updateByCondition SmsCouponProductCategoryRelation")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsCouponProductCategoryRelationDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsCouponProductCategoryRelationDOV1.class);
        int rows = smsCouponProductCategoryRelationServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsCouponProductCategoryRelation", notes = "delete SmsCouponProductCategoryRelation")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsCouponProductCategoryRelationServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsCouponProductCategoryRelation", notes = "deleteByIds SmsCouponProductCategoryRelation")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsCouponProductCategoryRelationServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsCouponProductCategoryRelation", notes = "deleteByCondition SmsCouponProductCategoryRelation")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsCouponProductCategoryRelationDOV1.class);
        int rows = smsCouponProductCategoryRelationServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsCouponProductCategoryRelation", notes = "count SmsCouponProductCategoryRelation")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsCouponProductCategoryRelationDOV1.class);
        int count = smsCouponProductCategoryRelationServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}