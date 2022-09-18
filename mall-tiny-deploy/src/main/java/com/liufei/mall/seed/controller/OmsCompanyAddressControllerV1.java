package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.OmsCompanyAddressDOV1;
import com.liufei.mall.seed.service.OmsCompanyAddressServiceV1;

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
* @description OmsCompanyAddress controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/oms/company/address")
public class OmsCompanyAddressControllerV1 {

    @Resource
    private OmsCompanyAddressServiceV1 omsCompanyAddressServiceV1;

    @ApiOperation(value = "Create OmsCompanyAddress", notes = "Create OmsCompanyAddress")
    @PostMapping
    public Result<Integer> create(@RequestBody OmsCompanyAddressDOV1 omsCompanyAddress) {
        int row = omsCompanyAddressServiceV1.save(omsCompanyAddress);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate OmsCompanyAddress", notes = "batchCreate OmsCompanyAddress")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<OmsCompanyAddressDOV1> omsCompanyAddresss) {
        int rows = omsCompanyAddressServiceV1.save(omsCompanyAddresss);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById OmsCompanyAddress", notes = "findById OmsCompanyAddress")
    @GetMapping("/{id}")
    public Result<OmsCompanyAddressDOV1> findById(@PathVariable Integer id) {
        OmsCompanyAddressDOV1 omsCompanyAddress = omsCompanyAddressServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(omsCompanyAddress);
    }

    @ApiOperation(value = "findByIds OmsCompanyAddress", notes = "findByIds OmsCompanyAddress")
    @GetMapping("/findByIds/{ids}")
    public Result<List<OmsCompanyAddressDOV1>> findByIds(@PathVariable String ids) {
        List<OmsCompanyAddressDOV1> omsCompanyAddresss = omsCompanyAddressServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(omsCompanyAddresss);
    }

    @ApiOperation(value = "findByField OmsCompanyAddress", notes = "findByField OmsCompanyAddress")
    @GetMapping("/findByField/{field}/{value}")
    public Result<OmsCompanyAddressDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        OmsCompanyAddressDOV1 omsCompanyAddress = omsCompanyAddressServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(omsCompanyAddress);
    }

    @ApiOperation(value = "findAll OmsCompanyAddress", notes = "findAll OmsCompanyAddress")
    @GetMapping("/findAll")
    public Result<PageInfo<OmsCompanyAddressDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<OmsCompanyAddressDOV1> list = omsCompanyAddressServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition OmsCompanyAddress", notes = "listByCondition OmsCompanyAddress")
    @PostMapping("/listByCondition")
    public Result<PageInfo<OmsCompanyAddressDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(OmsCompanyAddressDOV1.class);
        List<OmsCompanyAddressDOV1> list = omsCompanyAddressServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update OmsCompanyAddress", notes = "update OmsCompanyAddress")
    @PutMapping
    public Result<Integer> update(@RequestBody OmsCompanyAddressDOV1 omsCompanyAddress) {
        int row = omsCompanyAddressServiceV1.update(omsCompanyAddress);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition OmsCompanyAddress", notes = "updateByCondition OmsCompanyAddress")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<OmsCompanyAddressDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(OmsCompanyAddressDOV1.class);
        int rows = omsCompanyAddressServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete OmsCompanyAddress", notes = "delete OmsCompanyAddress")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = omsCompanyAddressServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds OmsCompanyAddress", notes = "deleteByIds OmsCompanyAddress")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = omsCompanyAddressServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition OmsCompanyAddress", notes = "deleteByCondition OmsCompanyAddress")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsCompanyAddressDOV1.class);
        int rows = omsCompanyAddressServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count OmsCompanyAddress", notes = "count OmsCompanyAddress")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(OmsCompanyAddressDOV1.class);
        int count = omsCompanyAddressServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}