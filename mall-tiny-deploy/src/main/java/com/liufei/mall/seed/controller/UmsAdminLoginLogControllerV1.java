package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsAdminLoginLogDOV1;
import com.liufei.mall.seed.service.UmsAdminLoginLogServiceV1;

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
* @description UmsAdminLoginLog controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/admin/login/log")
public class UmsAdminLoginLogControllerV1 {

    @Resource
    private UmsAdminLoginLogServiceV1 umsAdminLoginLogServiceV1;

    @ApiOperation(value = "Create UmsAdminLoginLog", notes = "Create UmsAdminLoginLog")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsAdminLoginLogDOV1 umsAdminLoginLog) {
        int row = umsAdminLoginLogServiceV1.save(umsAdminLoginLog);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsAdminLoginLog", notes = "batchCreate UmsAdminLoginLog")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsAdminLoginLogDOV1> umsAdminLoginLogs) {
        int rows = umsAdminLoginLogServiceV1.save(umsAdminLoginLogs);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsAdminLoginLog", notes = "findById UmsAdminLoginLog")
    @GetMapping("/{id}")
    public Result<UmsAdminLoginLogDOV1> findById(@PathVariable Integer id) {
        UmsAdminLoginLogDOV1 umsAdminLoginLog = umsAdminLoginLogServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsAdminLoginLog);
    }

    @ApiOperation(value = "findByIds UmsAdminLoginLog", notes = "findByIds UmsAdminLoginLog")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsAdminLoginLogDOV1>> findByIds(@PathVariable String ids) {
        List<UmsAdminLoginLogDOV1> umsAdminLoginLogs = umsAdminLoginLogServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsAdminLoginLogs);
    }

    @ApiOperation(value = "findByField UmsAdminLoginLog", notes = "findByField UmsAdminLoginLog")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsAdminLoginLogDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsAdminLoginLogDOV1 umsAdminLoginLog = umsAdminLoginLogServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsAdminLoginLog);
    }

    @ApiOperation(value = "findAll UmsAdminLoginLog", notes = "findAll UmsAdminLoginLog")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsAdminLoginLogDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsAdminLoginLogDOV1> list = umsAdminLoginLogServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsAdminLoginLog", notes = "listByCondition UmsAdminLoginLog")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsAdminLoginLogDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsAdminLoginLogDOV1.class);
        List<UmsAdminLoginLogDOV1> list = umsAdminLoginLogServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsAdminLoginLog", notes = "update UmsAdminLoginLog")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsAdminLoginLogDOV1 umsAdminLoginLog) {
        int row = umsAdminLoginLogServiceV1.update(umsAdminLoginLog);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsAdminLoginLog", notes = "updateByCondition UmsAdminLoginLog")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsAdminLoginLogDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsAdminLoginLogDOV1.class);
        int rows = umsAdminLoginLogServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsAdminLoginLog", notes = "delete UmsAdminLoginLog")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsAdminLoginLogServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsAdminLoginLog", notes = "deleteByIds UmsAdminLoginLog")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsAdminLoginLogServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsAdminLoginLog", notes = "deleteByCondition UmsAdminLoginLog")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsAdminLoginLogDOV1.class);
        int rows = umsAdminLoginLogServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsAdminLoginLog", notes = "count UmsAdminLoginLog")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsAdminLoginLogDOV1.class);
        int count = umsAdminLoginLogServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}