package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsFlashPromotionSessionDOV1;
import com.liufei.mall.seed.service.SmsFlashPromotionSessionServiceV1;

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
* @description SmsFlashPromotionSession controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/flash/promotion/session")
public class SmsFlashPromotionSessionControllerV1 {

    @Resource
    private SmsFlashPromotionSessionServiceV1 smsFlashPromotionSessionServiceV1;

    @ApiOperation(value = "Create SmsFlashPromotionSession", notes = "Create SmsFlashPromotionSession")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsFlashPromotionSessionDOV1 smsFlashPromotionSession) {
        int row = smsFlashPromotionSessionServiceV1.save(smsFlashPromotionSession);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsFlashPromotionSession", notes = "batchCreate SmsFlashPromotionSession")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsFlashPromotionSessionDOV1> smsFlashPromotionSessions) {
        int rows = smsFlashPromotionSessionServiceV1.save(smsFlashPromotionSessions);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsFlashPromotionSession", notes = "findById SmsFlashPromotionSession")
    @GetMapping("/{id}")
    public Result<SmsFlashPromotionSessionDOV1> findById(@PathVariable Integer id) {
        SmsFlashPromotionSessionDOV1 smsFlashPromotionSession = smsFlashPromotionSessionServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsFlashPromotionSession);
    }

    @ApiOperation(value = "findByIds SmsFlashPromotionSession", notes = "findByIds SmsFlashPromotionSession")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsFlashPromotionSessionDOV1>> findByIds(@PathVariable String ids) {
        List<SmsFlashPromotionSessionDOV1> smsFlashPromotionSessions = smsFlashPromotionSessionServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsFlashPromotionSessions);
    }

    @ApiOperation(value = "findByField SmsFlashPromotionSession", notes = "findByField SmsFlashPromotionSession")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsFlashPromotionSessionDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsFlashPromotionSessionDOV1 smsFlashPromotionSession = smsFlashPromotionSessionServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsFlashPromotionSession);
    }

    @ApiOperation(value = "findAll SmsFlashPromotionSession", notes = "findAll SmsFlashPromotionSession")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsFlashPromotionSessionDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsFlashPromotionSessionDOV1> list = smsFlashPromotionSessionServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsFlashPromotionSession", notes = "listByCondition SmsFlashPromotionSession")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsFlashPromotionSessionDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionSessionDOV1.class);
        List<SmsFlashPromotionSessionDOV1> list = smsFlashPromotionSessionServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsFlashPromotionSession", notes = "update SmsFlashPromotionSession")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsFlashPromotionSessionDOV1 smsFlashPromotionSession) {
        int row = smsFlashPromotionSessionServiceV1.update(smsFlashPromotionSession);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsFlashPromotionSession", notes = "updateByCondition SmsFlashPromotionSession")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsFlashPromotionSessionDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsFlashPromotionSessionDOV1.class);
        int rows = smsFlashPromotionSessionServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsFlashPromotionSession", notes = "delete SmsFlashPromotionSession")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsFlashPromotionSessionServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsFlashPromotionSession", notes = "deleteByIds SmsFlashPromotionSession")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsFlashPromotionSessionServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsFlashPromotionSession", notes = "deleteByCondition SmsFlashPromotionSession")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionSessionDOV1.class);
        int rows = smsFlashPromotionSessionServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsFlashPromotionSession", notes = "count SmsFlashPromotionSession")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionSessionDOV1.class);
        int count = smsFlashPromotionSessionServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}