package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsProductLadderDOV1;
import com.liufei.mall.seed.service.PmsProductLadderServiceV1;

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
* @description PmsProductLadder controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/product/ladder")
public class PmsProductLadderControllerV1 {

    @Resource
    private PmsProductLadderServiceV1 pmsProductLadderServiceV1;

    @ApiOperation(value = "Create PmsProductLadder", notes = "Create PmsProductLadder")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsProductLadderDOV1 pmsProductLadder) {
        int row = pmsProductLadderServiceV1.save(pmsProductLadder);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsProductLadder", notes = "batchCreate PmsProductLadder")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsProductLadderDOV1> pmsProductLadders) {
        int rows = pmsProductLadderServiceV1.save(pmsProductLadders);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsProductLadder", notes = "findById PmsProductLadder")
    @GetMapping("/{id}")
    public Result<PmsProductLadderDOV1> findById(@PathVariable Integer id) {
        PmsProductLadderDOV1 pmsProductLadder = pmsProductLadderServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsProductLadder);
    }

    @ApiOperation(value = "findByIds PmsProductLadder", notes = "findByIds PmsProductLadder")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsProductLadderDOV1>> findByIds(@PathVariable String ids) {
        List<PmsProductLadderDOV1> pmsProductLadders = pmsProductLadderServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsProductLadders);
    }

    @ApiOperation(value = "findByField PmsProductLadder", notes = "findByField PmsProductLadder")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsProductLadderDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsProductLadderDOV1 pmsProductLadder = pmsProductLadderServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsProductLadder);
    }

    @ApiOperation(value = "findAll PmsProductLadder", notes = "findAll PmsProductLadder")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsProductLadderDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsProductLadderDOV1> list = pmsProductLadderServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsProductLadder", notes = "listByCondition PmsProductLadder")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsProductLadderDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsProductLadderDOV1.class);
        List<PmsProductLadderDOV1> list = pmsProductLadderServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsProductLadder", notes = "update PmsProductLadder")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsProductLadderDOV1 pmsProductLadder) {
        int row = pmsProductLadderServiceV1.update(pmsProductLadder);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsProductLadder", notes = "updateByCondition PmsProductLadder")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsProductLadderDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsProductLadderDOV1.class);
        int rows = pmsProductLadderServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsProductLadder", notes = "delete PmsProductLadder")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsProductLadderServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsProductLadder", notes = "deleteByIds PmsProductLadder")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsProductLadderServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsProductLadder", notes = "deleteByCondition PmsProductLadder")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductLadderDOV1.class);
        int rows = pmsProductLadderServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsProductLadder", notes = "count PmsProductLadder")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductLadderDOV1.class);
        int count = pmsProductLadderServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}