package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsProductVerifyRecordDOV1;
import com.liufei.mall.seed.service.PmsProductVerifyRecordServiceV1;

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
* @description PmsProductVerifyRecord controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/product/verify/record")
public class PmsProductVerifyRecordControllerV1 {

    @Resource
    private PmsProductVerifyRecordServiceV1 pmsProductVerifyRecordServiceV1;

    @ApiOperation(value = "Create PmsProductVerifyRecord", notes = "Create PmsProductVerifyRecord")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsProductVerifyRecordDOV1 pmsProductVerifyRecord) {
        int row = pmsProductVerifyRecordServiceV1.save(pmsProductVerifyRecord);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsProductVerifyRecord", notes = "batchCreate PmsProductVerifyRecord")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsProductVerifyRecordDOV1> pmsProductVerifyRecords) {
        int rows = pmsProductVerifyRecordServiceV1.save(pmsProductVerifyRecords);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsProductVerifyRecord", notes = "findById PmsProductVerifyRecord")
    @GetMapping("/{id}")
    public Result<PmsProductVerifyRecordDOV1> findById(@PathVariable Integer id) {
        PmsProductVerifyRecordDOV1 pmsProductVerifyRecord = pmsProductVerifyRecordServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsProductVerifyRecord);
    }

    @ApiOperation(value = "findByIds PmsProductVerifyRecord", notes = "findByIds PmsProductVerifyRecord")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsProductVerifyRecordDOV1>> findByIds(@PathVariable String ids) {
        List<PmsProductVerifyRecordDOV1> pmsProductVerifyRecords = pmsProductVerifyRecordServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsProductVerifyRecords);
    }

    @ApiOperation(value = "findByField PmsProductVerifyRecord", notes = "findByField PmsProductVerifyRecord")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsProductVerifyRecordDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsProductVerifyRecordDOV1 pmsProductVerifyRecord = pmsProductVerifyRecordServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsProductVerifyRecord);
    }

    @ApiOperation(value = "findAll PmsProductVerifyRecord", notes = "findAll PmsProductVerifyRecord")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsProductVerifyRecordDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsProductVerifyRecordDOV1> list = pmsProductVerifyRecordServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsProductVerifyRecord", notes = "listByCondition PmsProductVerifyRecord")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsProductVerifyRecordDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsProductVerifyRecordDOV1.class);
        List<PmsProductVerifyRecordDOV1> list = pmsProductVerifyRecordServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsProductVerifyRecord", notes = "update PmsProductVerifyRecord")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsProductVerifyRecordDOV1 pmsProductVerifyRecord) {
        int row = pmsProductVerifyRecordServiceV1.update(pmsProductVerifyRecord);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsProductVerifyRecord", notes = "updateByCondition PmsProductVerifyRecord")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsProductVerifyRecordDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsProductVerifyRecordDOV1.class);
        int rows = pmsProductVerifyRecordServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsProductVerifyRecord", notes = "delete PmsProductVerifyRecord")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsProductVerifyRecordServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsProductVerifyRecord", notes = "deleteByIds PmsProductVerifyRecord")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsProductVerifyRecordServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsProductVerifyRecord", notes = "deleteByCondition PmsProductVerifyRecord")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductVerifyRecordDOV1.class);
        int rows = pmsProductVerifyRecordServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsProductVerifyRecord", notes = "count PmsProductVerifyRecord")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductVerifyRecordDOV1.class);
        int count = pmsProductVerifyRecordServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}