package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsMemberTagDOV1;
import com.liufei.mall.seed.service.UmsMemberTagServiceV1;

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
* @description UmsMemberTag controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/member/tag")
public class UmsMemberTagControllerV1 {

    @Resource
    private UmsMemberTagServiceV1 umsMemberTagServiceV1;

    @ApiOperation(value = "Create UmsMemberTag", notes = "Create UmsMemberTag")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsMemberTagDOV1 umsMemberTag) {
        int row = umsMemberTagServiceV1.save(umsMemberTag);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsMemberTag", notes = "batchCreate UmsMemberTag")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsMemberTagDOV1> umsMemberTags) {
        int rows = umsMemberTagServiceV1.save(umsMemberTags);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsMemberTag", notes = "findById UmsMemberTag")
    @GetMapping("/{id}")
    public Result<UmsMemberTagDOV1> findById(@PathVariable Integer id) {
        UmsMemberTagDOV1 umsMemberTag = umsMemberTagServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsMemberTag);
    }

    @ApiOperation(value = "findByIds UmsMemberTag", notes = "findByIds UmsMemberTag")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsMemberTagDOV1>> findByIds(@PathVariable String ids) {
        List<UmsMemberTagDOV1> umsMemberTags = umsMemberTagServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsMemberTags);
    }

    @ApiOperation(value = "findByField UmsMemberTag", notes = "findByField UmsMemberTag")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsMemberTagDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsMemberTagDOV1 umsMemberTag = umsMemberTagServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsMemberTag);
    }

    @ApiOperation(value = "findAll UmsMemberTag", notes = "findAll UmsMemberTag")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsMemberTagDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsMemberTagDOV1> list = umsMemberTagServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsMemberTag", notes = "listByCondition UmsMemberTag")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsMemberTagDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsMemberTagDOV1.class);
        List<UmsMemberTagDOV1> list = umsMemberTagServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsMemberTag", notes = "update UmsMemberTag")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsMemberTagDOV1 umsMemberTag) {
        int row = umsMemberTagServiceV1.update(umsMemberTag);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsMemberTag", notes = "updateByCondition UmsMemberTag")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsMemberTagDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsMemberTagDOV1.class);
        int rows = umsMemberTagServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsMemberTag", notes = "delete UmsMemberTag")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsMemberTagServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsMemberTag", notes = "deleteByIds UmsMemberTag")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsMemberTagServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsMemberTag", notes = "deleteByCondition UmsMemberTag")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberTagDOV1.class);
        int rows = umsMemberTagServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsMemberTag", notes = "count UmsMemberTag")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberTagDOV1.class);
        int count = umsMemberTagServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}