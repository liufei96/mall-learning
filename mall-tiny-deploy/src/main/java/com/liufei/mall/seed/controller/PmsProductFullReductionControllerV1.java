package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsProductFullReductionDOV1;
import com.liufei.mall.seed.service.PmsProductFullReductionServiceV1;

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
* @description PmsProductFullReduction controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/product/full/reduction")
public class PmsProductFullReductionControllerV1 {

    @Resource
    private PmsProductFullReductionServiceV1 pmsProductFullReductionServiceV1;

    @ApiOperation(value = "Create PmsProductFullReduction", notes = "Create PmsProductFullReduction")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsProductFullReductionDOV1 pmsProductFullReduction) {
        int row = pmsProductFullReductionServiceV1.save(pmsProductFullReduction);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsProductFullReduction", notes = "batchCreate PmsProductFullReduction")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsProductFullReductionDOV1> pmsProductFullReductions) {
        int rows = pmsProductFullReductionServiceV1.save(pmsProductFullReductions);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsProductFullReduction", notes = "findById PmsProductFullReduction")
    @GetMapping("/{id}")
    public Result<PmsProductFullReductionDOV1> findById(@PathVariable Integer id) {
        PmsProductFullReductionDOV1 pmsProductFullReduction = pmsProductFullReductionServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsProductFullReduction);
    }

    @ApiOperation(value = "findByIds PmsProductFullReduction", notes = "findByIds PmsProductFullReduction")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsProductFullReductionDOV1>> findByIds(@PathVariable String ids) {
        List<PmsProductFullReductionDOV1> pmsProductFullReductions = pmsProductFullReductionServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsProductFullReductions);
    }

    @ApiOperation(value = "findByField PmsProductFullReduction", notes = "findByField PmsProductFullReduction")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsProductFullReductionDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsProductFullReductionDOV1 pmsProductFullReduction = pmsProductFullReductionServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsProductFullReduction);
    }

    @ApiOperation(value = "findAll PmsProductFullReduction", notes = "findAll PmsProductFullReduction")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsProductFullReductionDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsProductFullReductionDOV1> list = pmsProductFullReductionServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsProductFullReduction", notes = "listByCondition PmsProductFullReduction")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsProductFullReductionDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsProductFullReductionDOV1.class);
        List<PmsProductFullReductionDOV1> list = pmsProductFullReductionServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsProductFullReduction", notes = "update PmsProductFullReduction")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsProductFullReductionDOV1 pmsProductFullReduction) {
        int row = pmsProductFullReductionServiceV1.update(pmsProductFullReduction);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsProductFullReduction", notes = "updateByCondition PmsProductFullReduction")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsProductFullReductionDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsProductFullReductionDOV1.class);
        int rows = pmsProductFullReductionServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsProductFullReduction", notes = "delete PmsProductFullReduction")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsProductFullReductionServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsProductFullReduction", notes = "deleteByIds PmsProductFullReduction")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsProductFullReductionServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsProductFullReduction", notes = "deleteByCondition PmsProductFullReduction")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductFullReductionDOV1.class);
        int rows = pmsProductFullReductionServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsProductFullReduction", notes = "count PmsProductFullReduction")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductFullReductionDOV1.class);
        int count = pmsProductFullReductionServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}