package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.OmsOrderOperateHistoryDOV1;
import com.liufei.mall.seed.service.OmsOrderOperateHistoryServiceV1;

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
* @description OmsOrderOperateHistory controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/oms/order/operate/history")
public class OmsOrderOperateHistoryControllerV1 {

    @Resource
    private OmsOrderOperateHistoryServiceV1 omsOrderOperateHistoryServiceV1;

    @ApiOperation(value = "Create OmsOrderOperateHistory", notes = "Create OmsOrderOperateHistory")
    @PostMapping
    public Result<Integer> create(@RequestBody OmsOrderOperateHistoryDOV1 omsOrderOperateHistory) {
        int row = omsOrderOperateHistoryServiceV1.save(omsOrderOperateHistory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate OmsOrderOperateHistory", notes = "batchCreate OmsOrderOperateHistory")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<OmsOrderOperateHistoryDOV1> omsOrderOperateHistorys) {
        int rows = omsOrderOperateHistoryServiceV1.save(omsOrderOperateHistorys);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById OmsOrderOperateHistory", notes = "findById OmsOrderOperateHistory")
    @GetMapping("/{id}")
    public Result<OmsOrderOperateHistoryDOV1> findById(@PathVariable Integer id) {
        OmsOrderOperateHistoryDOV1 omsOrderOperateHistory = omsOrderOperateHistoryServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(omsOrderOperateHistory);
    }

    @ApiOperation(value = "findByIds OmsOrderOperateHistory", notes = "findByIds OmsOrderOperateHistory")
    @GetMapping("/findByIds/{ids}")
    public Result<List<OmsOrderOperateHistoryDOV1>> findByIds(@PathVariable String ids) {
        List<OmsOrderOperateHistoryDOV1> omsOrderOperateHistorys = omsOrderOperateHistoryServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(omsOrderOperateHistorys);
    }

    @ApiOperation(value = "findByField OmsOrderOperateHistory", notes = "findByField OmsOrderOperateHistory")
    @GetMapping("/findByField/{field}/{value}")
    public Result<OmsOrderOperateHistoryDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        OmsOrderOperateHistoryDOV1 omsOrderOperateHistory = omsOrderOperateHistoryServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(omsOrderOperateHistory);
    }

    @ApiOperation(value = "findAll OmsOrderOperateHistory", notes = "findAll OmsOrderOperateHistory")
    @GetMapping("/findAll")
    public Result<PageInfo<OmsOrderOperateHistoryDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<OmsOrderOperateHistoryDOV1> list = omsOrderOperateHistoryServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition OmsOrderOperateHistory", notes = "listByCondition OmsOrderOperateHistory")
    @PostMapping("/listByCondition")
    public Result<PageInfo<OmsOrderOperateHistoryDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(OmsOrderOperateHistoryDOV1.class);
        List<OmsOrderOperateHistoryDOV1> list = omsOrderOperateHistoryServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update OmsOrderOperateHistory", notes = "update OmsOrderOperateHistory")
    @PutMapping
    public Result<Integer> update(@RequestBody OmsOrderOperateHistoryDOV1 omsOrderOperateHistory) {
        int row = omsOrderOperateHistoryServiceV1.update(omsOrderOperateHistory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition OmsOrderOperateHistory", notes = "updateByCondition OmsOrderOperateHistory")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<OmsOrderOperateHistoryDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(OmsOrderOperateHistoryDOV1.class);
        int rows = omsOrderOperateHistoryServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete OmsOrderOperateHistory", notes = "delete OmsOrderOperateHistory")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = omsOrderOperateHistoryServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds OmsOrderOperateHistory", notes = "deleteByIds OmsOrderOperateHistory")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = omsOrderOperateHistoryServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition OmsOrderOperateHistory", notes = "deleteByCondition OmsOrderOperateHistory")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderOperateHistoryDOV1.class);
        int rows = omsOrderOperateHistoryServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count OmsOrderOperateHistory", notes = "count OmsOrderOperateHistory")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderOperateHistoryDOV1.class);
        int count = omsOrderOperateHistoryServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}