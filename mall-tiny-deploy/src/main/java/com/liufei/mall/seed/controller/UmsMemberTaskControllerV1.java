package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsMemberTaskDOV1;
import com.liufei.mall.seed.service.UmsMemberTaskServiceV1;

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
* @description UmsMemberTask controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/member/task")
public class UmsMemberTaskControllerV1 {

    @Resource
    private UmsMemberTaskServiceV1 umsMemberTaskServiceV1;

    @ApiOperation(value = "Create UmsMemberTask", notes = "Create UmsMemberTask")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsMemberTaskDOV1 umsMemberTask) {
        int row = umsMemberTaskServiceV1.save(umsMemberTask);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsMemberTask", notes = "batchCreate UmsMemberTask")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsMemberTaskDOV1> umsMemberTasks) {
        int rows = umsMemberTaskServiceV1.save(umsMemberTasks);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsMemberTask", notes = "findById UmsMemberTask")
    @GetMapping("/{id}")
    public Result<UmsMemberTaskDOV1> findById(@PathVariable Integer id) {
        UmsMemberTaskDOV1 umsMemberTask = umsMemberTaskServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsMemberTask);
    }

    @ApiOperation(value = "findByIds UmsMemberTask", notes = "findByIds UmsMemberTask")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsMemberTaskDOV1>> findByIds(@PathVariable String ids) {
        List<UmsMemberTaskDOV1> umsMemberTasks = umsMemberTaskServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsMemberTasks);
    }

    @ApiOperation(value = "findByField UmsMemberTask", notes = "findByField UmsMemberTask")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsMemberTaskDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsMemberTaskDOV1 umsMemberTask = umsMemberTaskServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsMemberTask);
    }

    @ApiOperation(value = "findAll UmsMemberTask", notes = "findAll UmsMemberTask")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsMemberTaskDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsMemberTaskDOV1> list = umsMemberTaskServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsMemberTask", notes = "listByCondition UmsMemberTask")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsMemberTaskDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsMemberTaskDOV1.class);
        List<UmsMemberTaskDOV1> list = umsMemberTaskServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsMemberTask", notes = "update UmsMemberTask")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsMemberTaskDOV1 umsMemberTask) {
        int row = umsMemberTaskServiceV1.update(umsMemberTask);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsMemberTask", notes = "updateByCondition UmsMemberTask")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsMemberTaskDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsMemberTaskDOV1.class);
        int rows = umsMemberTaskServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsMemberTask", notes = "delete UmsMemberTask")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsMemberTaskServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsMemberTask", notes = "deleteByIds UmsMemberTask")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsMemberTaskServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsMemberTask", notes = "deleteByCondition UmsMemberTask")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberTaskDOV1.class);
        int rows = umsMemberTaskServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsMemberTask", notes = "count UmsMemberTask")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberTaskDOV1.class);
        int count = umsMemberTaskServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}