package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsProductOperateLogDOV1;
import com.liufei.mall.seed.service.PmsProductOperateLogServiceV1;

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
* @description PmsProductOperateLog controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/product/operate/log")
public class PmsProductOperateLogControllerV1 {

    @Resource
    private PmsProductOperateLogServiceV1 pmsProductOperateLogServiceV1;

    @ApiOperation(value = "Create PmsProductOperateLog", notes = "Create PmsProductOperateLog")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsProductOperateLogDOV1 pmsProductOperateLog) {
        int row = pmsProductOperateLogServiceV1.save(pmsProductOperateLog);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsProductOperateLog", notes = "batchCreate PmsProductOperateLog")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsProductOperateLogDOV1> pmsProductOperateLogs) {
        int rows = pmsProductOperateLogServiceV1.save(pmsProductOperateLogs);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsProductOperateLog", notes = "findById PmsProductOperateLog")
    @GetMapping("/{id}")
    public Result<PmsProductOperateLogDOV1> findById(@PathVariable Integer id) {
        PmsProductOperateLogDOV1 pmsProductOperateLog = pmsProductOperateLogServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsProductOperateLog);
    }

    @ApiOperation(value = "findByIds PmsProductOperateLog", notes = "findByIds PmsProductOperateLog")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsProductOperateLogDOV1>> findByIds(@PathVariable String ids) {
        List<PmsProductOperateLogDOV1> pmsProductOperateLogs = pmsProductOperateLogServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsProductOperateLogs);
    }

    @ApiOperation(value = "findByField PmsProductOperateLog", notes = "findByField PmsProductOperateLog")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsProductOperateLogDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsProductOperateLogDOV1 pmsProductOperateLog = pmsProductOperateLogServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsProductOperateLog);
    }

    @ApiOperation(value = "findAll PmsProductOperateLog", notes = "findAll PmsProductOperateLog")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsProductOperateLogDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsProductOperateLogDOV1> list = pmsProductOperateLogServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsProductOperateLog", notes = "listByCondition PmsProductOperateLog")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsProductOperateLogDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsProductOperateLogDOV1.class);
        List<PmsProductOperateLogDOV1> list = pmsProductOperateLogServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsProductOperateLog", notes = "update PmsProductOperateLog")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsProductOperateLogDOV1 pmsProductOperateLog) {
        int row = pmsProductOperateLogServiceV1.update(pmsProductOperateLog);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsProductOperateLog", notes = "updateByCondition PmsProductOperateLog")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsProductOperateLogDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsProductOperateLogDOV1.class);
        int rows = pmsProductOperateLogServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsProductOperateLog", notes = "delete PmsProductOperateLog")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsProductOperateLogServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsProductOperateLog", notes = "deleteByIds PmsProductOperateLog")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsProductOperateLogServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsProductOperateLog", notes = "deleteByCondition PmsProductOperateLog")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductOperateLogDOV1.class);
        int rows = pmsProductOperateLogServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsProductOperateLog", notes = "count PmsProductOperateLog")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductOperateLogDOV1.class);
        int count = pmsProductOperateLogServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}