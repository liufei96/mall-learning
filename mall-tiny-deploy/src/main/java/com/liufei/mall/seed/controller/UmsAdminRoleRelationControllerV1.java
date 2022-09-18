package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsAdminRoleRelationDOV1;
import com.liufei.mall.seed.service.UmsAdminRoleRelationServiceV1;

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
* @description UmsAdminRoleRelation controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/admin/role/relation")
public class UmsAdminRoleRelationControllerV1 {

    @Resource
    private UmsAdminRoleRelationServiceV1 umsAdminRoleRelationServiceV1;

    @ApiOperation(value = "Create UmsAdminRoleRelation", notes = "Create UmsAdminRoleRelation")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsAdminRoleRelationDOV1 umsAdminRoleRelation) {
        int row = umsAdminRoleRelationServiceV1.save(umsAdminRoleRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsAdminRoleRelation", notes = "batchCreate UmsAdminRoleRelation")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsAdminRoleRelationDOV1> umsAdminRoleRelations) {
        int rows = umsAdminRoleRelationServiceV1.save(umsAdminRoleRelations);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsAdminRoleRelation", notes = "findById UmsAdminRoleRelation")
    @GetMapping("/{id}")
    public Result<UmsAdminRoleRelationDOV1> findById(@PathVariable Integer id) {
        UmsAdminRoleRelationDOV1 umsAdminRoleRelation = umsAdminRoleRelationServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsAdminRoleRelation);
    }

    @ApiOperation(value = "findByIds UmsAdminRoleRelation", notes = "findByIds UmsAdminRoleRelation")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsAdminRoleRelationDOV1>> findByIds(@PathVariable String ids) {
        List<UmsAdminRoleRelationDOV1> umsAdminRoleRelations = umsAdminRoleRelationServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsAdminRoleRelations);
    }

    @ApiOperation(value = "findByField UmsAdminRoleRelation", notes = "findByField UmsAdminRoleRelation")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsAdminRoleRelationDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsAdminRoleRelationDOV1 umsAdminRoleRelation = umsAdminRoleRelationServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsAdminRoleRelation);
    }

    @ApiOperation(value = "findAll UmsAdminRoleRelation", notes = "findAll UmsAdminRoleRelation")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsAdminRoleRelationDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsAdminRoleRelationDOV1> list = umsAdminRoleRelationServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsAdminRoleRelation", notes = "listByCondition UmsAdminRoleRelation")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsAdminRoleRelationDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsAdminRoleRelationDOV1.class);
        List<UmsAdminRoleRelationDOV1> list = umsAdminRoleRelationServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsAdminRoleRelation", notes = "update UmsAdminRoleRelation")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsAdminRoleRelationDOV1 umsAdminRoleRelation) {
        int row = umsAdminRoleRelationServiceV1.update(umsAdminRoleRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsAdminRoleRelation", notes = "updateByCondition UmsAdminRoleRelation")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsAdminRoleRelationDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsAdminRoleRelationDOV1.class);
        int rows = umsAdminRoleRelationServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsAdminRoleRelation", notes = "delete UmsAdminRoleRelation")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsAdminRoleRelationServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsAdminRoleRelation", notes = "deleteByIds UmsAdminRoleRelation")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsAdminRoleRelationServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsAdminRoleRelation", notes = "deleteByCondition UmsAdminRoleRelation")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsAdminRoleRelationDOV1.class);
        int rows = umsAdminRoleRelationServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsAdminRoleRelation", notes = "count UmsAdminRoleRelation")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsAdminRoleRelationDOV1.class);
        int count = umsAdminRoleRelationServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}