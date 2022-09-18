package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsSubjectDOV1;
import com.liufei.mall.seed.service.CmsSubjectServiceV1;

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
* @description CmsSubject controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/subject")
public class CmsSubjectControllerV1 {

    @Resource
    private CmsSubjectServiceV1 cmsSubjectServiceV1;

    @ApiOperation(value = "Create CmsSubject", notes = "Create CmsSubject")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsSubjectDOV1 cmsSubject) {
        int row = cmsSubjectServiceV1.save(cmsSubject);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsSubject", notes = "batchCreate CmsSubject")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsSubjectDOV1> cmsSubjects) {
        int rows = cmsSubjectServiceV1.save(cmsSubjects);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsSubject", notes = "findById CmsSubject")
    @GetMapping("/{id}")
    public Result<CmsSubjectDOV1> findById(@PathVariable Integer id) {
        CmsSubjectDOV1 cmsSubject = cmsSubjectServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsSubject);
    }

    @ApiOperation(value = "findByIds CmsSubject", notes = "findByIds CmsSubject")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsSubjectDOV1>> findByIds(@PathVariable String ids) {
        List<CmsSubjectDOV1> cmsSubjects = cmsSubjectServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsSubjects);
    }

    @ApiOperation(value = "findByField CmsSubject", notes = "findByField CmsSubject")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsSubjectDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsSubjectDOV1 cmsSubject = cmsSubjectServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsSubject);
    }

    @ApiOperation(value = "findAll CmsSubject", notes = "findAll CmsSubject")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsSubjectDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsSubjectDOV1> list = cmsSubjectServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsSubject", notes = "listByCondition CmsSubject")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsSubjectDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectDOV1.class);
        List<CmsSubjectDOV1> list = cmsSubjectServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsSubject", notes = "update CmsSubject")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsSubjectDOV1 cmsSubject) {
        int row = cmsSubjectServiceV1.update(cmsSubject);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsSubject", notes = "updateByCondition CmsSubject")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsSubjectDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsSubjectDOV1.class);
        int rows = cmsSubjectServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsSubject", notes = "delete CmsSubject")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsSubjectServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsSubject", notes = "deleteByIds CmsSubject")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsSubjectServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsSubject", notes = "deleteByCondition CmsSubject")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectDOV1.class);
        int rows = cmsSubjectServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsSubject", notes = "count CmsSubject")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectDOV1.class);
        int count = cmsSubjectServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}