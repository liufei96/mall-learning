package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.SmsFlashPromotionDOV1;
import com.liufei.mall.seed.service.SmsFlashPromotionServiceV1;

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
* @description SmsFlashPromotion controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/sms/flash/promotion")
public class SmsFlashPromotionControllerV1 {

    @Resource
    private SmsFlashPromotionServiceV1 smsFlashPromotionServiceV1;

    @ApiOperation(value = "Create SmsFlashPromotion", notes = "Create SmsFlashPromotion")
    @PostMapping
    public Result<Integer> create(@RequestBody SmsFlashPromotionDOV1 smsFlashPromotion) {
        int row = smsFlashPromotionServiceV1.save(smsFlashPromotion);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate SmsFlashPromotion", notes = "batchCreate SmsFlashPromotion")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<SmsFlashPromotionDOV1> smsFlashPromotions) {
        int rows = smsFlashPromotionServiceV1.save(smsFlashPromotions);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById SmsFlashPromotion", notes = "findById SmsFlashPromotion")
    @GetMapping("/{id}")
    public Result<SmsFlashPromotionDOV1> findById(@PathVariable Integer id) {
        SmsFlashPromotionDOV1 smsFlashPromotion = smsFlashPromotionServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(smsFlashPromotion);
    }

    @ApiOperation(value = "findByIds SmsFlashPromotion", notes = "findByIds SmsFlashPromotion")
    @GetMapping("/findByIds/{ids}")
    public Result<List<SmsFlashPromotionDOV1>> findByIds(@PathVariable String ids) {
        List<SmsFlashPromotionDOV1> smsFlashPromotions = smsFlashPromotionServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(smsFlashPromotions);
    }

    @ApiOperation(value = "findByField SmsFlashPromotion", notes = "findByField SmsFlashPromotion")
    @GetMapping("/findByField/{field}/{value}")
    public Result<SmsFlashPromotionDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        SmsFlashPromotionDOV1 smsFlashPromotion = smsFlashPromotionServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(smsFlashPromotion);
    }

    @ApiOperation(value = "findAll SmsFlashPromotion", notes = "findAll SmsFlashPromotion")
    @GetMapping("/findAll")
    public Result<PageInfo<SmsFlashPromotionDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsFlashPromotionDOV1> list = smsFlashPromotionServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition SmsFlashPromotion", notes = "listByCondition SmsFlashPromotion")
    @PostMapping("/listByCondition")
    public Result<PageInfo<SmsFlashPromotionDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionDOV1.class);
        List<SmsFlashPromotionDOV1> list = smsFlashPromotionServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update SmsFlashPromotion", notes = "update SmsFlashPromotion")
    @PutMapping
    public Result<Integer> update(@RequestBody SmsFlashPromotionDOV1 smsFlashPromotion) {
        int row = smsFlashPromotionServiceV1.update(smsFlashPromotion);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition SmsFlashPromotion", notes = "updateByCondition SmsFlashPromotion")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<SmsFlashPromotionDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(SmsFlashPromotionDOV1.class);
        int rows = smsFlashPromotionServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete SmsFlashPromotion", notes = "delete SmsFlashPromotion")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = smsFlashPromotionServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds SmsFlashPromotion", notes = "deleteByIds SmsFlashPromotion")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = smsFlashPromotionServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition SmsFlashPromotion", notes = "deleteByCondition SmsFlashPromotion")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionDOV1.class);
        int rows = smsFlashPromotionServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count SmsFlashPromotion", notes = "count SmsFlashPromotion")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(SmsFlashPromotionDOV1.class);
        int count = smsFlashPromotionServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}