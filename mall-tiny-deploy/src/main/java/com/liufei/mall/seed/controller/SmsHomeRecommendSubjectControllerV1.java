package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsHomeRecommendSubjectDOV1;
import com.liufei.mall.seed.service.SmsHomeRecommendSubjectServiceV1;

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
* @description SmsHomeRecommendSubject controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/home/recommend/subject")
public class SmsHomeRecommendSubjectControllerV1 {

    @Resource
    private SmsHomeRecommendSubjectServiceV1 smsHomeRecommendSubjectServiceV1;

    @ApiOperation(value = "Create SmsHomeRecommendSubject", notes = "Create SmsHomeRecommendSubject")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsHomeRecommendSubjectDOV1 smsHomeRecommendSubject) {
        int row = smsHomeRecommendSubjectServiceV1.save(smsHomeRecommendSubject);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsHomeRecommendSubject", notes = "batchCreate SmsHomeRecommendSubject")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsHomeRecommendSubjectDOV1> smsHomeRecommendSubjects) {
        int rows = smsHomeRecommendSubjectServiceV1.save(smsHomeRecommendSubjects);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsHomeRecommendSubject", notes = "findById SmsHomeRecommendSubject")
    @GetMapping("/{id}")
    public Result<SmsHomeRecommendSubjectDOV1> findById(@PathVariable Integer id) {
        SmsHomeRecommendSubjectDOV1 smsHomeRecommendSubject = smsHomeRecommendSubjectServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsHomeRecommendSubject);
    }

    @ApiOperation(value = "findByIds SmsHomeRecommendSubject", notes = "findByIds SmsHomeRecommendSubject")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsHomeRecommendSubjectDOV1>> findByIds(@PathVariable String ids) {
        List<SmsHomeRecommendSubjectDOV1> smsHomeRecommendSubjects = smsHomeRecommendSubjectServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsHomeRecommendSubjects);
    }

    @ApiOperation(value = "findByField SmsHomeRecommendSubject", notes = "findByField SmsHomeRecommendSubject")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsHomeRecommendSubjectDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsHomeRecommendSubjectDOV1 smsHomeRecommendSubject = smsHomeRecommendSubjectServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsHomeRecommendSubject);
    }

    @ApiOperation(value = "findAll SmsHomeRecommendSubject", notes = "findAll SmsHomeRecommendSubject")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsHomeRecommendSubjectDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsHomeRecommendSubjectDOV1> list = smsHomeRecommendSubjectServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsHomeRecommendSubject", notes = "listByCondition SmsHomeRecommendSubject")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsHomeRecommendSubjectDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsHomeRecommendSubjectDOV1.class);
        List<SmsHomeRecommendSubjectDOV1> list = smsHomeRecommendSubjectServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsHomeRecommendSubject", notes = "update SmsHomeRecommendSubject")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsHomeRecommendSubjectDOV1 smsHomeRecommendSubject) {
        int row = smsHomeRecommendSubjectServiceV1.update(smsHomeRecommendSubject);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsHomeRecommendSubject", notes = "updateByCondition SmsHomeRecommendSubject")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsHomeRecommendSubjectDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsHomeRecommendSubjectDOV1.class);
        int rows = smsHomeRecommendSubjectServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsHomeRecommendSubject", notes = "delete SmsHomeRecommendSubject")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsHomeRecommendSubjectServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsHomeRecommendSubject", notes = "deleteByIds SmsHomeRecommendSubject")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsHomeRecommendSubjectServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsHomeRecommendSubject", notes = "deleteByCondition SmsHomeRecommendSubject")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsHomeRecommendSubjectDOV1.class);
        int rows = smsHomeRecommendSubjectServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsHomeRecommendSubject", notes = "count SmsHomeRecommendSubject")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsHomeRecommendSubjectDOV1.class);
        int count = smsHomeRecommendSubjectServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}