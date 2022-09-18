package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsIntegrationChangeHistoryDOV1;
import com.liufei.mall.seed.service.UmsIntegrationChangeHistoryServiceV1;

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
* @description UmsIntegrationChangeHistory controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/integration/change/history")
public class UmsIntegrationChangeHistoryControllerV1 {

    @Resource
    private UmsIntegrationChangeHistoryServiceV1 umsIntegrationChangeHistoryServiceV1;

    @ApiOperation(value = "Create UmsIntegrationChangeHistory", notes = "Create UmsIntegrationChangeHistory")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsIntegrationChangeHistoryDOV1 umsIntegrationChangeHistory) {
        int row = umsIntegrationChangeHistoryServiceV1.save(umsIntegrationChangeHistory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsIntegrationChangeHistory", notes = "batchCreate UmsIntegrationChangeHistory")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsIntegrationChangeHistoryDOV1> umsIntegrationChangeHistorys) {
        int rows = umsIntegrationChangeHistoryServiceV1.save(umsIntegrationChangeHistorys);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsIntegrationChangeHistory", notes = "findById UmsIntegrationChangeHistory")
    @GetMapping("/{id}")
    public Result<UmsIntegrationChangeHistoryDOV1> findById(@PathVariable Integer id) {
        UmsIntegrationChangeHistoryDOV1 umsIntegrationChangeHistory = umsIntegrationChangeHistoryServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsIntegrationChangeHistory);
    }

    @ApiOperation(value = "findByIds UmsIntegrationChangeHistory", notes = "findByIds UmsIntegrationChangeHistory")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsIntegrationChangeHistoryDOV1>> findByIds(@PathVariable String ids) {
        List<UmsIntegrationChangeHistoryDOV1> umsIntegrationChangeHistorys = umsIntegrationChangeHistoryServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsIntegrationChangeHistorys);
    }

    @ApiOperation(value = "findByField UmsIntegrationChangeHistory", notes = "findByField UmsIntegrationChangeHistory")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsIntegrationChangeHistoryDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsIntegrationChangeHistoryDOV1 umsIntegrationChangeHistory = umsIntegrationChangeHistoryServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsIntegrationChangeHistory);
    }

    @ApiOperation(value = "findAll UmsIntegrationChangeHistory", notes = "findAll UmsIntegrationChangeHistory")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsIntegrationChangeHistoryDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsIntegrationChangeHistoryDOV1> list = umsIntegrationChangeHistoryServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsIntegrationChangeHistory", notes = "listByCondition UmsIntegrationChangeHistory")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsIntegrationChangeHistoryDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsIntegrationChangeHistoryDOV1.class);
        List<UmsIntegrationChangeHistoryDOV1> list = umsIntegrationChangeHistoryServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsIntegrationChangeHistory", notes = "update UmsIntegrationChangeHistory")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsIntegrationChangeHistoryDOV1 umsIntegrationChangeHistory) {
        int row = umsIntegrationChangeHistoryServiceV1.update(umsIntegrationChangeHistory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsIntegrationChangeHistory", notes = "updateByCondition UmsIntegrationChangeHistory")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsIntegrationChangeHistoryDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsIntegrationChangeHistoryDOV1.class);
        int rows = umsIntegrationChangeHistoryServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsIntegrationChangeHistory", notes = "delete UmsIntegrationChangeHistory")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsIntegrationChangeHistoryServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsIntegrationChangeHistory", notes = "deleteByIds UmsIntegrationChangeHistory")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsIntegrationChangeHistoryServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsIntegrationChangeHistory", notes = "deleteByCondition UmsIntegrationChangeHistory")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsIntegrationChangeHistoryDOV1.class);
        int rows = umsIntegrationChangeHistoryServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsIntegrationChangeHistory", notes = "count UmsIntegrationChangeHistory")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsIntegrationChangeHistoryDOV1.class);
        int count = umsIntegrationChangeHistoryServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}