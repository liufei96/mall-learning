package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsBrandDOV1;
import com.liufei.mall.seed.service.PmsBrandServiceV1;

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
* @description PmsBrand controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/brand")
public class PmsBrandControllerV1 {

    @Resource
    private PmsBrandServiceV1 pmsBrandServiceV1;

    @ApiOperation(value = "Create PmsBrand", notes = "Create PmsBrand")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsBrandDOV1 pmsBrand) {
        int row = pmsBrandServiceV1.save(pmsBrand);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsBrand", notes = "batchCreate PmsBrand")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsBrandDOV1> pmsBrands) {
        int rows = pmsBrandServiceV1.save(pmsBrands);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsBrand", notes = "findById PmsBrand")
    @GetMapping("/{id}")
    public Result<PmsBrandDOV1> findById(@PathVariable Integer id) {
        PmsBrandDOV1 pmsBrand = pmsBrandServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsBrand);
    }

    @ApiOperation(value = "findByIds PmsBrand", notes = "findByIds PmsBrand")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsBrandDOV1>> findByIds(@PathVariable String ids) {
        List<PmsBrandDOV1> pmsBrands = pmsBrandServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsBrands);
    }

    @ApiOperation(value = "findByField PmsBrand", notes = "findByField PmsBrand")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsBrandDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsBrandDOV1 pmsBrand = pmsBrandServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsBrand);
    }

    @ApiOperation(value = "findAll PmsBrand", notes = "findAll PmsBrand")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsBrandDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsBrandDOV1> list = pmsBrandServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsBrand", notes = "listByCondition PmsBrand")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsBrandDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsBrandDOV1.class);
        List<PmsBrandDOV1> list = pmsBrandServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsBrand", notes = "update PmsBrand")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsBrandDOV1 pmsBrand) {
        int row = pmsBrandServiceV1.update(pmsBrand);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsBrand", notes = "updateByCondition PmsBrand")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsBrandDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsBrandDOV1.class);
        int rows = pmsBrandServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsBrand", notes = "delete PmsBrand")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsBrandServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsBrand", notes = "deleteByIds PmsBrand")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsBrandServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsBrand", notes = "deleteByCondition PmsBrand")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsBrandDOV1.class);
        int rows = pmsBrandServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsBrand", notes = "count PmsBrand")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsBrandDOV1.class);
        int count = pmsBrandServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}