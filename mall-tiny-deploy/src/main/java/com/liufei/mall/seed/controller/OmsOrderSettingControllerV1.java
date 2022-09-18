package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.OmsOrderSettingDOV1;
import com.liufei.mall.seed.service.OmsOrderSettingServiceV1;

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
* @description OmsOrderSetting controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/oms/order/setting")
public class OmsOrderSettingControllerV1 {

    @Resource
    private OmsOrderSettingServiceV1 omsOrderSettingServiceV1;

    @ApiOperation(value = "Create OmsOrderSetting", notes = "Create OmsOrderSetting")
    @PostMapping
    public Result<Integer> create(@RequestBody OmsOrderSettingDOV1 omsOrderSetting) {
        int row = omsOrderSettingServiceV1.save(omsOrderSetting);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate OmsOrderSetting", notes = "batchCreate OmsOrderSetting")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<OmsOrderSettingDOV1> omsOrderSettings) {
        int rows = omsOrderSettingServiceV1.save(omsOrderSettings);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById OmsOrderSetting", notes = "findById OmsOrderSetting")
    @GetMapping("/{id}")
    public Result<OmsOrderSettingDOV1> findById(@PathVariable Integer id) {
        OmsOrderSettingDOV1 omsOrderSetting = omsOrderSettingServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(omsOrderSetting);
    }

    @ApiOperation(value = "findByIds OmsOrderSetting", notes = "findByIds OmsOrderSetting")
    @GetMapping("/findByIds/{ids}")
    public Result<List<OmsOrderSettingDOV1>> findByIds(@PathVariable String ids) {
        List<OmsOrderSettingDOV1> omsOrderSettings = omsOrderSettingServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(omsOrderSettings);
    }

    @ApiOperation(value = "findByField OmsOrderSetting", notes = "findByField OmsOrderSetting")
    @GetMapping("/findByField/{field}/{value}")
    public Result<OmsOrderSettingDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        OmsOrderSettingDOV1 omsOrderSetting = omsOrderSettingServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(omsOrderSetting);
    }

    @ApiOperation(value = "findAll OmsOrderSetting", notes = "findAll OmsOrderSetting")
    @GetMapping("/findAll")
    public Result<PageInfo<OmsOrderSettingDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<OmsOrderSettingDOV1> list = omsOrderSettingServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition OmsOrderSetting", notes = "listByCondition OmsOrderSetting")
    @PostMapping("/listByCondition")
    public Result<PageInfo<OmsOrderSettingDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(OmsOrderSettingDOV1.class);
        List<OmsOrderSettingDOV1> list = omsOrderSettingServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update OmsOrderSetting", notes = "update OmsOrderSetting")
    @PutMapping
    public Result<Integer> update(@RequestBody OmsOrderSettingDOV1 omsOrderSetting) {
        int row = omsOrderSettingServiceV1.update(omsOrderSetting);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition OmsOrderSetting", notes = "updateByCondition OmsOrderSetting")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<OmsOrderSettingDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(OmsOrderSettingDOV1.class);
        int rows = omsOrderSettingServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete OmsOrderSetting", notes = "delete OmsOrderSetting")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = omsOrderSettingServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds OmsOrderSetting", notes = "deleteByIds OmsOrderSetting")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = omsOrderSettingServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition OmsOrderSetting", notes = "deleteByCondition OmsOrderSetting")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderSettingDOV1.class);
        int rows = omsOrderSettingServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count OmsOrderSetting", notes = "count OmsOrderSetting")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderSettingDOV1.class);
        int count = omsOrderSettingServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}