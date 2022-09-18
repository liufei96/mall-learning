package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsSubjectCommentDOV1;
import com.liufei.mall.seed.service.CmsSubjectCommentServiceV1;

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
* @description CmsSubjectComment controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/subject/comment")
public class CmsSubjectCommentControllerV1 {

    @Resource
    private CmsSubjectCommentServiceV1 cmsSubjectCommentServiceV1;

    @ApiOperation(value = "Create CmsSubjectComment", notes = "Create CmsSubjectComment")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsSubjectCommentDOV1 cmsSubjectComment) {
        int row = cmsSubjectCommentServiceV1.save(cmsSubjectComment);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsSubjectComment", notes = "batchCreate CmsSubjectComment")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsSubjectCommentDOV1> cmsSubjectComments) {
        int rows = cmsSubjectCommentServiceV1.save(cmsSubjectComments);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsSubjectComment", notes = "findById CmsSubjectComment")
    @GetMapping("/{id}")
    public Result<CmsSubjectCommentDOV1> findById(@PathVariable Integer id) {
        CmsSubjectCommentDOV1 cmsSubjectComment = cmsSubjectCommentServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsSubjectComment);
    }

    @ApiOperation(value = "findByIds CmsSubjectComment", notes = "findByIds CmsSubjectComment")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsSubjectCommentDOV1>> findByIds(@PathVariable String ids) {
        List<CmsSubjectCommentDOV1> cmsSubjectComments = cmsSubjectCommentServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsSubjectComments);
    }

    @ApiOperation(value = "findByField CmsSubjectComment", notes = "findByField CmsSubjectComment")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsSubjectCommentDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsSubjectCommentDOV1 cmsSubjectComment = cmsSubjectCommentServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsSubjectComment);
    }

    @ApiOperation(value = "findAll CmsSubjectComment", notes = "findAll CmsSubjectComment")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsSubjectCommentDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsSubjectCommentDOV1> list = cmsSubjectCommentServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsSubjectComment", notes = "listByCondition CmsSubjectComment")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsSubjectCommentDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectCommentDOV1.class);
        List<CmsSubjectCommentDOV1> list = cmsSubjectCommentServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsSubjectComment", notes = "update CmsSubjectComment")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsSubjectCommentDOV1 cmsSubjectComment) {
        int row = cmsSubjectCommentServiceV1.update(cmsSubjectComment);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsSubjectComment", notes = "updateByCondition CmsSubjectComment")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsSubjectCommentDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsSubjectCommentDOV1.class);
        int rows = cmsSubjectCommentServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsSubjectComment", notes = "delete CmsSubjectComment")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsSubjectCommentServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsSubjectComment", notes = "deleteByIds CmsSubjectComment")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsSubjectCommentServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsSubjectComment", notes = "deleteByCondition CmsSubjectComment")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectCommentDOV1.class);
        int rows = cmsSubjectCommentServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsSubjectComment", notes = "count CmsSubjectComment")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsSubjectCommentDOV1.class);
        int count = cmsSubjectCommentServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}