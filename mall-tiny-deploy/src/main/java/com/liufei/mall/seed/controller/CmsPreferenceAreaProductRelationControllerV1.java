package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsPreferenceAreaProductRelationDOV1;
import com.liufei.mall.seed.service.CmsPreferenceAreaProductRelationServiceV1;

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
* @description CmsPreferenceAreaProductRelation controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/preference/area/product/relation")
public class CmsPreferenceAreaProductRelationControllerV1 {

    @Resource
    private CmsPreferenceAreaProductRelationServiceV1 cmsPreferenceAreaProductRelationServiceV1;

    @ApiOperation(value = "Create CmsPreferenceAreaProductRelation", notes = "Create CmsPreferenceAreaProductRelation")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsPreferenceAreaProductRelationDOV1 cmsPreferenceAreaProductRelation) {
        int row = cmsPreferenceAreaProductRelationServiceV1.save(cmsPreferenceAreaProductRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsPreferenceAreaProductRelation", notes = "batchCreate CmsPreferenceAreaProductRelation")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsPreferenceAreaProductRelationDOV1> cmsPreferenceAreaProductRelations) {
        int rows = cmsPreferenceAreaProductRelationServiceV1.save(cmsPreferenceAreaProductRelations);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsPreferenceAreaProductRelation", notes = "findById CmsPreferenceAreaProductRelation")
    @GetMapping("/{id}")
    public Result<CmsPreferenceAreaProductRelationDOV1> findById(@PathVariable Integer id) {
        CmsPreferenceAreaProductRelationDOV1 cmsPreferenceAreaProductRelation = cmsPreferenceAreaProductRelationServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsPreferenceAreaProductRelation);
    }

    @ApiOperation(value = "findByIds CmsPreferenceAreaProductRelation", notes = "findByIds CmsPreferenceAreaProductRelation")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsPreferenceAreaProductRelationDOV1>> findByIds(@PathVariable String ids) {
        List<CmsPreferenceAreaProductRelationDOV1> cmsPreferenceAreaProductRelations = cmsPreferenceAreaProductRelationServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsPreferenceAreaProductRelations);
    }

    @ApiOperation(value = "findByField CmsPreferenceAreaProductRelation", notes = "findByField CmsPreferenceAreaProductRelation")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsPreferenceAreaProductRelationDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsPreferenceAreaProductRelationDOV1 cmsPreferenceAreaProductRelation = cmsPreferenceAreaProductRelationServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsPreferenceAreaProductRelation);
    }

    @ApiOperation(value = "findAll CmsPreferenceAreaProductRelation", notes = "findAll CmsPreferenceAreaProductRelation")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsPreferenceAreaProductRelationDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsPreferenceAreaProductRelationDOV1> list = cmsPreferenceAreaProductRelationServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsPreferenceAreaProductRelation", notes = "listByCondition CmsPreferenceAreaProductRelation")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsPreferenceAreaProductRelationDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsPreferenceAreaProductRelationDOV1.class);
        List<CmsPreferenceAreaProductRelationDOV1> list = cmsPreferenceAreaProductRelationServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsPreferenceAreaProductRelation", notes = "update CmsPreferenceAreaProductRelation")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsPreferenceAreaProductRelationDOV1 cmsPreferenceAreaProductRelation) {
        int row = cmsPreferenceAreaProductRelationServiceV1.update(cmsPreferenceAreaProductRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsPreferenceAreaProductRelation", notes = "updateByCondition CmsPreferenceAreaProductRelation")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsPreferenceAreaProductRelationDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsPreferenceAreaProductRelationDOV1.class);
        int rows = cmsPreferenceAreaProductRelationServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsPreferenceAreaProductRelation", notes = "delete CmsPreferenceAreaProductRelation")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsPreferenceAreaProductRelationServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsPreferenceAreaProductRelation", notes = "deleteByIds CmsPreferenceAreaProductRelation")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsPreferenceAreaProductRelationServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsPreferenceAreaProductRelation", notes = "deleteByCondition CmsPreferenceAreaProductRelation")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsPreferenceAreaProductRelationDOV1.class);
        int rows = cmsPreferenceAreaProductRelationServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsPreferenceAreaProductRelation", notes = "count CmsPreferenceAreaProductRelation")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsPreferenceAreaProductRelationDOV1.class);
        int count = cmsPreferenceAreaProductRelationServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}