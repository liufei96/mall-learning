package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsMemberLoginLogDOV1;
import com.liufei.mall.seed.service.UmsMemberLoginLogServiceV1;

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
* @description UmsMemberLoginLog controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/member/login/log")
public class UmsMemberLoginLogControllerV1 {

    @Resource
    private UmsMemberLoginLogServiceV1 umsMemberLoginLogServiceV1;

    @ApiOperation(value = "Create UmsMemberLoginLog", notes = "Create UmsMemberLoginLog")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsMemberLoginLogDOV1 umsMemberLoginLog) {
        int row = umsMemberLoginLogServiceV1.save(umsMemberLoginLog);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsMemberLoginLog", notes = "batchCreate UmsMemberLoginLog")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsMemberLoginLogDOV1> umsMemberLoginLogs) {
        int rows = umsMemberLoginLogServiceV1.save(umsMemberLoginLogs);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsMemberLoginLog", notes = "findById UmsMemberLoginLog")
    @GetMapping("/{id}")
    public Result<UmsMemberLoginLogDOV1> findById(@PathVariable Integer id) {
        UmsMemberLoginLogDOV1 umsMemberLoginLog = umsMemberLoginLogServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsMemberLoginLog);
    }

    @ApiOperation(value = "findByIds UmsMemberLoginLog", notes = "findByIds UmsMemberLoginLog")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsMemberLoginLogDOV1>> findByIds(@PathVariable String ids) {
        List<UmsMemberLoginLogDOV1> umsMemberLoginLogs = umsMemberLoginLogServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsMemberLoginLogs);
    }

    @ApiOperation(value = "findByField UmsMemberLoginLog", notes = "findByField UmsMemberLoginLog")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsMemberLoginLogDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsMemberLoginLogDOV1 umsMemberLoginLog = umsMemberLoginLogServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsMemberLoginLog);
    }

    @ApiOperation(value = "findAll UmsMemberLoginLog", notes = "findAll UmsMemberLoginLog")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsMemberLoginLogDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsMemberLoginLogDOV1> list = umsMemberLoginLogServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsMemberLoginLog", notes = "listByCondition UmsMemberLoginLog")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsMemberLoginLogDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsMemberLoginLogDOV1.class);
        List<UmsMemberLoginLogDOV1> list = umsMemberLoginLogServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsMemberLoginLog", notes = "update UmsMemberLoginLog")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsMemberLoginLogDOV1 umsMemberLoginLog) {
        int row = umsMemberLoginLogServiceV1.update(umsMemberLoginLog);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsMemberLoginLog", notes = "updateByCondition UmsMemberLoginLog")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsMemberLoginLogDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsMemberLoginLogDOV1.class);
        int rows = umsMemberLoginLogServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsMemberLoginLog", notes = "delete UmsMemberLoginLog")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsMemberLoginLogServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsMemberLoginLog", notes = "deleteByIds UmsMemberLoginLog")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsMemberLoginLogServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsMemberLoginLog", notes = "deleteByCondition UmsMemberLoginLog")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberLoginLogDOV1.class);
        int rows = umsMemberLoginLogServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsMemberLoginLog", notes = "count UmsMemberLoginLog")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberLoginLogDOV1.class);
        int count = umsMemberLoginLogServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}