package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsMemberDOV1;
import com.liufei.mall.seed.service.UmsMemberServiceV1;

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
* @description UmsMember controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/member")
public class UmsMemberControllerV1 {

    @Resource
    private UmsMemberServiceV1 umsMemberServiceV1;

    @ApiOperation(value = "Create UmsMember", notes = "Create UmsMember")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsMemberDOV1 umsMember) {
        int row = umsMemberServiceV1.save(umsMember);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsMember", notes = "batchCreate UmsMember")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsMemberDOV1> umsMembers) {
        int rows = umsMemberServiceV1.save(umsMembers);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsMember", notes = "findById UmsMember")
    @GetMapping("/{id}")
    public Result<UmsMemberDOV1> findById(@PathVariable Integer id) {
        UmsMemberDOV1 umsMember = umsMemberServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsMember);
    }

    @ApiOperation(value = "findByIds UmsMember", notes = "findByIds UmsMember")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsMemberDOV1>> findByIds(@PathVariable String ids) {
        List<UmsMemberDOV1> umsMembers = umsMemberServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsMembers);
    }

    @ApiOperation(value = "findByField UmsMember", notes = "findByField UmsMember")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsMemberDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsMemberDOV1 umsMember = umsMemberServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsMember);
    }

    @ApiOperation(value = "findAll UmsMember", notes = "findAll UmsMember")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsMemberDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsMemberDOV1> list = umsMemberServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsMember", notes = "listByCondition UmsMember")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsMemberDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsMemberDOV1.class);
        List<UmsMemberDOV1> list = umsMemberServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsMember", notes = "update UmsMember")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsMemberDOV1 umsMember) {
        int row = umsMemberServiceV1.update(umsMember);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsMember", notes = "updateByCondition UmsMember")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsMemberDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsMemberDOV1.class);
        int rows = umsMemberServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsMember", notes = "delete UmsMember")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsMemberServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsMember", notes = "deleteByIds UmsMember")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsMemberServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsMember", notes = "deleteByCondition UmsMember")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberDOV1.class);
        int rows = umsMemberServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsMember", notes = "count UmsMember")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberDOV1.class);
        int count = umsMemberServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}