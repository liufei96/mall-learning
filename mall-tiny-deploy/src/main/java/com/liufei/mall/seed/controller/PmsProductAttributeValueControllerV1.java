package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsProductAttributeValueDOV1;
import com.liufei.mall.seed.service.PmsProductAttributeValueServiceV1;

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
* @description PmsProductAttributeValue controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/product/attribute/value")
public class PmsProductAttributeValueControllerV1 {

    @Resource
    private PmsProductAttributeValueServiceV1 pmsProductAttributeValueServiceV1;

    @ApiOperation(value = "Create PmsProductAttributeValue", notes = "Create PmsProductAttributeValue")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsProductAttributeValueDOV1 pmsProductAttributeValue) {
        int row = pmsProductAttributeValueServiceV1.save(pmsProductAttributeValue);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsProductAttributeValue", notes = "batchCreate PmsProductAttributeValue")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsProductAttributeValueDOV1> pmsProductAttributeValues) {
        int rows = pmsProductAttributeValueServiceV1.save(pmsProductAttributeValues);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsProductAttributeValue", notes = "findById PmsProductAttributeValue")
    @GetMapping("/{id}")
    public Result<PmsProductAttributeValueDOV1> findById(@PathVariable Integer id) {
        PmsProductAttributeValueDOV1 pmsProductAttributeValue = pmsProductAttributeValueServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsProductAttributeValue);
    }

    @ApiOperation(value = "findByIds PmsProductAttributeValue", notes = "findByIds PmsProductAttributeValue")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsProductAttributeValueDOV1>> findByIds(@PathVariable String ids) {
        List<PmsProductAttributeValueDOV1> pmsProductAttributeValues = pmsProductAttributeValueServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsProductAttributeValues);
    }

    @ApiOperation(value = "findByField PmsProductAttributeValue", notes = "findByField PmsProductAttributeValue")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsProductAttributeValueDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsProductAttributeValueDOV1 pmsProductAttributeValue = pmsProductAttributeValueServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsProductAttributeValue);
    }

    @ApiOperation(value = "findAll PmsProductAttributeValue", notes = "findAll PmsProductAttributeValue")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsProductAttributeValueDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsProductAttributeValueDOV1> list = pmsProductAttributeValueServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsProductAttributeValue", notes = "listByCondition PmsProductAttributeValue")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsProductAttributeValueDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsProductAttributeValueDOV1.class);
        List<PmsProductAttributeValueDOV1> list = pmsProductAttributeValueServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsProductAttributeValue", notes = "update PmsProductAttributeValue")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsProductAttributeValueDOV1 pmsProductAttributeValue) {
        int row = pmsProductAttributeValueServiceV1.update(pmsProductAttributeValue);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsProductAttributeValue", notes = "updateByCondition PmsProductAttributeValue")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsProductAttributeValueDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsProductAttributeValueDOV1.class);
        int rows = pmsProductAttributeValueServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsProductAttributeValue", notes = "delete PmsProductAttributeValue")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsProductAttributeValueServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsProductAttributeValue", notes = "deleteByIds PmsProductAttributeValue")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsProductAttributeValueServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsProductAttributeValue", notes = "deleteByCondition PmsProductAttributeValue")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductAttributeValueDOV1.class);
        int rows = pmsProductAttributeValueServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsProductAttributeValue", notes = "count PmsProductAttributeValue")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsProductAttributeValueDOV1.class);
        int count = pmsProductAttributeValueServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}