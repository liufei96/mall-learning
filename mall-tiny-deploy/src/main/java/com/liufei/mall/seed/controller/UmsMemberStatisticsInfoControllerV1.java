package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsMemberStatisticsInfoDOV1;
import com.liufei.mall.seed.service.UmsMemberStatisticsInfoServiceV1;

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
* @description UmsMemberStatisticsInfo controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/member/statistics/info")
public class UmsMemberStatisticsInfoControllerV1 {

    @Resource
    private UmsMemberStatisticsInfoServiceV1 umsMemberStatisticsInfoServiceV1;

    @ApiOperation(value = "Create UmsMemberStatisticsInfo", notes = "Create UmsMemberStatisticsInfo")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsMemberStatisticsInfoDOV1 umsMemberStatisticsInfo) {
        int row = umsMemberStatisticsInfoServiceV1.save(umsMemberStatisticsInfo);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsMemberStatisticsInfo", notes = "batchCreate UmsMemberStatisticsInfo")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsMemberStatisticsInfoDOV1> umsMemberStatisticsInfos) {
        int rows = umsMemberStatisticsInfoServiceV1.save(umsMemberStatisticsInfos);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsMemberStatisticsInfo", notes = "findById UmsMemberStatisticsInfo")
    @GetMapping("/{id}")
    public Result<UmsMemberStatisticsInfoDOV1> findById(@PathVariable Integer id) {
        UmsMemberStatisticsInfoDOV1 umsMemberStatisticsInfo = umsMemberStatisticsInfoServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsMemberStatisticsInfo);
    }

    @ApiOperation(value = "findByIds UmsMemberStatisticsInfo", notes = "findByIds UmsMemberStatisticsInfo")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsMemberStatisticsInfoDOV1>> findByIds(@PathVariable String ids) {
        List<UmsMemberStatisticsInfoDOV1> umsMemberStatisticsInfos = umsMemberStatisticsInfoServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsMemberStatisticsInfos);
    }

    @ApiOperation(value = "findByField UmsMemberStatisticsInfo", notes = "findByField UmsMemberStatisticsInfo")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsMemberStatisticsInfoDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsMemberStatisticsInfoDOV1 umsMemberStatisticsInfo = umsMemberStatisticsInfoServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsMemberStatisticsInfo);
    }

    @ApiOperation(value = "findAll UmsMemberStatisticsInfo", notes = "findAll UmsMemberStatisticsInfo")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsMemberStatisticsInfoDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsMemberStatisticsInfoDOV1> list = umsMemberStatisticsInfoServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsMemberStatisticsInfo", notes = "listByCondition UmsMemberStatisticsInfo")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsMemberStatisticsInfoDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsMemberStatisticsInfoDOV1.class);
        List<UmsMemberStatisticsInfoDOV1> list = umsMemberStatisticsInfoServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsMemberStatisticsInfo", notes = "update UmsMemberStatisticsInfo")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsMemberStatisticsInfoDOV1 umsMemberStatisticsInfo) {
        int row = umsMemberStatisticsInfoServiceV1.update(umsMemberStatisticsInfo);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsMemberStatisticsInfo", notes = "updateByCondition UmsMemberStatisticsInfo")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsMemberStatisticsInfoDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsMemberStatisticsInfoDOV1.class);
        int rows = umsMemberStatisticsInfoServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsMemberStatisticsInfo", notes = "delete UmsMemberStatisticsInfo")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsMemberStatisticsInfoServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsMemberStatisticsInfo", notes = "deleteByIds UmsMemberStatisticsInfo")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsMemberStatisticsInfoServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsMemberStatisticsInfo", notes = "deleteByCondition UmsMemberStatisticsInfo")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberStatisticsInfoDOV1.class);
        int rows = umsMemberStatisticsInfoServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsMemberStatisticsInfo", notes = "count UmsMemberStatisticsInfo")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberStatisticsInfoDOV1.class);
        int count = umsMemberStatisticsInfoServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}