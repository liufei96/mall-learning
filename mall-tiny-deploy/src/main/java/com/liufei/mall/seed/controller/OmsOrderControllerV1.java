package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.OmsOrderDOV1;
import com.liufei.mall.seed.service.OmsOrderServiceV1;

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
* @description OmsOrder controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/oms/order")
public class OmsOrderControllerV1 {

    @Resource
    private OmsOrderServiceV1 omsOrderServiceV1;

    @ApiOperation(value = "Create OmsOrder", notes = "Create OmsOrder")
    @PostMapping
    public Result<Integer> create(@RequestBody OmsOrderDOV1 omsOrder) {
        int row = omsOrderServiceV1.save(omsOrder);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate OmsOrder", notes = "batchCreate OmsOrder")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<OmsOrderDOV1> omsOrders) {
        int rows = omsOrderServiceV1.save(omsOrders);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById OmsOrder", notes = "findById OmsOrder")
    @GetMapping("/{id}")
    public Result<OmsOrderDOV1> findById(@PathVariable Integer id) {
        OmsOrderDOV1 omsOrder = omsOrderServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(omsOrder);
    }

    @ApiOperation(value = "findByIds OmsOrder", notes = "findByIds OmsOrder")
    @GetMapping("/findByIds/{ids}")
    public Result<List<OmsOrderDOV1>> findByIds(@PathVariable String ids) {
        List<OmsOrderDOV1> omsOrders = omsOrderServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(omsOrders);
    }

    @ApiOperation(value = "findByField OmsOrder", notes = "findByField OmsOrder")
    @GetMapping("/findByField/{field}/{value}")
    public Result<OmsOrderDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        OmsOrderDOV1 omsOrder = omsOrderServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(omsOrder);
    }

    @ApiOperation(value = "findAll OmsOrder", notes = "findAll OmsOrder")
    @GetMapping("/findAll")
    public Result<PageInfo<OmsOrderDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<OmsOrderDOV1> list = omsOrderServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition OmsOrder", notes = "listByCondition OmsOrder")
    @PostMapping("/listByCondition")
    public Result<PageInfo<OmsOrderDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(OmsOrderDOV1.class);
        List<OmsOrderDOV1> list = omsOrderServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update OmsOrder", notes = "update OmsOrder")
    @PutMapping
    public Result<Integer> update(@RequestBody OmsOrderDOV1 omsOrder) {
        int row = omsOrderServiceV1.update(omsOrder);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition OmsOrder", notes = "updateByCondition OmsOrder")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<OmsOrderDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(OmsOrderDOV1.class);
        int rows = omsOrderServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete OmsOrder", notes = "delete OmsOrder")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = omsOrderServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds OmsOrder", notes = "deleteByIds OmsOrder")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = omsOrderServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition OmsOrder", notes = "deleteByCondition OmsOrder")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderDOV1.class);
        int rows = omsOrderServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count OmsOrder", notes = "count OmsOrder")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderDOV1.class);
        int count = omsOrderServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}