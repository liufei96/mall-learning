package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsRolePermissionRelationDOV1;
import com.liufei.mall.seed.service.UmsRolePermissionRelationServiceV1;

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
* @description UmsRolePermissionRelation controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/role/permission/relation")
public class UmsRolePermissionRelationControllerV1 {

    @Resource
    private UmsRolePermissionRelationServiceV1 umsRolePermissionRelationServiceV1;

    @ApiOperation(value = "Create UmsRolePermissionRelation", notes = "Create UmsRolePermissionRelation")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsRolePermissionRelationDOV1 umsRolePermissionRelation) {
        int row = umsRolePermissionRelationServiceV1.save(umsRolePermissionRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsRolePermissionRelation", notes = "batchCreate UmsRolePermissionRelation")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsRolePermissionRelationDOV1> umsRolePermissionRelations) {
        int rows = umsRolePermissionRelationServiceV1.save(umsRolePermissionRelations);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsRolePermissionRelation", notes = "findById UmsRolePermissionRelation")
    @GetMapping("/{id}")
    public Result<UmsRolePermissionRelationDOV1> findById(@PathVariable Integer id) {
        UmsRolePermissionRelationDOV1 umsRolePermissionRelation = umsRolePermissionRelationServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsRolePermissionRelation);
    }

    @ApiOperation(value = "findByIds UmsRolePermissionRelation", notes = "findByIds UmsRolePermissionRelation")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsRolePermissionRelationDOV1>> findByIds(@PathVariable String ids) {
        List<UmsRolePermissionRelationDOV1> umsRolePermissionRelations = umsRolePermissionRelationServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsRolePermissionRelations);
    }

    @ApiOperation(value = "findByField UmsRolePermissionRelation", notes = "findByField UmsRolePermissionRelation")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsRolePermissionRelationDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsRolePermissionRelationDOV1 umsRolePermissionRelation = umsRolePermissionRelationServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsRolePermissionRelation);
    }

    @ApiOperation(value = "findAll UmsRolePermissionRelation", notes = "findAll UmsRolePermissionRelation")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsRolePermissionRelationDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsRolePermissionRelationDOV1> list = umsRolePermissionRelationServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsRolePermissionRelation", notes = "listByCondition UmsRolePermissionRelation")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsRolePermissionRelationDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsRolePermissionRelationDOV1.class);
        List<UmsRolePermissionRelationDOV1> list = umsRolePermissionRelationServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsRolePermissionRelation", notes = "update UmsRolePermissionRelation")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsRolePermissionRelationDOV1 umsRolePermissionRelation) {
        int row = umsRolePermissionRelationServiceV1.update(umsRolePermissionRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsRolePermissionRelation", notes = "updateByCondition UmsRolePermissionRelation")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsRolePermissionRelationDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsRolePermissionRelationDOV1.class);
        int rows = umsRolePermissionRelationServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsRolePermissionRelation", notes = "delete UmsRolePermissionRelation")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsRolePermissionRelationServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsRolePermissionRelation", notes = "deleteByIds UmsRolePermissionRelation")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsRolePermissionRelationServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsRolePermissionRelation", notes = "deleteByCondition UmsRolePermissionRelation")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsRolePermissionRelationDOV1.class);
        int rows = umsRolePermissionRelationServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsRolePermissionRelation", notes = "count UmsRolePermissionRelation")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsRolePermissionRelationDOV1.class);
        int count = umsRolePermissionRelationServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}