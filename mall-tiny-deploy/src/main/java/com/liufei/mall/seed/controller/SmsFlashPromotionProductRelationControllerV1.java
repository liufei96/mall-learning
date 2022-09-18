package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsFlashPromotionProductRelationDOV1;
import com.liufei.mall.seed.service.SmsFlashPromotionProductRelationServiceV1;

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
* @description SmsFlashPromotionProductRelation controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/flash/promotion/product/relation")
public class SmsFlashPromotionProductRelationControllerV1 {

    @Resource
    private SmsFlashPromotionProductRelationServiceV1 smsFlashPromotionProductRelationServiceV1;

    @ApiOperation(value = "Create SmsFlashPromotionProductRelation", notes = "Create SmsFlashPromotionProductRelation")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsFlashPromotionProductRelationDOV1 smsFlashPromotionProductRelation) {
        int row = smsFlashPromotionProductRelationServiceV1.save(smsFlashPromotionProductRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsFlashPromotionProductRelation", notes = "batchCreate SmsFlashPromotionProductRelation")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsFlashPromotionProductRelationDOV1> smsFlashPromotionProductRelations) {
        int rows = smsFlashPromotionProductRelationServiceV1.save(smsFlashPromotionProductRelations);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsFlashPromotionProductRelation", notes = "findById SmsFlashPromotionProductRelation")
    @GetMapping("/{id}")
    public Result<SmsFlashPromotionProductRelationDOV1> findById(@PathVariable Integer id) {
        SmsFlashPromotionProductRelationDOV1 smsFlashPromotionProductRelation = smsFlashPromotionProductRelationServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsFlashPromotionProductRelation);
    }

    @ApiOperation(value = "findByIds SmsFlashPromotionProductRelation", notes = "findByIds SmsFlashPromotionProductRelation")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsFlashPromotionProductRelationDOV1>> findByIds(@PathVariable String ids) {
        List<SmsFlashPromotionProductRelationDOV1> smsFlashPromotionProductRelations = smsFlashPromotionProductRelationServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsFlashPromotionProductRelations);
    }

    @ApiOperation(value = "findByField SmsFlashPromotionProductRelation", notes = "findByField SmsFlashPromotionProductRelation")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsFlashPromotionProductRelationDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsFlashPromotionProductRelationDOV1 smsFlashPromotionProductRelation = smsFlashPromotionProductRelationServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsFlashPromotionProductRelation);
    }

    @ApiOperation(value = "findAll SmsFlashPromotionProductRelation", notes = "findAll SmsFlashPromotionProductRelation")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsFlashPromotionProductRelationDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsFlashPromotionProductRelationDOV1> list = smsFlashPromotionProductRelationServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsFlashPromotionProductRelation", notes = "listByCondition SmsFlashPromotionProductRelation")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsFlashPromotionProductRelationDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionProductRelationDOV1.class);
        List<SmsFlashPromotionProductRelationDOV1> list = smsFlashPromotionProductRelationServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsFlashPromotionProductRelation", notes = "update SmsFlashPromotionProductRelation")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsFlashPromotionProductRelationDOV1 smsFlashPromotionProductRelation) {
        int row = smsFlashPromotionProductRelationServiceV1.update(smsFlashPromotionProductRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsFlashPromotionProductRelation", notes = "updateByCondition SmsFlashPromotionProductRelation")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsFlashPromotionProductRelationDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsFlashPromotionProductRelationDOV1.class);
        int rows = smsFlashPromotionProductRelationServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsFlashPromotionProductRelation", notes = "delete SmsFlashPromotionProductRelation")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsFlashPromotionProductRelationServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsFlashPromotionProductRelation", notes = "deleteByIds SmsFlashPromotionProductRelation")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsFlashPromotionProductRelationServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsFlashPromotionProductRelation", notes = "deleteByCondition SmsFlashPromotionProductRelation")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionProductRelationDOV1.class);
        int rows = smsFlashPromotionProductRelationServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsFlashPromotionProductRelation", notes = "count SmsFlashPromotionProductRelation")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionProductRelationDOV1.class);
        int count = smsFlashPromotionProductRelationServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}