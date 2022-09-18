package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsGrowthChangeHistoryDOV1;
import com.liufei.mall.seed.service.UmsGrowthChangeHistoryServiceV1;

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
* @description UmsGrowthChangeHistory controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/growth/change/history")
public class UmsGrowthChangeHistoryControllerV1 {

    @Resource
    private UmsGrowthChangeHistoryServiceV1 umsGrowthChangeHistoryServiceV1;

    @ApiOperation(value = "Create UmsGrowthChangeHistory", notes = "Create UmsGrowthChangeHistory")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsGrowthChangeHistoryDOV1 umsGrowthChangeHistory) {
        int row = umsGrowthChangeHistoryServiceV1.save(umsGrowthChangeHistory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsGrowthChangeHistory", notes = "batchCreate UmsGrowthChangeHistory")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsGrowthChangeHistoryDOV1> umsGrowthChangeHistorys) {
        int rows = umsGrowthChangeHistoryServiceV1.save(umsGrowthChangeHistorys);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsGrowthChangeHistory", notes = "findById UmsGrowthChangeHistory")
    @GetMapping("/{id}")
    public Result<UmsGrowthChangeHistoryDOV1> findById(@PathVariable Integer id) {
        UmsGrowthChangeHistoryDOV1 umsGrowthChangeHistory = umsGrowthChangeHistoryServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsGrowthChangeHistory);
    }

    @ApiOperation(value = "findByIds UmsGrowthChangeHistory", notes = "findByIds UmsGrowthChangeHistory")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsGrowthChangeHistoryDOV1>> findByIds(@PathVariable String ids) {
        List<UmsGrowthChangeHistoryDOV1> umsGrowthChangeHistorys = umsGrowthChangeHistoryServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsGrowthChangeHistorys);
    }

    @ApiOperation(value = "findByField UmsGrowthChangeHistory", notes = "findByField UmsGrowthChangeHistory")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsGrowthChangeHistoryDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsGrowthChangeHistoryDOV1 umsGrowthChangeHistory = umsGrowthChangeHistoryServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsGrowthChangeHistory);
    }

    @ApiOperation(value = "findAll UmsGrowthChangeHistory", notes = "findAll UmsGrowthChangeHistory")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsGrowthChangeHistoryDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsGrowthChangeHistoryDOV1> list = umsGrowthChangeHistoryServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsGrowthChangeHistory", notes = "listByCondition UmsGrowthChangeHistory")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsGrowthChangeHistoryDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsGrowthChangeHistoryDOV1.class);
        List<UmsGrowthChangeHistoryDOV1> list = umsGrowthChangeHistoryServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsGrowthChangeHistory", notes = "update UmsGrowthChangeHistory")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsGrowthChangeHistoryDOV1 umsGrowthChangeHistory) {
        int row = umsGrowthChangeHistoryServiceV1.update(umsGrowthChangeHistory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsGrowthChangeHistory", notes = "updateByCondition UmsGrowthChangeHistory")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsGrowthChangeHistoryDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsGrowthChangeHistoryDOV1.class);
        int rows = umsGrowthChangeHistoryServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsGrowthChangeHistory", notes = "delete UmsGrowthChangeHistory")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsGrowthChangeHistoryServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsGrowthChangeHistory", notes = "deleteByIds UmsGrowthChangeHistory")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsGrowthChangeHistoryServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsGrowthChangeHistory", notes = "deleteByCondition UmsGrowthChangeHistory")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsGrowthChangeHistoryDOV1.class);
        int rows = umsGrowthChangeHistoryServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsGrowthChangeHistory", notes = "count UmsGrowthChangeHistory")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsGrowthChangeHistoryDOV1.class);
        int count = umsGrowthChangeHistoryServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}