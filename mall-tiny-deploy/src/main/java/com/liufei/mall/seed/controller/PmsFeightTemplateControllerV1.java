package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsFeightTemplateDOV1;
import com.liufei.mall.seed.service.PmsFeightTemplateServiceV1;

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
* @description PmsFeightTemplate controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/feight/template")
public class PmsFeightTemplateControllerV1 {

    @Resource
    private PmsFeightTemplateServiceV1 pmsFeightTemplateServiceV1;

    @ApiOperation(value = "Create PmsFeightTemplate", notes = "Create PmsFeightTemplate")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsFeightTemplateDOV1 pmsFeightTemplate) {
        int row = pmsFeightTemplateServiceV1.save(pmsFeightTemplate);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsFeightTemplate", notes = "batchCreate PmsFeightTemplate")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsFeightTemplateDOV1> pmsFeightTemplates) {
        int rows = pmsFeightTemplateServiceV1.save(pmsFeightTemplates);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsFeightTemplate", notes = "findById PmsFeightTemplate")
    @GetMapping("/{id}")
    public Result<PmsFeightTemplateDOV1> findById(@PathVariable Integer id) {
        PmsFeightTemplateDOV1 pmsFeightTemplate = pmsFeightTemplateServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsFeightTemplate);
    }

    @ApiOperation(value = "findByIds PmsFeightTemplate", notes = "findByIds PmsFeightTemplate")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsFeightTemplateDOV1>> findByIds(@PathVariable String ids) {
        List<PmsFeightTemplateDOV1> pmsFeightTemplates = pmsFeightTemplateServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsFeightTemplates);
    }

    @ApiOperation(value = "findByField PmsFeightTemplate", notes = "findByField PmsFeightTemplate")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsFeightTemplateDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsFeightTemplateDOV1 pmsFeightTemplate = pmsFeightTemplateServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsFeightTemplate);
    }

    @ApiOperation(value = "findAll PmsFeightTemplate", notes = "findAll PmsFeightTemplate")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsFeightTemplateDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsFeightTemplateDOV1> list = pmsFeightTemplateServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsFeightTemplate", notes = "listByCondition PmsFeightTemplate")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsFeightTemplateDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsFeightTemplateDOV1.class);
        List<PmsFeightTemplateDOV1> list = pmsFeightTemplateServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsFeightTemplate", notes = "update PmsFeightTemplate")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsFeightTemplateDOV1 pmsFeightTemplate) {
        int row = pmsFeightTemplateServiceV1.update(pmsFeightTemplate);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsFeightTemplate", notes = "updateByCondition PmsFeightTemplate")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsFeightTemplateDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsFeightTemplateDOV1.class);
        int rows = pmsFeightTemplateServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsFeightTemplate", notes = "delete PmsFeightTemplate")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsFeightTemplateServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsFeightTemplate", notes = "deleteByIds PmsFeightTemplate")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsFeightTemplateServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsFeightTemplate", notes = "deleteByCondition PmsFeightTemplate")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsFeightTemplateDOV1.class);
        int rows = pmsFeightTemplateServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsFeightTemplate", notes = "count PmsFeightTemplate")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsFeightTemplateDOV1.class);
        int count = pmsFeightTemplateServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}