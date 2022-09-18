package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsIntegrationConsumeSettingDOV1;
import com.liufei.mall.seed.service.UmsIntegrationConsumeSettingServiceV1;

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
* @description UmsIntegrationConsumeSetting controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/integration/consume/setting")
public class UmsIntegrationConsumeSettingControllerV1 {

    @Resource
    private UmsIntegrationConsumeSettingServiceV1 umsIntegrationConsumeSettingServiceV1;

    @ApiOperation(value = "Create UmsIntegrationConsumeSetting", notes = "Create UmsIntegrationConsumeSetting")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsIntegrationConsumeSettingDOV1 umsIntegrationConsumeSetting) {
        int row = umsIntegrationConsumeSettingServiceV1.save(umsIntegrationConsumeSetting);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsIntegrationConsumeSetting", notes = "batchCreate UmsIntegrationConsumeSetting")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsIntegrationConsumeSettingDOV1> umsIntegrationConsumeSettings) {
        int rows = umsIntegrationConsumeSettingServiceV1.save(umsIntegrationConsumeSettings);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsIntegrationConsumeSetting", notes = "findById UmsIntegrationConsumeSetting")
    @GetMapping("/{id}")
    public Result<UmsIntegrationConsumeSettingDOV1> findById(@PathVariable Integer id) {
        UmsIntegrationConsumeSettingDOV1 umsIntegrationConsumeSetting = umsIntegrationConsumeSettingServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsIntegrationConsumeSetting);
    }

    @ApiOperation(value = "findByIds UmsIntegrationConsumeSetting", notes = "findByIds UmsIntegrationConsumeSetting")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsIntegrationConsumeSettingDOV1>> findByIds(@PathVariable String ids) {
        List<UmsIntegrationConsumeSettingDOV1> umsIntegrationConsumeSettings = umsIntegrationConsumeSettingServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsIntegrationConsumeSettings);
    }

    @ApiOperation(value = "findByField UmsIntegrationConsumeSetting", notes = "findByField UmsIntegrationConsumeSetting")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsIntegrationConsumeSettingDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsIntegrationConsumeSettingDOV1 umsIntegrationConsumeSetting = umsIntegrationConsumeSettingServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsIntegrationConsumeSetting);
    }

    @ApiOperation(value = "findAll UmsIntegrationConsumeSetting", notes = "findAll UmsIntegrationConsumeSetting")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsIntegrationConsumeSettingDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsIntegrationConsumeSettingDOV1> list = umsIntegrationConsumeSettingServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsIntegrationConsumeSetting", notes = "listByCondition UmsIntegrationConsumeSetting")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsIntegrationConsumeSettingDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsIntegrationConsumeSettingDOV1.class);
        List<UmsIntegrationConsumeSettingDOV1> list = umsIntegrationConsumeSettingServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsIntegrationConsumeSetting", notes = "update UmsIntegrationConsumeSetting")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsIntegrationConsumeSettingDOV1 umsIntegrationConsumeSetting) {
        int row = umsIntegrationConsumeSettingServiceV1.update(umsIntegrationConsumeSetting);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsIntegrationConsumeSetting", notes = "updateByCondition UmsIntegrationConsumeSetting")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsIntegrationConsumeSettingDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsIntegrationConsumeSettingDOV1.class);
        int rows = umsIntegrationConsumeSettingServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsIntegrationConsumeSetting", notes = "delete UmsIntegrationConsumeSetting")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsIntegrationConsumeSettingServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsIntegrationConsumeSetting", notes = "deleteByIds UmsIntegrationConsumeSetting")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsIntegrationConsumeSettingServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsIntegrationConsumeSetting", notes = "deleteByCondition UmsIntegrationConsumeSetting")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsIntegrationConsumeSettingDOV1.class);
        int rows = umsIntegrationConsumeSettingServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsIntegrationConsumeSetting", notes = "count UmsIntegrationConsumeSetting")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsIntegrationConsumeSettingDOV1.class);
        int count = umsIntegrationConsumeSettingServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}