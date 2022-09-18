package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.OmsOrderReturnReasonDOV1;
import com.liufei.mall.seed.service.OmsOrderReturnReasonServiceV1;

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
* @description OmsOrderReturnReason controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/oms/order/return/reason")
public class OmsOrderReturnReasonControllerV1 {

    @Resource
    private OmsOrderReturnReasonServiceV1 omsOrderReturnReasonServiceV1;

    @ApiOperation(value = "Create OmsOrderReturnReason", notes = "Create OmsOrderReturnReason")
    @PostMapping
    public Result<Integer> create(@RequestBody OmsOrderReturnReasonDOV1 omsOrderReturnReason) {
        int row = omsOrderReturnReasonServiceV1.save(omsOrderReturnReason);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate OmsOrderReturnReason", notes = "batchCreate OmsOrderReturnReason")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<OmsOrderReturnReasonDOV1> omsOrderReturnReasons) {
        int rows = omsOrderReturnReasonServiceV1.save(omsOrderReturnReasons);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById OmsOrderReturnReason", notes = "findById OmsOrderReturnReason")
    @GetMapping("/{id}")
    public Result<OmsOrderReturnReasonDOV1> findById(@PathVariable Integer id) {
        OmsOrderReturnReasonDOV1 omsOrderReturnReason = omsOrderReturnReasonServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(omsOrderReturnReason);
    }

    @ApiOperation(value = "findByIds OmsOrderReturnReason", notes = "findByIds OmsOrderReturnReason")
    @GetMapping("/findByIds/{ids}")
    public Result<List<OmsOrderReturnReasonDOV1>> findByIds(@PathVariable String ids) {
        List<OmsOrderReturnReasonDOV1> omsOrderReturnReasons = omsOrderReturnReasonServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(omsOrderReturnReasons);
    }

    @ApiOperation(value = "findByField OmsOrderReturnReason", notes = "findByField OmsOrderReturnReason")
    @GetMapping("/findByField/{field}/{value}")
    public Result<OmsOrderReturnReasonDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        OmsOrderReturnReasonDOV1 omsOrderReturnReason = omsOrderReturnReasonServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(omsOrderReturnReason);
    }

    @ApiOperation(value = "findAll OmsOrderReturnReason", notes = "findAll OmsOrderReturnReason")
    @GetMapping("/findAll")
    public Result<PageInfo<OmsOrderReturnReasonDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<OmsOrderReturnReasonDOV1> list = omsOrderReturnReasonServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition OmsOrderReturnReason", notes = "listByCondition OmsOrderReturnReason")
    @PostMapping("/listByCondition")
    public Result<PageInfo<OmsOrderReturnReasonDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(OmsOrderReturnReasonDOV1.class);
        List<OmsOrderReturnReasonDOV1> list = omsOrderReturnReasonServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update OmsOrderReturnReason", notes = "update OmsOrderReturnReason")
    @PutMapping
    public Result<Integer> update(@RequestBody OmsOrderReturnReasonDOV1 omsOrderReturnReason) {
        int row = omsOrderReturnReasonServiceV1.update(omsOrderReturnReason);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition OmsOrderReturnReason", notes = "updateByCondition OmsOrderReturnReason")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<OmsOrderReturnReasonDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(OmsOrderReturnReasonDOV1.class);
        int rows = omsOrderReturnReasonServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete OmsOrderReturnReason", notes = "delete OmsOrderReturnReason")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = omsOrderReturnReasonServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds OmsOrderReturnReason", notes = "deleteByIds OmsOrderReturnReason")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = omsOrderReturnReasonServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition OmsOrderReturnReason", notes = "deleteByCondition OmsOrderReturnReason")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderReturnReasonDOV1.class);
        int rows = omsOrderReturnReasonServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count OmsOrderReturnReason", notes = "count OmsOrderReturnReason")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderReturnReasonDOV1.class);
        int count = omsOrderReturnReasonServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}