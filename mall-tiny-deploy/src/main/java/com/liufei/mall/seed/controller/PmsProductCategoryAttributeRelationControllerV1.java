package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsProductCategoryAttributeRelationDOV1;
import com.liufei.mall.seed.service.PmsProductCategoryAttributeRelationServiceV1;

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
* @description PmsProductCategoryAttributeRelation controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/product/category/attribute/relation")
public class PmsProductCategoryAttributeRelationControllerV1 {

    @Resource
    private PmsProductCategoryAttributeRelationServiceV1 pmsProductCategoryAttributeRelationServiceV1;

    @ApiOperation(value = "Create PmsProductCategoryAttributeRelation", notes = "Create PmsProductCategoryAttributeRelation")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsProductCategoryAttributeRelationDOV1 pmsProductCategoryAttributeRelation) {
        int row = pmsProductCategoryAttributeRelationServiceV1.save(pmsProductCategoryAttributeRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsProductCategoryAttributeRelation", notes = "batchCreate PmsProductCategoryAttributeRelation")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsProductCategoryAttributeRelationDOV1> pmsProductCategoryAttributeRelations) {
        int rows = pmsProductCategoryAttributeRelationServiceV1.save(pmsProductCategoryAttributeRelations);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsProductCategoryAttributeRelation", notes = "findById PmsProductCategoryAttributeRelation")
    @GetMapping("/{id}")
    public Result<PmsProductCategoryAttributeRelationDOV1> findById(@PathVariable Integer id) {
        PmsProductCategoryAttributeRelationDOV1 pmsProductCategoryAttributeRelation = pmsProductCategoryAttributeRelationServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsProductCategoryAttributeRelation);
    }

    @ApiOperation(value = "findByIds PmsProductCategoryAttributeRelation", notes = "findByIds PmsProductCategoryAttributeRelation")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsProductCategoryAttributeRelationDOV1>> findByIds(@PathVariable String ids) {
        List<PmsProductCategoryAttributeRelationDOV1> pmsProductCategoryAttributeRelations = pmsProductCategoryAttributeRelationServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsProductCategoryAttributeRelations);
    }

    @ApiOperation(value = "findByField PmsProductCategoryAttributeRelation", notes = "findByField PmsProductCategoryAttributeRelation")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsProductCategoryAttributeRelationDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsProductCategoryAttributeRelationDOV1 pmsProductCategoryAttributeRelation = pmsProductCategoryAttributeRelationServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsProductCategoryAttributeRelation);
    }

    @ApiOperation(value = "findAll PmsProductCategoryAttributeRelation", notes = "findAll PmsProductCategoryAttributeRelation")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsProductCategoryAttributeRelationDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsProductCategoryAttributeRelationDOV1> list = pmsProductCategoryAttributeRelationServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsProductCategoryAttributeRelation", notes = "listByCondition PmsProductCategoryAttributeRelation")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsProductCategoryAttributeRelationDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsProductCategoryAttributeRelationDOV1.class);
        List<PmsProductCategoryAttributeRelationDOV1> list = pmsProductCategoryAttributeRelationServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsProductCategoryAttributeRelation", notes = "update PmsProductCategoryAttributeRelation")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsProductCategoryAttributeRelationDOV1 pmsProductCategoryAttributeRelation) {
        int row = pmsProductCategoryAttributeRelationServiceV1.update(pmsProductCategoryAttributeRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsProductCategoryAttributeRelation", notes = "updateByCondition PmsProductCategoryAttributeRelation")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsProductCategoryAttributeRelationDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsProductCategoryAttributeRelationDOV1.class);
        int rows = pmsProductCategoryAttributeRelationServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsProductCategoryAttributeRelation", notes = "delete PmsProductCategoryAttributeRelation")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsProductCategoryAttributeRelationServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsProductCategoryAttributeRelation", notes = "deleteByIds PmsProductCategoryAttributeRelation")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsProductCategoryAttributeRelationServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsProductCategoryAttributeRelation", notes = "deleteByCondition PmsProductCategoryAttributeRelation")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductCategoryAttributeRelationDOV1.class);
        int rows = pmsProductCategoryAttributeRelationServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsProductCategoryAttributeRelation", notes = "count PmsProductCategoryAttributeRelation")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductCategoryAttributeRelationDOV1.class);
        int count = pmsProductCategoryAttributeRelationServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}