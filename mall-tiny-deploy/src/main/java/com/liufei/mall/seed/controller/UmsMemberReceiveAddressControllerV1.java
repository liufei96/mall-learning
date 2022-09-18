package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsMemberReceiveAddressDOV1;
import com.liufei.mall.seed.service.UmsMemberReceiveAddressServiceV1;

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
* @description UmsMemberReceiveAddress controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/member/receive/address")
public class UmsMemberReceiveAddressControllerV1 {

    @Resource
    private UmsMemberReceiveAddressServiceV1 umsMemberReceiveAddressServiceV1;

    @ApiOperation(value = "Create UmsMemberReceiveAddress", notes = "Create UmsMemberReceiveAddress")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsMemberReceiveAddressDOV1 umsMemberReceiveAddress) {
        int row = umsMemberReceiveAddressServiceV1.save(umsMemberReceiveAddress);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsMemberReceiveAddress", notes = "batchCreate UmsMemberReceiveAddress")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsMemberReceiveAddressDOV1> umsMemberReceiveAddresss) {
        int rows = umsMemberReceiveAddressServiceV1.save(umsMemberReceiveAddresss);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsMemberReceiveAddress", notes = "findById UmsMemberReceiveAddress")
    @GetMapping("/{id}")
    public Result<UmsMemberReceiveAddressDOV1> findById(@PathVariable Integer id) {
        UmsMemberReceiveAddressDOV1 umsMemberReceiveAddress = umsMemberReceiveAddressServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsMemberReceiveAddress);
    }

    @ApiOperation(value = "findByIds UmsMemberReceiveAddress", notes = "findByIds UmsMemberReceiveAddress")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsMemberReceiveAddressDOV1>> findByIds(@PathVariable String ids) {
        List<UmsMemberReceiveAddressDOV1> umsMemberReceiveAddresss = umsMemberReceiveAddressServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsMemberReceiveAddresss);
    }

    @ApiOperation(value = "findByField UmsMemberReceiveAddress", notes = "findByField UmsMemberReceiveAddress")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsMemberReceiveAddressDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsMemberReceiveAddressDOV1 umsMemberReceiveAddress = umsMemberReceiveAddressServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsMemberReceiveAddress);
    }

    @ApiOperation(value = "findAll UmsMemberReceiveAddress", notes = "findAll UmsMemberReceiveAddress")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsMemberReceiveAddressDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsMemberReceiveAddressDOV1> list = umsMemberReceiveAddressServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsMemberReceiveAddress", notes = "listByCondition UmsMemberReceiveAddress")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsMemberReceiveAddressDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsMemberReceiveAddressDOV1.class);
        List<UmsMemberReceiveAddressDOV1> list = umsMemberReceiveAddressServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsMemberReceiveAddress", notes = "update UmsMemberReceiveAddress")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsMemberReceiveAddressDOV1 umsMemberReceiveAddress) {
        int row = umsMemberReceiveAddressServiceV1.update(umsMemberReceiveAddress);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsMemberReceiveAddress", notes = "updateByCondition UmsMemberReceiveAddress")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsMemberReceiveAddressDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsMemberReceiveAddressDOV1.class);
        int rows = umsMemberReceiveAddressServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsMemberReceiveAddress", notes = "delete UmsMemberReceiveAddress")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsMemberReceiveAddressServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsMemberReceiveAddress", notes = "deleteByIds UmsMemberReceiveAddress")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsMemberReceiveAddressServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsMemberReceiveAddress", notes = "deleteByCondition UmsMemberReceiveAddress")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberReceiveAddressDOV1.class);
        int rows = umsMemberReceiveAddressServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsMemberReceiveAddress", notes = "count UmsMemberReceiveAddress")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsMemberReceiveAddressDOV1.class);
        int count = umsMemberReceiveAddressServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}