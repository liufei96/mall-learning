package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsFlashPromotionLogDOV1;
import com.liufei.mall.seed.service.SmsFlashPromotionLogServiceV1;

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
* @description SmsFlashPromotionLog controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/flash/promotion/log")
public class SmsFlashPromotionLogControllerV1 {

    @Resource
    private SmsFlashPromotionLogServiceV1 smsFlashPromotionLogServiceV1;

    @ApiOperation(value = "Create SmsFlashPromotionLog", notes = "Create SmsFlashPromotionLog")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsFlashPromotionLogDOV1 smsFlashPromotionLog) {
        int row = smsFlashPromotionLogServiceV1.save(smsFlashPromotionLog);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsFlashPromotionLog", notes = "batchCreate SmsFlashPromotionLog")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsFlashPromotionLogDOV1> smsFlashPromotionLogs) {
        int rows = smsFlashPromotionLogServiceV1.save(smsFlashPromotionLogs);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsFlashPromotionLog", notes = "findById SmsFlashPromotionLog")
    @GetMapping("/{id}")
    public Result<SmsFlashPromotionLogDOV1> findById(@PathVariable Integer id) {
        SmsFlashPromotionLogDOV1 smsFlashPromotionLog = smsFlashPromotionLogServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsFlashPromotionLog);
    }

    @ApiOperation(value = "findByIds SmsFlashPromotionLog", notes = "findByIds SmsFlashPromotionLog")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsFlashPromotionLogDOV1>> findByIds(@PathVariable String ids) {
        List<SmsFlashPromotionLogDOV1> smsFlashPromotionLogs = smsFlashPromotionLogServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsFlashPromotionLogs);
    }

    @ApiOperation(value = "findByField SmsFlashPromotionLog", notes = "findByField SmsFlashPromotionLog")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsFlashPromotionLogDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsFlashPromotionLogDOV1 smsFlashPromotionLog = smsFlashPromotionLogServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsFlashPromotionLog);
    }

    @ApiOperation(value = "findAll SmsFlashPromotionLog", notes = "findAll SmsFlashPromotionLog")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsFlashPromotionLogDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsFlashPromotionLogDOV1> list = smsFlashPromotionLogServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsFlashPromotionLog", notes = "listByCondition SmsFlashPromotionLog")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsFlashPromotionLogDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionLogDOV1.class);
        List<SmsFlashPromotionLogDOV1> list = smsFlashPromotionLogServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsFlashPromotionLog", notes = "update SmsFlashPromotionLog")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsFlashPromotionLogDOV1 smsFlashPromotionLog) {
        int row = smsFlashPromotionLogServiceV1.update(smsFlashPromotionLog);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsFlashPromotionLog", notes = "updateByCondition SmsFlashPromotionLog")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsFlashPromotionLogDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsFlashPromotionLogDOV1.class);
        int rows = smsFlashPromotionLogServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsFlashPromotionLog", notes = "delete SmsFlashPromotionLog")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsFlashPromotionLogServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsFlashPromotionLog", notes = "deleteByIds SmsFlashPromotionLog")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsFlashPromotionLogServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsFlashPromotionLog", notes = "deleteByCondition SmsFlashPromotionLog")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionLogDOV1.class);
        int rows = smsFlashPromotionLogServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsFlashPromotionLog", notes = "count SmsFlashPromotionLog")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionLogDOV1.class);
        int count = smsFlashPromotionLogServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}