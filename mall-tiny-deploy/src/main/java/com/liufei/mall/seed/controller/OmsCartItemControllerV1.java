package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.OmsCartItemDOV1;
import com.liufei.mall.seed.service.OmsCartItemServiceV1;

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
* @description OmsCartItem controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/oms/cart/item")
public class OmsCartItemControllerV1 {

    @Resource
    private OmsCartItemServiceV1 omsCartItemServiceV1;

    @ApiOperation(value = "Create OmsCartItem", notes = "Create OmsCartItem")
    @PostMapping
    public Result<Integer> create(@RequestBody OmsCartItemDOV1 omsCartItem) {
        int row = omsCartItemServiceV1.save(omsCartItem);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate OmsCartItem", notes = "batchCreate OmsCartItem")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<OmsCartItemDOV1> omsCartItems) {
        int rows = omsCartItemServiceV1.save(omsCartItems);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById OmsCartItem", notes = "findById OmsCartItem")
    @GetMapping("/{id}")
    public Result<OmsCartItemDOV1> findById(@PathVariable Integer id) {
        OmsCartItemDOV1 omsCartItem = omsCartItemServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(omsCartItem);
    }

    @ApiOperation(value = "findByIds OmsCartItem", notes = "findByIds OmsCartItem")
    @GetMapping("/findByIds/{ids}")
    public Result<List<OmsCartItemDOV1>> findByIds(@PathVariable String ids) {
        List<OmsCartItemDOV1> omsCartItems = omsCartItemServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(omsCartItems);
    }

    @ApiOperation(value = "findByField OmsCartItem", notes = "findByField OmsCartItem")
    @GetMapping("/findByField/{field}/{value}")
    public Result<OmsCartItemDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        OmsCartItemDOV1 omsCartItem = omsCartItemServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(omsCartItem);
    }

    @ApiOperation(value = "findAll OmsCartItem", notes = "findAll OmsCartItem")
    @GetMapping("/findAll")
    public Result<PageInfo<OmsCartItemDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<OmsCartItemDOV1> list = omsCartItemServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition OmsCartItem", notes = "listByCondition OmsCartItem")
    @PostMapping("/listByCondition")
    public Result<PageInfo<OmsCartItemDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(OmsCartItemDOV1.class);
        List<OmsCartItemDOV1> list = omsCartItemServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update OmsCartItem", notes = "update OmsCartItem")
    @PutMapping
    public Result<Integer> update(@RequestBody OmsCartItemDOV1 omsCartItem) {
        int row = omsCartItemServiceV1.update(omsCartItem);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition OmsCartItem", notes = "updateByCondition OmsCartItem")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<OmsCartItemDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(OmsCartItemDOV1.class);
        int rows = omsCartItemServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete OmsCartItem", notes = "delete OmsCartItem")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = omsCartItemServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds OmsCartItem", notes = "deleteByIds OmsCartItem")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = omsCartItemServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition OmsCartItem", notes = "deleteByCondition OmsCartItem")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsCartItemDOV1.class);
        int rows = omsCartItemServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count OmsCartItem", notes = "count OmsCartItem")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsCartItemDOV1.class);
        int count = omsCartItemServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}