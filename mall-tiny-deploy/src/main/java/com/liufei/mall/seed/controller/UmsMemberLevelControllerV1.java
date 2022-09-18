package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsMemberLevelDOV1;
import com.liufei.mall.seed.service.UmsMemberLevelServiceV1;

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
* @description UmsMemberLevel controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/member/level")
public class UmsMemberLevelControllerV1 {

    @Resource
    private UmsMemberLevelServiceV1 umsMemberLevelServiceV1;

    @ApiOperation(value = "Create UmsMemberLevel", notes = "Create UmsMemberLevel")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsMemberLevelDOV1 umsMemberLevel) {
        int row = umsMemberLevelServiceV1.save(umsMemberLevel);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsMemberLevel", notes = "batchCreate UmsMemberLevel")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsMemberLevelDOV1> umsMemberLevels) {
        int rows = umsMemberLevelServiceV1.save(umsMemberLevels);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsMemberLevel", notes = "findById UmsMemberLevel")
    @GetMapping("/{id}")
    public Result<UmsMemberLevelDOV1> findById(@PathVariable Integer id) {
        UmsMemberLevelDOV1 umsMemberLevel = umsMemberLevelServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsMemberLevel);
    }

    @ApiOperation(value = "findByIds UmsMemberLevel", notes = "findByIds UmsMemberLevel")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsMemberLevelDOV1>> findByIds(@PathVariable String ids) {
        List<UmsMemberLevelDOV1> umsMemberLevels = umsMemberLevelServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsMemberLevels);
    }

    @ApiOperation(value = "findByField UmsMemberLevel", notes = "findByField UmsMemberLevel")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsMemberLevelDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsMemberLevelDOV1 umsMemberLevel = umsMemberLevelServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsMemberLevel);
    }

    @ApiOperation(value = "findAll UmsMemberLevel", notes = "findAll UmsMemberLevel")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsMemberLevelDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsMemberLevelDOV1> list = umsMemberLevelServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsMemberLevel", notes = "listByCondition UmsMemberLevel")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsMemberLevelDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsMemberLevelDOV1.class);
        List<UmsMemberLevelDOV1> list = umsMemberLevelServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsMemberLevel", notes = "update UmsMemberLevel")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsMemberLevelDOV1 umsMemberLevel) {
        int row = umsMemberLevelServiceV1.update(umsMemberLevel);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsMemberLevel", notes = "updateByCondition UmsMemberLevel")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsMemberLevelDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsMemberLevelDOV1.class);
        int rows = umsMemberLevelServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsMemberLevel", notes = "delete UmsMemberLevel")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsMemberLevelServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsMemberLevel", notes = "deleteByIds UmsMemberLevel")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsMemberLevelServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsMemberLevel", notes = "deleteByCondition UmsMemberLevel")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberLevelDOV1.class);
        int rows = umsMemberLevelServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsMemberLevel", notes = "count UmsMemberLevel")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberLevelDOV1.class);
        int count = umsMemberLevelServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}