package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsProductCategoryDOV1;
import com.liufei.mall.seed.service.PmsProductCategoryServiceV1;

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
* @description PmsProductCategory controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/product/category")
public class PmsProductCategoryControllerV1 {

    @Resource
    private PmsProductCategoryServiceV1 pmsProductCategoryServiceV1;

    @ApiOperation(value = "Create PmsProductCategory", notes = "Create PmsProductCategory")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsProductCategoryDOV1 pmsProductCategory) {
        int row = pmsProductCategoryServiceV1.save(pmsProductCategory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsProductCategory", notes = "batchCreate PmsProductCategory")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsProductCategoryDOV1> pmsProductCategorys) {
        int rows = pmsProductCategoryServiceV1.save(pmsProductCategorys);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsProductCategory", notes = "findById PmsProductCategory")
    @GetMapping("/{id}")
    public Result<PmsProductCategoryDOV1> findById(@PathVariable Integer id) {
        PmsProductCategoryDOV1 pmsProductCategory = pmsProductCategoryServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsProductCategory);
    }

    @ApiOperation(value = "findByIds PmsProductCategory", notes = "findByIds PmsProductCategory")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsProductCategoryDOV1>> findByIds(@PathVariable String ids) {
        List<PmsProductCategoryDOV1> pmsProductCategorys = pmsProductCategoryServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsProductCategorys);
    }

    @ApiOperation(value = "findByField PmsProductCategory", notes = "findByField PmsProductCategory")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsProductCategoryDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsProductCategoryDOV1 pmsProductCategory = pmsProductCategoryServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsProductCategory);
    }

    @ApiOperation(value = "findAll PmsProductCategory", notes = "findAll PmsProductCategory")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsProductCategoryDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsProductCategoryDOV1> list = pmsProductCategoryServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsProductCategory", notes = "listByCondition PmsProductCategory")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsProductCategoryDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsProductCategoryDOV1.class);
        List<PmsProductCategoryDOV1> list = pmsProductCategoryServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsProductCategory", notes = "update PmsProductCategory")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsProductCategoryDOV1 pmsProductCategory) {
        int row = pmsProductCategoryServiceV1.update(pmsProductCategory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsProductCategory", notes = "updateByCondition PmsProductCategory")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsProductCategoryDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsProductCategoryDOV1.class);
        int rows = pmsProductCategoryServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsProductCategory", notes = "delete PmsProductCategory")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsProductCategoryServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsProductCategory", notes = "deleteByIds PmsProductCategory")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsProductCategoryServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsProductCategory", notes = "deleteByCondition PmsProductCategory")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductCategoryDOV1.class);
        int rows = pmsProductCategoryServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsProductCategory", notes = "count PmsProductCategory")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductCategoryDOV1.class);
        int count = pmsProductCategoryServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}