package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsTopicCategoryDOV1;
import com.liufei.mall.seed.service.CmsTopicCategoryServiceV1;

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
* @description CmsTopicCategory controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/topic/category")
public class CmsTopicCategoryControllerV1 {

    @Resource
    private CmsTopicCategoryServiceV1 cmsTopicCategoryServiceV1;

    @ApiOperation(value = "Create CmsTopicCategory", notes = "Create CmsTopicCategory")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsTopicCategoryDOV1 cmsTopicCategory) {
        int row = cmsTopicCategoryServiceV1.save(cmsTopicCategory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsTopicCategory", notes = "batchCreate CmsTopicCategory")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsTopicCategoryDOV1> cmsTopicCategorys) {
        int rows = cmsTopicCategoryServiceV1.save(cmsTopicCategorys);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsTopicCategory", notes = "findById CmsTopicCategory")
    @GetMapping("/{id}")
    public Result<CmsTopicCategoryDOV1> findById(@PathVariable Integer id) {
        CmsTopicCategoryDOV1 cmsTopicCategory = cmsTopicCategoryServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsTopicCategory);
    }

    @ApiOperation(value = "findByIds CmsTopicCategory", notes = "findByIds CmsTopicCategory")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsTopicCategoryDOV1>> findByIds(@PathVariable String ids) {
        List<CmsTopicCategoryDOV1> cmsTopicCategorys = cmsTopicCategoryServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsTopicCategorys);
    }

    @ApiOperation(value = "findByField CmsTopicCategory", notes = "findByField CmsTopicCategory")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsTopicCategoryDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsTopicCategoryDOV1 cmsTopicCategory = cmsTopicCategoryServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsTopicCategory);
    }

    @ApiOperation(value = "findAll CmsTopicCategory", notes = "findAll CmsTopicCategory")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsTopicCategoryDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsTopicCategoryDOV1> list = cmsTopicCategoryServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsTopicCategory", notes = "listByCondition CmsTopicCategory")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsTopicCategoryDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsTopicCategoryDOV1.class);
        List<CmsTopicCategoryDOV1> list = cmsTopicCategoryServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsTopicCategory", notes = "update CmsTopicCategory")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsTopicCategoryDOV1 cmsTopicCategory) {
        int row = cmsTopicCategoryServiceV1.update(cmsTopicCategory);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsTopicCategory", notes = "updateByCondition CmsTopicCategory")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsTopicCategoryDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsTopicCategoryDOV1.class);
        int rows = cmsTopicCategoryServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsTopicCategory", notes = "delete CmsTopicCategory")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsTopicCategoryServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsTopicCategory", notes = "deleteByIds CmsTopicCategory")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsTopicCategoryServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsTopicCategory", notes = "deleteByCondition CmsTopicCategory")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsTopicCategoryDOV1.class);
        int rows = cmsTopicCategoryServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsTopicCategory", notes = "count CmsTopicCategory")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsTopicCategoryDOV1.class);
        int count = cmsTopicCategoryServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}