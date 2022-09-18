package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsHelpCategoryDOV1;
import com.liufei.mall.seed.service.CmsHelpCategoryServiceV1;

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
* @description CmsHelpCategory controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/help/category")
public class CmsHelpCategoryControllerV1 {

    @Resource
    private CmsHelpCategoryServiceV1 cmsHelpCategoryServiceV1;

    @ApiOperation(value = "Create CmsHelpCategory", notes = "Create CmsHelpCategory")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsHelpCategoryDOV1 cmsHelpCategory) {
        int row = cmsHelpCategoryServiceV1.save(cmsHelpCategory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsHelpCategory", notes = "batchCreate CmsHelpCategory")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsHelpCategoryDOV1> cmsHelpCategorys) {
        int rows = cmsHelpCategoryServiceV1.save(cmsHelpCategorys);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsHelpCategory", notes = "findById CmsHelpCategory")
    @GetMapping("/{id}")
    public Result<CmsHelpCategoryDOV1> findById(@PathVariable Integer id) {
        CmsHelpCategoryDOV1 cmsHelpCategory = cmsHelpCategoryServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsHelpCategory);
    }

    @ApiOperation(value = "findByIds CmsHelpCategory", notes = "findByIds CmsHelpCategory")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsHelpCategoryDOV1>> findByIds(@PathVariable String ids) {
        List<CmsHelpCategoryDOV1> cmsHelpCategorys = cmsHelpCategoryServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsHelpCategorys);
    }

    @ApiOperation(value = "findByField CmsHelpCategory", notes = "findByField CmsHelpCategory")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsHelpCategoryDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsHelpCategoryDOV1 cmsHelpCategory = cmsHelpCategoryServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsHelpCategory);
    }

    @ApiOperation(value = "findAll CmsHelpCategory", notes = "findAll CmsHelpCategory")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsHelpCategoryDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsHelpCategoryDOV1> list = cmsHelpCategoryServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsHelpCategory", notes = "listByCondition CmsHelpCategory")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsHelpCategoryDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsHelpCategoryDOV1.class);
        List<CmsHelpCategoryDOV1> list = cmsHelpCategoryServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsHelpCategory", notes = "update CmsHelpCategory")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsHelpCategoryDOV1 cmsHelpCategory) {
        int row = cmsHelpCategoryServiceV1.update(cmsHelpCategory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsHelpCategory", notes = "updateByCondition CmsHelpCategory")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsHelpCategoryDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsHelpCategoryDOV1.class);
        int rows = cmsHelpCategoryServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsHelpCategory", notes = "delete CmsHelpCategory")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsHelpCategoryServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsHelpCategory", notes = "deleteByIds CmsHelpCategory")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsHelpCategoryServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsHelpCategory", notes = "deleteByCondition CmsHelpCategory")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsHelpCategoryDOV1.class);
        int rows = cmsHelpCategoryServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsHelpCategory", notes = "count CmsHelpCategory")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsHelpCategoryDOV1.class);
        int count = cmsHelpCategoryServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}