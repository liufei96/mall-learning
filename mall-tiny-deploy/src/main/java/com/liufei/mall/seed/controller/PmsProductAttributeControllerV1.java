package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsProductAttributeDOV1;
import com.liufei.mall.seed.service.PmsProductAttributeServiceV1;

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
* @description PmsProductAttribute controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/product/attribute")
public class PmsProductAttributeControllerV1 {

    @Resource
    private PmsProductAttributeServiceV1 pmsProductAttributeServiceV1;

    @ApiOperation(value = "Create PmsProductAttribute", notes = "Create PmsProductAttribute")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsProductAttributeDOV1 pmsProductAttribute) {
        int row = pmsProductAttributeServiceV1.save(pmsProductAttribute);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsProductAttribute", notes = "batchCreate PmsProductAttribute")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsProductAttributeDOV1> pmsProductAttributes) {
        int rows = pmsProductAttributeServiceV1.save(pmsProductAttributes);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsProductAttribute", notes = "findById PmsProductAttribute")
    @GetMapping("/{id}")
    public Result<PmsProductAttributeDOV1> findById(@PathVariable Integer id) {
        PmsProductAttributeDOV1 pmsProductAttribute = pmsProductAttributeServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsProductAttribute);
    }

    @ApiOperation(value = "findByIds PmsProductAttribute", notes = "findByIds PmsProductAttribute")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsProductAttributeDOV1>> findByIds(@PathVariable String ids) {
        List<PmsProductAttributeDOV1> pmsProductAttributes = pmsProductAttributeServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsProductAttributes);
    }

    @ApiOperation(value = "findByField PmsProductAttribute", notes = "findByField PmsProductAttribute")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsProductAttributeDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsProductAttributeDOV1 pmsProductAttribute = pmsProductAttributeServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsProductAttribute);
    }

    @ApiOperation(value = "findAll PmsProductAttribute", notes = "findAll PmsProductAttribute")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsProductAttributeDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsProductAttributeDOV1> list = pmsProductAttributeServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsProductAttribute", notes = "listByCondition PmsProductAttribute")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsProductAttributeDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsProductAttributeDOV1.class);
        List<PmsProductAttributeDOV1> list = pmsProductAttributeServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsProductAttribute", notes = "update PmsProductAttribute")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsProductAttributeDOV1 pmsProductAttribute) {
        int row = pmsProductAttributeServiceV1.update(pmsProductAttribute);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsProductAttribute", notes = "updateByCondition PmsProductAttribute")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsProductAttributeDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsProductAttributeDOV1.class);
        int rows = pmsProductAttributeServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsProductAttribute", notes = "delete PmsProductAttribute")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsProductAttributeServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsProductAttribute", notes = "deleteByIds PmsProductAttribute")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsProductAttributeServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsProductAttribute", notes = "deleteByCondition PmsProductAttribute")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductAttributeDOV1.class);
        int rows = pmsProductAttributeServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsProductAttribute", notes = "count PmsProductAttribute")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductAttributeDOV1.class);
        int count = pmsProductAttributeServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}