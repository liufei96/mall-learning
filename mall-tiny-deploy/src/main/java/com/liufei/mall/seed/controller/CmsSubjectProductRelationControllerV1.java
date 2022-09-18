package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsSubjectProductRelationDOV1;
import com.liufei.mall.seed.service.CmsSubjectProductRelationServiceV1;

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
* @description CmsSubjectProductRelation controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/subject/product/relation")
public class CmsSubjectProductRelationControllerV1 {

    @Resource
    private CmsSubjectProductRelationServiceV1 cmsSubjectProductRelationServiceV1;

    @ApiOperation(value = "Create CmsSubjectProductRelation", notes = "Create CmsSubjectProductRelation")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsSubjectProductRelationDOV1 cmsSubjectProductRelation) {
        int row = cmsSubjectProductRelationServiceV1.save(cmsSubjectProductRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsSubjectProductRelation", notes = "batchCreate CmsSubjectProductRelation")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsSubjectProductRelationDOV1> cmsSubjectProductRelations) {
        int rows = cmsSubjectProductRelationServiceV1.save(cmsSubjectProductRelations);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsSubjectProductRelation", notes = "findById CmsSubjectProductRelation")
    @GetMapping("/{id}")
    public Result<CmsSubjectProductRelationDOV1> findById(@PathVariable Integer id) {
        CmsSubjectProductRelationDOV1 cmsSubjectProductRelation = cmsSubjectProductRelationServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsSubjectProductRelation);
    }

    @ApiOperation(value = "findByIds CmsSubjectProductRelation", notes = "findByIds CmsSubjectProductRelation")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsSubjectProductRelationDOV1>> findByIds(@PathVariable String ids) {
        List<CmsSubjectProductRelationDOV1> cmsSubjectProductRelations = cmsSubjectProductRelationServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsSubjectProductRelations);
    }

    @ApiOperation(value = "findByField CmsSubjectProductRelation", notes = "findByField CmsSubjectProductRelation")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsSubjectProductRelationDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsSubjectProductRelationDOV1 cmsSubjectProductRelation = cmsSubjectProductRelationServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsSubjectProductRelation);
    }

    @ApiOperation(value = "findAll CmsSubjectProductRelation", notes = "findAll CmsSubjectProductRelation")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsSubjectProductRelationDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsSubjectProductRelationDOV1> list = cmsSubjectProductRelationServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsSubjectProductRelation", notes = "listByCondition CmsSubjectProductRelation")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsSubjectProductRelationDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectProductRelationDOV1.class);
        List<CmsSubjectProductRelationDOV1> list = cmsSubjectProductRelationServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsSubjectProductRelation", notes = "update CmsSubjectProductRelation")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsSubjectProductRelationDOV1 cmsSubjectProductRelation) {
        int row = cmsSubjectProductRelationServiceV1.update(cmsSubjectProductRelation);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsSubjectProductRelation", notes = "updateByCondition CmsSubjectProductRelation")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsSubjectProductRelationDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsSubjectProductRelationDOV1.class);
        int rows = cmsSubjectProductRelationServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsSubjectProductRelation", notes = "delete CmsSubjectProductRelation")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsSubjectProductRelationServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsSubjectProductRelation", notes = "deleteByIds CmsSubjectProductRelation")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsSubjectProductRelationServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsSubjectProductRelation", notes = "deleteByCondition CmsSubjectProductRelation")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectProductRelationDOV1.class);
        int rows = cmsSubjectProductRelationServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsSubjectProductRelation", notes = "count CmsSubjectProductRelation")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectProductRelationDOV1.class);
        int count = cmsSubjectProductRelationServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}