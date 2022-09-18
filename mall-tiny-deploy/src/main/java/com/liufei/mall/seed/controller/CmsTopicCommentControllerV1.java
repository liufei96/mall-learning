package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsTopicCommentDOV1;
import com.liufei.mall.seed.service.CmsTopicCommentServiceV1;

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
* @description CmsTopicComment controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/topic/comment")
public class CmsTopicCommentControllerV1 {

    @Resource
    private CmsTopicCommentServiceV1 cmsTopicCommentServiceV1;

    @ApiOperation(value = "Create CmsTopicComment", notes = "Create CmsTopicComment")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsTopicCommentDOV1 cmsTopicComment) {
        int row = cmsTopicCommentServiceV1.save(cmsTopicComment);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsTopicComment", notes = "batchCreate CmsTopicComment")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsTopicCommentDOV1> cmsTopicComments) {
        int rows = cmsTopicCommentServiceV1.save(cmsTopicComments);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsTopicComment", notes = "findById CmsTopicComment")
    @GetMapping("/{id}")
    public Result<CmsTopicCommentDOV1> findById(@PathVariable Integer id) {
        CmsTopicCommentDOV1 cmsTopicComment = cmsTopicCommentServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsTopicComment);
    }

    @ApiOperation(value = "findByIds CmsTopicComment", notes = "findByIds CmsTopicComment")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsTopicCommentDOV1>> findByIds(@PathVariable String ids) {
        List<CmsTopicCommentDOV1> cmsTopicComments = cmsTopicCommentServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsTopicComments);
    }

    @ApiOperation(value = "findByField CmsTopicComment", notes = "findByField CmsTopicComment")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsTopicCommentDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsTopicCommentDOV1 cmsTopicComment = cmsTopicCommentServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsTopicComment);
    }

    @ApiOperation(value = "findAll CmsTopicComment", notes = "findAll CmsTopicComment")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsTopicCommentDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsTopicCommentDOV1> list = cmsTopicCommentServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsTopicComment", notes = "listByCondition CmsTopicComment")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsTopicCommentDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsTopicCommentDOV1.class);
        List<CmsTopicCommentDOV1> list = cmsTopicCommentServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsTopicComment", notes = "update CmsTopicComment")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsTopicCommentDOV1 cmsTopicComment) {
        int row = cmsTopicCommentServiceV1.update(cmsTopicComment);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsTopicComment", notes = "updateByCondition CmsTopicComment")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsTopicCommentDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsTopicCommentDOV1.class);
        int rows = cmsTopicCommentServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsTopicComment", notes = "delete CmsTopicComment")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsTopicCommentServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsTopicComment", notes = "deleteByIds CmsTopicComment")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsTopicCommentServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsTopicComment", notes = "deleteByCondition CmsTopicComment")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsTopicCommentDOV1.class);
        int rows = cmsTopicCommentServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsTopicComment", notes = "count CmsTopicComment")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsTopicCommentDOV1.class);
        int count = cmsTopicCommentServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}