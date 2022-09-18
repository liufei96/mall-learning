package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsRoleDOV1;
import com.liufei.mall.seed.service.UmsRoleServiceV1;

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
* @description UmsRole controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/role")
public class UmsRoleControllerV1 {

    @Resource
    private UmsRoleServiceV1 umsRoleServiceV1;

    @ApiOperation(value = "Create UmsRole", notes = "Create UmsRole")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsRoleDOV1 umsRole) {
        int row = umsRoleServiceV1.save(umsRole);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsRole", notes = "batchCreate UmsRole")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsRoleDOV1> umsRoles) {
        int rows = umsRoleServiceV1.save(umsRoles);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsRole", notes = "findById UmsRole")
    @GetMapping("/{id}")
    public Result<UmsRoleDOV1> findById(@PathVariable Integer id) {
        UmsRoleDOV1 umsRole = umsRoleServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsRole);
    }

    @ApiOperation(value = "findByIds UmsRole", notes = "findByIds UmsRole")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsRoleDOV1>> findByIds(@PathVariable String ids) {
        List<UmsRoleDOV1> umsRoles = umsRoleServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsRoles);
    }

    @ApiOperation(value = "findByField UmsRole", notes = "findByField UmsRole")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsRoleDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsRoleDOV1 umsRole = umsRoleServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsRole);
    }

    @ApiOperation(value = "findAll UmsRole", notes = "findAll UmsRole")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsRoleDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsRoleDOV1> list = umsRoleServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsRole", notes = "listByCondition UmsRole")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsRoleDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsRoleDOV1.class);
        List<UmsRoleDOV1> list = umsRoleServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsRole", notes = "update UmsRole")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsRoleDOV1 umsRole) {
        int row = umsRoleServiceV1.update(umsRole);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsRole", notes = "updateByCondition UmsRole")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsRoleDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsRoleDOV1.class);
        int rows = umsRoleServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsRole", notes = "delete UmsRole")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsRoleServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsRole", notes = "deleteByIds UmsRole")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsRoleServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsRole", notes = "deleteByCondition UmsRole")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsRoleDOV1.class);
        int rows = umsRoleServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsRole", notes = "count UmsRole")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsRoleDOV1.class);
        int count = umsRoleServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}