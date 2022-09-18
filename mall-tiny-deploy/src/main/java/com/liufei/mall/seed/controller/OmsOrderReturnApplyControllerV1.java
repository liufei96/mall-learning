package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.OmsOrderReturnApplyDOV1;
import com.liufei.mall.seed.service.OmsOrderReturnApplyServiceV1;

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
* @description OmsOrderReturnApply controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/oms/order/return/apply")
public class OmsOrderReturnApplyControllerV1 {

    @Resource
    private OmsOrderReturnApplyServiceV1 omsOrderReturnApplyServiceV1;

    @ApiOperation(value = "Create OmsOrderReturnApply", notes = "Create OmsOrderReturnApply")
    @PostMapping
    public Result<Integer> create(@RequestBody OmsOrderReturnApplyDOV1 omsOrderReturnApply) {
        int row = omsOrderReturnApplyServiceV1.save(omsOrderReturnApply);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate OmsOrderReturnApply", notes = "batchCreate OmsOrderReturnApply")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<OmsOrderReturnApplyDOV1> omsOrderReturnApplys) {
        int rows = omsOrderReturnApplyServiceV1.save(omsOrderReturnApplys);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById OmsOrderReturnApply", notes = "findById OmsOrderReturnApply")
    @GetMapping("/{id}")
    public Result<OmsOrderReturnApplyDOV1> findById(@PathVariable Integer id) {
        OmsOrderReturnApplyDOV1 omsOrderReturnApply = omsOrderReturnApplyServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(omsOrderReturnApply);
    }

    @ApiOperation(value = "findByIds OmsOrderReturnApply", notes = "findByIds OmsOrderReturnApply")
    @GetMapping("/findByIds/{ids}")
    public Result<List<OmsOrderReturnApplyDOV1>> findByIds(@PathVariable String ids) {
        List<OmsOrderReturnApplyDOV1> omsOrderReturnApplys = omsOrderReturnApplyServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(omsOrderReturnApplys);
    }

    @ApiOperation(value = "findByField OmsOrderReturnApply", notes = "findByField OmsOrderReturnApply")
    @GetMapping("/findByField/{field}/{value}")
    public Result<OmsOrderReturnApplyDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        OmsOrderReturnApplyDOV1 omsOrderReturnApply = omsOrderReturnApplyServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(omsOrderReturnApply);
    }

    @ApiOperation(value = "findAll OmsOrderReturnApply", notes = "findAll OmsOrderReturnApply")
    @GetMapping("/findAll")
    public Result<PageInfo<OmsOrderReturnApplyDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<OmsOrderReturnApplyDOV1> list = omsOrderReturnApplyServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition OmsOrderReturnApply", notes = "listByCondition OmsOrderReturnApply")
    @PostMapping("/listByCondition")
    public Result<PageInfo<OmsOrderReturnApplyDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(OmsOrderReturnApplyDOV1.class);
        List<OmsOrderReturnApplyDOV1> list = omsOrderReturnApplyServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update OmsOrderReturnApply", notes = "update OmsOrderReturnApply")
    @PutMapping
    public Result<Integer> update(@RequestBody OmsOrderReturnApplyDOV1 omsOrderReturnApply) {
        int row = omsOrderReturnApplyServiceV1.update(omsOrderReturnApply);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition OmsOrderReturnApply", notes = "updateByCondition OmsOrderReturnApply")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<OmsOrderReturnApplyDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(OmsOrderReturnApplyDOV1.class);
        int rows = omsOrderReturnApplyServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete OmsOrderReturnApply", notes = "delete OmsOrderReturnApply")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = omsOrderReturnApplyServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds OmsOrderReturnApply", notes = "deleteByIds OmsOrderReturnApply")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = omsOrderReturnApplyServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition OmsOrderReturnApply", notes = "deleteByCondition OmsOrderReturnApply")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderReturnApplyDOV1.class);
        int rows = omsOrderReturnApplyServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count OmsOrderReturnApply", notes = "count OmsOrderReturnApply")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsOrderReturnApplyDOV1.class);
        int count = omsOrderReturnApplyServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}