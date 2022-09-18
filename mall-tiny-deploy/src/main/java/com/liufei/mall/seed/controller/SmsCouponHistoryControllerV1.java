package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsCouponHistoryDOV1;
import com.liufei.mall.seed.service.SmsCouponHistoryServiceV1;

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
* @description SmsCouponHistory controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/coupon/history")
public class SmsCouponHistoryControllerV1 {

    @Resource
    private SmsCouponHistoryServiceV1 smsCouponHistoryServiceV1;

    @ApiOperation(value = "Create SmsCouponHistory", notes = "Create SmsCouponHistory")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsCouponHistoryDOV1 smsCouponHistory) {
        int row = smsCouponHistoryServiceV1.save(smsCouponHistory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsCouponHistory", notes = "batchCreate SmsCouponHistory")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsCouponHistoryDOV1> smsCouponHistorys) {
        int rows = smsCouponHistoryServiceV1.save(smsCouponHistorys);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsCouponHistory", notes = "findById SmsCouponHistory")
    @GetMapping("/{id}")
    public Result<SmsCouponHistoryDOV1> findById(@PathVariable Integer id) {
        SmsCouponHistoryDOV1 smsCouponHistory = smsCouponHistoryServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsCouponHistory);
    }

    @ApiOperation(value = "findByIds SmsCouponHistory", notes = "findByIds SmsCouponHistory")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsCouponHistoryDOV1>> findByIds(@PathVariable String ids) {
        List<SmsCouponHistoryDOV1> smsCouponHistorys = smsCouponHistoryServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsCouponHistorys);
    }

    @ApiOperation(value = "findByField SmsCouponHistory", notes = "findByField SmsCouponHistory")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsCouponHistoryDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsCouponHistoryDOV1 smsCouponHistory = smsCouponHistoryServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsCouponHistory);
    }

    @ApiOperation(value = "findAll SmsCouponHistory", notes = "findAll SmsCouponHistory")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsCouponHistoryDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsCouponHistoryDOV1> list = smsCouponHistoryServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsCouponHistory", notes = "listByCondition SmsCouponHistory")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsCouponHistoryDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsCouponHistoryDOV1.class);
        List<SmsCouponHistoryDOV1> list = smsCouponHistoryServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsCouponHistory", notes = "update SmsCouponHistory")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsCouponHistoryDOV1 smsCouponHistory) {
        int row = smsCouponHistoryServiceV1.update(smsCouponHistory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsCouponHistory", notes = "updateByCondition SmsCouponHistory")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsCouponHistoryDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsCouponHistoryDOV1.class);
        int rows = smsCouponHistoryServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsCouponHistory", notes = "delete SmsCouponHistory")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsCouponHistoryServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsCouponHistory", notes = "deleteByIds SmsCouponHistory")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsCouponHistoryServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsCouponHistory", notes = "deleteByCondition SmsCouponHistory")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsCouponHistoryDOV1.class);
        int rows = smsCouponHistoryServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsCouponHistory", notes = "count SmsCouponHistory")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsCouponHistoryDOV1.class);
        int count = smsCouponHistoryServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}