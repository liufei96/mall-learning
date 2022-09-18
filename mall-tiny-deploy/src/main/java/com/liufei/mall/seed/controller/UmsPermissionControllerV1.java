package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsPermissionDOV1;
import com.liufei.mall.seed.service.UmsPermissionServiceV1;

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
* @description UmsPermission controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/permission")
public class UmsPermissionControllerV1 {

    @Resource
    private UmsPermissionServiceV1 umsPermissionServiceV1;

    @ApiOperation(value = "Create UmsPermission", notes = "Create UmsPermission")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsPermissionDOV1 umsPermission) {
        int row = umsPermissionServiceV1.save(umsPermission);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsPermission", notes = "batchCreate UmsPermission")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsPermissionDOV1> umsPermissions) {
        int rows = umsPermissionServiceV1.save(umsPermissions);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsPermission", notes = "findById UmsPermission")
    @GetMapping("/{id}")
    public Result<UmsPermissionDOV1> findById(@PathVariable Integer id) {
        UmsPermissionDOV1 umsPermission = umsPermissionServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsPermission);
    }

    @ApiOperation(value = "findByIds UmsPermission", notes = "findByIds UmsPermission")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsPermissionDOV1>> findByIds(@PathVariable String ids) {
        List<UmsPermissionDOV1> umsPermissions = umsPermissionServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsPermissions);
    }

    @ApiOperation(value = "findByField UmsPermission", notes = "findByField UmsPermission")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsPermissionDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsPermissionDOV1 umsPermission = umsPermissionServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsPermission);
    }

    @ApiOperation(value = "findAll UmsPermission", notes = "findAll UmsPermission")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsPermissionDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsPermissionDOV1> list = umsPermissionServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsPermission", notes = "listByCondition UmsPermission")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsPermissionDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsPermissionDOV1.class);
        List<UmsPermissionDOV1> list = umsPermissionServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsPermission", notes = "update UmsPermission")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsPermissionDOV1 umsPermission) {
        int row = umsPermissionServiceV1.update(umsPermission);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsPermission", notes = "updateByCondition UmsPermission")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsPermissionDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsPermissionDOV1.class);
        int rows = umsPermissionServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsPermission", notes = "delete UmsPermission")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsPermissionServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsPermission", notes = "deleteByIds UmsPermission")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsPermissionServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsPermission", notes = "deleteByCondition UmsPermission")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsPermissionDOV1.class);
        int rows = umsPermissionServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsPermission", notes = "count UmsPermission")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsPermissionDOV1.class);
        int count = umsPermissionServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}