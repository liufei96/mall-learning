package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsMemberRuleSettingDOV1;
import com.liufei.mall.seed.service.UmsMemberRuleSettingServiceV1;

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
* @description UmsMemberRuleSetting controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/member/rule/setting")
public class UmsMemberRuleSettingControllerV1 {

    @Resource
    private UmsMemberRuleSettingServiceV1 umsMemberRuleSettingServiceV1;

    @ApiOperation(value = "Create UmsMemberRuleSetting", notes = "Create UmsMemberRuleSetting")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsMemberRuleSettingDOV1 umsMemberRuleSetting) {
        int row = umsMemberRuleSettingServiceV1.save(umsMemberRuleSetting);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsMemberRuleSetting", notes = "batchCreate UmsMemberRuleSetting")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsMemberRuleSettingDOV1> umsMemberRuleSettings) {
        int rows = umsMemberRuleSettingServiceV1.save(umsMemberRuleSettings);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsMemberRuleSetting", notes = "findById UmsMemberRuleSetting")
    @GetMapping("/{id}")
    public Result<UmsMemberRuleSettingDOV1> findById(@PathVariable Integer id) {
        UmsMemberRuleSettingDOV1 umsMemberRuleSetting = umsMemberRuleSettingServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsMemberRuleSetting);
    }

    @ApiOperation(value = "findByIds UmsMemberRuleSetting", notes = "findByIds UmsMemberRuleSetting")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsMemberRuleSettingDOV1>> findByIds(@PathVariable String ids) {
        List<UmsMemberRuleSettingDOV1> umsMemberRuleSettings = umsMemberRuleSettingServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsMemberRuleSettings);
    }

    @ApiOperation(value = "findByField UmsMemberRuleSetting", notes = "findByField UmsMemberRuleSetting")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsMemberRuleSettingDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsMemberRuleSettingDOV1 umsMemberRuleSetting = umsMemberRuleSettingServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsMemberRuleSetting);
    }

    @ApiOperation(value = "findAll UmsMemberRuleSetting", notes = "findAll UmsMemberRuleSetting")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsMemberRuleSettingDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsMemberRuleSettingDOV1> list = umsMemberRuleSettingServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsMemberRuleSetting", notes = "listByCondition UmsMemberRuleSetting")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsMemberRuleSettingDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsMemberRuleSettingDOV1.class);
        List<UmsMemberRuleSettingDOV1> list = umsMemberRuleSettingServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsMemberRuleSetting", notes = "update UmsMemberRuleSetting")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsMemberRuleSettingDOV1 umsMemberRuleSetting) {
        int row = umsMemberRuleSettingServiceV1.update(umsMemberRuleSetting);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsMemberRuleSetting", notes = "updateByCondition UmsMemberRuleSetting")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsMemberRuleSettingDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsMemberRuleSettingDOV1.class);
        int rows = umsMemberRuleSettingServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsMemberRuleSetting", notes = "delete UmsMemberRuleSetting")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsMemberRuleSettingServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsMemberRuleSetting", notes = "deleteByIds UmsMemberRuleSetting")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsMemberRuleSettingServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsMemberRuleSetting", notes = "deleteByCondition UmsMemberRuleSetting")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberRuleSettingDOV1.class);
        int rows = umsMemberRuleSettingServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsMemberRuleSetting", notes = "count UmsMemberRuleSetting")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberRuleSettingDOV1.class);
        int count = umsMemberRuleSettingServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}