package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsMemberProductCategoryRelationDOV1;
import com.liufei.mall.seed.service.UmsMemberProductCategoryRelationServiceV1;

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
* @description UmsMemberProductCategoryRelation controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/member/product/category/relation")
public class UmsMemberProductCategoryRelationControllerV1 {

    @Resource
    private UmsMemberProductCategoryRelationServiceV1 umsMemberProductCategoryRelationServiceV1;

    @ApiOperation(value = "Create UmsMemberProductCategoryRelation", notes = "Create UmsMemberProductCategoryRelation")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsMemberProductCategoryRelationDOV1 umsMemberProductCategoryRelation) {
        int row = umsMemberProductCategoryRelationServiceV1.save(umsMemberProductCategoryRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsMemberProductCategoryRelation", notes = "batchCreate UmsMemberProductCategoryRelation")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsMemberProductCategoryRelationDOV1> umsMemberProductCategoryRelations) {
        int rows = umsMemberProductCategoryRelationServiceV1.save(umsMemberProductCategoryRelations);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsMemberProductCategoryRelation", notes = "findById UmsMemberProductCategoryRelation")
    @GetMapping("/{id}")
    public Result<UmsMemberProductCategoryRelationDOV1> findById(@PathVariable Integer id) {
        UmsMemberProductCategoryRelationDOV1 umsMemberProductCategoryRelation = umsMemberProductCategoryRelationServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsMemberProductCategoryRelation);
    }

    @ApiOperation(value = "findByIds UmsMemberProductCategoryRelation", notes = "findByIds UmsMemberProductCategoryRelation")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsMemberProductCategoryRelationDOV1>> findByIds(@PathVariable String ids) {
        List<UmsMemberProductCategoryRelationDOV1> umsMemberProductCategoryRelations = umsMemberProductCategoryRelationServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsMemberProductCategoryRelations);
    }

    @ApiOperation(value = "findByField UmsMemberProductCategoryRelation", notes = "findByField UmsMemberProductCategoryRelation")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsMemberProductCategoryRelationDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsMemberProductCategoryRelationDOV1 umsMemberProductCategoryRelation = umsMemberProductCategoryRelationServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsMemberProductCategoryRelation);
    }

    @ApiOperation(value = "findAll UmsMemberProductCategoryRelation", notes = "findAll UmsMemberProductCategoryRelation")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsMemberProductCategoryRelationDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsMemberProductCategoryRelationDOV1> list = umsMemberProductCategoryRelationServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsMemberProductCategoryRelation", notes = "listByCondition UmsMemberProductCategoryRelation")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsMemberProductCategoryRelationDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsMemberProductCategoryRelationDOV1.class);
        List<UmsMemberProductCategoryRelationDOV1> list = umsMemberProductCategoryRelationServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsMemberProductCategoryRelation", notes = "update UmsMemberProductCategoryRelation")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsMemberProductCategoryRelationDOV1 umsMemberProductCategoryRelation) {
        int row = umsMemberProductCategoryRelationServiceV1.update(umsMemberProductCategoryRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsMemberProductCategoryRelation", notes = "updateByCondition UmsMemberProductCategoryRelation")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsMemberProductCategoryRelationDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsMemberProductCategoryRelationDOV1.class);
        int rows = umsMemberProductCategoryRelationServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsMemberProductCategoryRelation", notes = "delete UmsMemberProductCategoryRelation")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsMemberProductCategoryRelationServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsMemberProductCategoryRelation", notes = "deleteByIds UmsMemberProductCategoryRelation")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsMemberProductCategoryRelationServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsMemberProductCategoryRelation", notes = "deleteByCondition UmsMemberProductCategoryRelation")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberProductCategoryRelationDOV1.class);
        int rows = umsMemberProductCategoryRelationServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsMemberProductCategoryRelation", notes = "count UmsMemberProductCategoryRelation")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberProductCategoryRelationDOV1.class);
        int count = umsMemberProductCategoryRelationServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}