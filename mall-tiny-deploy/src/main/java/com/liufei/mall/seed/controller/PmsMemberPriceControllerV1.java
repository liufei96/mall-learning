package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsMemberPriceDOV1;
import com.liufei.mall.seed.service.PmsMemberPriceServiceV1;

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
* @description PmsMemberPrice controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/member/price")
public class PmsMemberPriceControllerV1 {

    @Resource
    private PmsMemberPriceServiceV1 pmsMemberPriceServiceV1;

    @ApiOperation(value = "Create PmsMemberPrice", notes = "Create PmsMemberPrice")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsMemberPriceDOV1 pmsMemberPrice) {
        int row = pmsMemberPriceServiceV1.save(pmsMemberPrice);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsMemberPrice", notes = "batchCreate PmsMemberPrice")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsMemberPriceDOV1> pmsMemberPrices) {
        int rows = pmsMemberPriceServiceV1.save(pmsMemberPrices);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsMemberPrice", notes = "findById PmsMemberPrice")
    @GetMapping("/{id}")
    public Result<PmsMemberPriceDOV1> findById(@PathVariable Integer id) {
        PmsMemberPriceDOV1 pmsMemberPrice = pmsMemberPriceServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsMemberPrice);
    }

    @ApiOperation(value = "findByIds PmsMemberPrice", notes = "findByIds PmsMemberPrice")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsMemberPriceDOV1>> findByIds(@PathVariable String ids) {
        List<PmsMemberPriceDOV1> pmsMemberPrices = pmsMemberPriceServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsMemberPrices);
    }

    @ApiOperation(value = "findByField PmsMemberPrice", notes = "findByField PmsMemberPrice")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsMemberPriceDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsMemberPriceDOV1 pmsMemberPrice = pmsMemberPriceServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsMemberPrice);
    }

    @ApiOperation(value = "findAll PmsMemberPrice", notes = "findAll PmsMemberPrice")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsMemberPriceDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsMemberPriceDOV1> list = pmsMemberPriceServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsMemberPrice", notes = "listByCondition PmsMemberPrice")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsMemberPriceDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsMemberPriceDOV1.class);
        List<PmsMemberPriceDOV1> list = pmsMemberPriceServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsMemberPrice", notes = "update PmsMemberPrice")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsMemberPriceDOV1 pmsMemberPrice) {
        int row = pmsMemberPriceServiceV1.update(pmsMemberPrice);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsMemberPrice", notes = "updateByCondition PmsMemberPrice")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsMemberPriceDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsMemberPriceDOV1.class);
        int rows = pmsMemberPriceServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsMemberPrice", notes = "delete PmsMemberPrice")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsMemberPriceServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsMemberPrice", notes = "deleteByIds PmsMemberPrice")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsMemberPriceServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsMemberPrice", notes = "deleteByCondition PmsMemberPrice")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsMemberPriceDOV1.class);
        int rows = pmsMemberPriceServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsMemberPrice", notes = "count PmsMemberPrice")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsMemberPriceDOV1.class);
        int count = pmsMemberPriceServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}