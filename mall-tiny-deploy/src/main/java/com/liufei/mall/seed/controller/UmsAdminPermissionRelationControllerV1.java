package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsAdminPermissionRelationDOV1;
import com.liufei.mall.seed.service.UmsAdminPermissionRelationServiceV1;

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
* @description UmsAdminPermissionRelation controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/admin/permission/relation")
public class UmsAdminPermissionRelationControllerV1 {

    @Resource
    private UmsAdminPermissionRelationServiceV1 umsAdminPermissionRelationServiceV1;

    @ApiOperation(value = "Create UmsAdminPermissionRelation", notes = "Create UmsAdminPermissionRelation")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsAdminPermissionRelationDOV1 umsAdminPermissionRelation) {
        int row = umsAdminPermissionRelationServiceV1.save(umsAdminPermissionRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsAdminPermissionRelation", notes = "batchCreate UmsAdminPermissionRelation")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsAdminPermissionRelationDOV1> umsAdminPermissionRelations) {
        int rows = umsAdminPermissionRelationServiceV1.save(umsAdminPermissionRelations);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsAdminPermissionRelation", notes = "findById UmsAdminPermissionRelation")
    @GetMapping("/{id}")
    public Result<UmsAdminPermissionRelationDOV1> findById(@PathVariable Integer id) {
        UmsAdminPermissionRelationDOV1 umsAdminPermissionRelation = umsAdminPermissionRelationServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsAdminPermissionRelation);
    }

    @ApiOperation(value = "findByIds UmsAdminPermissionRelation", notes = "findByIds UmsAdminPermissionRelation")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsAdminPermissionRelationDOV1>> findByIds(@PathVariable String ids) {
        List<UmsAdminPermissionRelationDOV1> umsAdminPermissionRelations = umsAdminPermissionRelationServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsAdminPermissionRelations);
    }

    @ApiOperation(value = "findByField UmsAdminPermissionRelation", notes = "findByField UmsAdminPermissionRelation")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsAdminPermissionRelationDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsAdminPermissionRelationDOV1 umsAdminPermissionRelation = umsAdminPermissionRelationServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsAdminPermissionRelation);
    }

    @ApiOperation(value = "findAll UmsAdminPermissionRelation", notes = "findAll UmsAdminPermissionRelation")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsAdminPermissionRelationDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsAdminPermissionRelationDOV1> list = umsAdminPermissionRelationServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsAdminPermissionRelation", notes = "listByCondition UmsAdminPermissionRelation")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsAdminPermissionRelationDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsAdminPermissionRelationDOV1.class);
        List<UmsAdminPermissionRelationDOV1> list = umsAdminPermissionRelationServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsAdminPermissionRelation", notes = "update UmsAdminPermissionRelation")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsAdminPermissionRelationDOV1 umsAdminPermissionRelation) {
        int row = umsAdminPermissionRelationServiceV1.update(umsAdminPermissionRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsAdminPermissionRelation", notes = "updateByCondition UmsAdminPermissionRelation")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsAdminPermissionRelationDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsAdminPermissionRelationDOV1.class);
        int rows = umsAdminPermissionRelationServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsAdminPermissionRelation", notes = "delete UmsAdminPermissionRelation")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsAdminPermissionRelationServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsAdminPermissionRelation", notes = "deleteByIds UmsAdminPermissionRelation")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsAdminPermissionRelationServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsAdminPermissionRelation", notes = "deleteByCondition UmsAdminPermissionRelation")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsAdminPermissionRelationDOV1.class);
        int rows = umsAdminPermissionRelationServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsAdminPermissionRelation", notes = "count UmsAdminPermissionRelation")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsAdminPermissionRelationDOV1.class);
        int count = umsAdminPermissionRelationServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}