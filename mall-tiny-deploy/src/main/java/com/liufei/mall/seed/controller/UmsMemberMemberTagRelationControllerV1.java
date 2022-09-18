package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsMemberMemberTagRelationDOV1;
import com.liufei.mall.seed.service.UmsMemberMemberTagRelationServiceV1;

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
* @description UmsMemberMemberTagRelation controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/member/member/tag/relation")
public class UmsMemberMemberTagRelationControllerV1 {

    @Resource
    private UmsMemberMemberTagRelationServiceV1 umsMemberMemberTagRelationServiceV1;

    @ApiOperation(value = "Create UmsMemberMemberTagRelation", notes = "Create UmsMemberMemberTagRelation")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsMemberMemberTagRelationDOV1 umsMemberMemberTagRelation) {
        int row = umsMemberMemberTagRelationServiceV1.save(umsMemberMemberTagRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsMemberMemberTagRelation", notes = "batchCreate UmsMemberMemberTagRelation")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsMemberMemberTagRelationDOV1> umsMemberMemberTagRelations) {
        int rows = umsMemberMemberTagRelationServiceV1.save(umsMemberMemberTagRelations);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsMemberMemberTagRelation", notes = "findById UmsMemberMemberTagRelation")
    @GetMapping("/{id}")
    public Result<UmsMemberMemberTagRelationDOV1> findById(@PathVariable Integer id) {
        UmsMemberMemberTagRelationDOV1 umsMemberMemberTagRelation = umsMemberMemberTagRelationServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsMemberMemberTagRelation);
    }

    @ApiOperation(value = "findByIds UmsMemberMemberTagRelation", notes = "findByIds UmsMemberMemberTagRelation")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsMemberMemberTagRelationDOV1>> findByIds(@PathVariable String ids) {
        List<UmsMemberMemberTagRelationDOV1> umsMemberMemberTagRelations = umsMemberMemberTagRelationServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsMemberMemberTagRelations);
    }

    @ApiOperation(value = "findByField UmsMemberMemberTagRelation", notes = "findByField UmsMemberMemberTagRelation")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsMemberMemberTagRelationDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsMemberMemberTagRelationDOV1 umsMemberMemberTagRelation = umsMemberMemberTagRelationServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsMemberMemberTagRelation);
    }

    @ApiOperation(value = "findAll UmsMemberMemberTagRelation", notes = "findAll UmsMemberMemberTagRelation")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsMemberMemberTagRelationDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsMemberMemberTagRelationDOV1> list = umsMemberMemberTagRelationServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsMemberMemberTagRelation", notes = "listByCondition UmsMemberMemberTagRelation")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsMemberMemberTagRelationDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsMemberMemberTagRelationDOV1.class);
        List<UmsMemberMemberTagRelationDOV1> list = umsMemberMemberTagRelationServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsMemberMemberTagRelation", notes = "update UmsMemberMemberTagRelation")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsMemberMemberTagRelationDOV1 umsMemberMemberTagRelation) {
        int row = umsMemberMemberTagRelationServiceV1.update(umsMemberMemberTagRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsMemberMemberTagRelation", notes = "updateByCondition UmsMemberMemberTagRelation")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsMemberMemberTagRelationDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsMemberMemberTagRelationDOV1.class);
        int rows = umsMemberMemberTagRelationServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsMemberMemberTagRelation", notes = "delete UmsMemberMemberTagRelation")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsMemberMemberTagRelationServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsMemberMemberTagRelation", notes = "deleteByIds UmsMemberMemberTagRelation")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsMemberMemberTagRelationServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsMemberMemberTagRelation", notes = "deleteByCondition UmsMemberMemberTagRelation")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberMemberTagRelationDOV1.class);
        int rows = umsMemberMemberTagRelationServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsMemberMemberTagRelation", notes = "count UmsMemberMemberTagRelation")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberMemberTagRelationDOV1.class);
        int count = umsMemberMemberTagRelationServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}