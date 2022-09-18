package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsSubjectCategoryDOV1;
import com.liufei.mall.seed.service.CmsSubjectCategoryServiceV1;

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
* @description CmsSubjectCategory controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/subject/category")
public class CmsSubjectCategoryControllerV1 {

    @Resource
    private CmsSubjectCategoryServiceV1 cmsSubjectCategoryServiceV1;

    @ApiOperation(value = "Create CmsSubjectCategory", notes = "Create CmsSubjectCategory")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsSubjectCategoryDOV1 cmsSubjectCategory) {
        int row = cmsSubjectCategoryServiceV1.save(cmsSubjectCategory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsSubjectCategory", notes = "batchCreate CmsSubjectCategory")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsSubjectCategoryDOV1> cmsSubjectCategorys) {
        int rows = cmsSubjectCategoryServiceV1.save(cmsSubjectCategorys);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsSubjectCategory", notes = "findById CmsSubjectCategory")
    @GetMapping("/{id}")
    public Result<CmsSubjectCategoryDOV1> findById(@PathVariable Integer id) {
        CmsSubjectCategoryDOV1 cmsSubjectCategory = cmsSubjectCategoryServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsSubjectCategory);
    }

    @ApiOperation(value = "findByIds CmsSubjectCategory", notes = "findByIds CmsSubjectCategory")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsSubjectCategoryDOV1>> findByIds(@PathVariable String ids) {
        List<CmsSubjectCategoryDOV1> cmsSubjectCategorys = cmsSubjectCategoryServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsSubjectCategorys);
    }

    @ApiOperation(value = "findByField CmsSubjectCategory", notes = "findByField CmsSubjectCategory")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsSubjectCategoryDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsSubjectCategoryDOV1 cmsSubjectCategory = cmsSubjectCategoryServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsSubjectCategory);
    }

    @ApiOperation(value = "findAll CmsSubjectCategory", notes = "findAll CmsSubjectCategory")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsSubjectCategoryDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsSubjectCategoryDOV1> list = cmsSubjectCategoryServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsSubjectCategory", notes = "listByCondition CmsSubjectCategory")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsSubjectCategoryDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectCategoryDOV1.class);
        List<CmsSubjectCategoryDOV1> list = cmsSubjectCategoryServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsSubjectCategory", notes = "update CmsSubjectCategory")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsSubjectCategoryDOV1 cmsSubjectCategory) {
        int row = cmsSubjectCategoryServiceV1.update(cmsSubjectCategory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsSubjectCategory", notes = "updateByCondition CmsSubjectCategory")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsSubjectCategoryDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsSubjectCategoryDOV1.class);
        int rows = cmsSubjectCategoryServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsSubjectCategory", notes = "delete CmsSubjectCategory")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsSubjectCategoryServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsSubjectCategory", notes = "deleteByIds CmsSubjectCategory")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsSubjectCategoryServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsSubjectCategory", notes = "deleteByCondition CmsSubjectCategory")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectCategoryDOV1.class);
        int rows = cmsSubjectCategoryServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsSubjectCategory", notes = "count CmsSubjectCategory")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectCategoryDOV1.class);
        int count = cmsSubjectCategoryServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}