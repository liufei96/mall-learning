package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsProductAttributeCategoryDOV1;
import com.liufei.mall.seed.service.PmsProductAttributeCategoryServiceV1;

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
* @description PmsProductAttributeCategory controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/product/attribute/category")
public class PmsProductAttributeCategoryControllerV1 {

    @Resource
    private PmsProductAttributeCategoryServiceV1 pmsProductAttributeCategoryServiceV1;

    @ApiOperation(value = "Create PmsProductAttributeCategory", notes = "Create PmsProductAttributeCategory")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsProductAttributeCategoryDOV1 pmsProductAttributeCategory) {
        int row = pmsProductAttributeCategoryServiceV1.save(pmsProductAttributeCategory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsProductAttributeCategory", notes = "batchCreate PmsProductAttributeCategory")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsProductAttributeCategoryDOV1> pmsProductAttributeCategorys) {
        int rows = pmsProductAttributeCategoryServiceV1.save(pmsProductAttributeCategorys);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsProductAttributeCategory", notes = "findById PmsProductAttributeCategory")
    @GetMapping("/{id}")
    public Result<PmsProductAttributeCategoryDOV1> findById(@PathVariable Integer id) {
        PmsProductAttributeCategoryDOV1 pmsProductAttributeCategory = pmsProductAttributeCategoryServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsProductAttributeCategory);
    }

    @ApiOperation(value = "findByIds PmsProductAttributeCategory", notes = "findByIds PmsProductAttributeCategory")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsProductAttributeCategoryDOV1>> findByIds(@PathVariable String ids) {
        List<PmsProductAttributeCategoryDOV1> pmsProductAttributeCategorys = pmsProductAttributeCategoryServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsProductAttributeCategorys);
    }

    @ApiOperation(value = "findByField PmsProductAttributeCategory", notes = "findByField PmsProductAttributeCategory")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsProductAttributeCategoryDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsProductAttributeCategoryDOV1 pmsProductAttributeCategory = pmsProductAttributeCategoryServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsProductAttributeCategory);
    }

    @ApiOperation(value = "findAll PmsProductAttributeCategory", notes = "findAll PmsProductAttributeCategory")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsProductAttributeCategoryDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsProductAttributeCategoryDOV1> list = pmsProductAttributeCategoryServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsProductAttributeCategory", notes = "listByCondition PmsProductAttributeCategory")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsProductAttributeCategoryDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsProductAttributeCategoryDOV1.class);
        List<PmsProductAttributeCategoryDOV1> list = pmsProductAttributeCategoryServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsProductAttributeCategory", notes = "update PmsProductAttributeCategory")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsProductAttributeCategoryDOV1 pmsProductAttributeCategory) {
        int row = pmsProductAttributeCategoryServiceV1.update(pmsProductAttributeCategory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsProductAttributeCategory", notes = "updateByCondition PmsProductAttributeCategory")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsProductAttributeCategoryDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsProductAttributeCategoryDOV1.class);
        int rows = pmsProductAttributeCategoryServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsProductAttributeCategory", notes = "delete PmsProductAttributeCategory")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsProductAttributeCategoryServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsProductAttributeCategory", notes = "deleteByIds PmsProductAttributeCategory")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsProductAttributeCategoryServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsProductAttributeCategory", notes = "deleteByCondition PmsProductAttributeCategory")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductAttributeCategoryDOV1.class);
        int rows = pmsProductAttributeCategoryServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsProductAttributeCategory", notes = "count PmsProductAttributeCategory")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductAttributeCategoryDOV1.class);
        int count = pmsProductAttributeCategoryServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}