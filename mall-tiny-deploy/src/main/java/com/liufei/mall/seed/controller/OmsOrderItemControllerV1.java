package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.OmsOrderItemDOV1;
import com.liufei.mall.seed.service.OmsOrderItemServiceV1;

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
* @description OmsOrderItem controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/oms/order/item")
public class OmsOrderItemControllerV1 {

    @Resource
    private OmsOrderItemServiceV1 omsOrderItemServiceV1;

    @ApiOperation(value = "Create OmsOrderItem", notes = "Create OmsOrderItem")
    @PostMapping
    public Result<Integer> create(@RequestBody OmsOrderItemDOV1 omsOrderItem) {
        int row = omsOrderItemServiceV1.save(omsOrderItem);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate OmsOrderItem", notes = "batchCreate OmsOrderItem")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<OmsOrderItemDOV1> omsOrderItems) {
        int rows = omsOrderItemServiceV1.save(omsOrderItems);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById OmsOrderItem", notes = "findById OmsOrderItem")
    @GetMapping("/{id}")
    public Result<OmsOrderItemDOV1> findById(@PathVariable Integer id) {
        OmsOrderItemDOV1 omsOrderItem = omsOrderItemServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(omsOrderItem);
    }

    @ApiOperation(value = "findByIds OmsOrderItem", notes = "findByIds OmsOrderItem")
    @GetMapping("/findByIds/{ids}")
    public Result<List<OmsOrderItemDOV1>> findByIds(@PathVariable String ids) {
        List<OmsOrderItemDOV1> omsOrderItems = omsOrderItemServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(omsOrderItems);
    }

    @ApiOperation(value = "findByField OmsOrderItem", notes = "findByField OmsOrderItem")
    @GetMapping("/findByField/{field}/{value}")
    public Result<OmsOrderItemDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        OmsOrderItemDOV1 omsOrderItem = omsOrderItemServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(omsOrderItem);
    }

    @ApiOperation(value = "findAll OmsOrderItem", notes = "findAll OmsOrderItem")
    @GetMapping("/findAll")
    public Result<PageInfo<OmsOrderItemDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<OmsOrderItemDOV1> list = omsOrderItemServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition OmsOrderItem", notes = "listByCondition OmsOrderItem")
    @PostMapping("/listByCondition")
    public Result<PageInfo<OmsOrderItemDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(OmsOrderItemDOV1.class);
        List<OmsOrderItemDOV1> list = omsOrderItemServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update OmsOrderItem", notes = "update OmsOrderItem")
    @PutMapping
    public Result<Integer> update(@RequestBody OmsOrderItemDOV1 omsOrderItem) {
        int row = omsOrderItemServiceV1.update(omsOrderItem);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition OmsOrderItem", notes = "updateByCondition OmsOrderItem")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<OmsOrderItemDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(OmsOrderItemDOV1.class);
        int rows = omsOrderItemServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete OmsOrderItem", notes = "delete OmsOrderItem")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = omsOrderItemServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds OmsOrderItem", notes = "deleteByIds OmsOrderItem")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = omsOrderItemServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition OmsOrderItem", notes = "deleteByCondition OmsOrderItem")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderItemDOV1.class);
        int rows = omsOrderItemServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count OmsOrderItem", notes = "count OmsOrderItem")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderItemDOV1.class);
        int count = omsOrderItemServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}