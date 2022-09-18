package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsCommentDOV1;
import com.liufei.mall.seed.service.PmsCommentServiceV1;

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
* @description PmsComment controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/comment")
public class PmsCommentControllerV1 {

    @Resource
    private PmsCommentServiceV1 pmsCommentServiceV1;

    @ApiOperation(value = "Create PmsComment", notes = "Create PmsComment")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsCommentDOV1 pmsComment) {
        int row = pmsCommentServiceV1.save(pmsComment);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsComment", notes = "batchCreate PmsComment")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsCommentDOV1> pmsComments) {
        int rows = pmsCommentServiceV1.save(pmsComments);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsComment", notes = "findById PmsComment")
    @GetMapping("/{id}")
    public Result<PmsCommentDOV1> findById(@PathVariable Integer id) {
        PmsCommentDOV1 pmsComment = pmsCommentServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsComment);
    }

    @ApiOperation(value = "findByIds PmsComment", notes = "findByIds PmsComment")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsCommentDOV1>> findByIds(@PathVariable String ids) {
        List<PmsCommentDOV1> pmsComments = pmsCommentServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsComments);
    }

    @ApiOperation(value = "findByField PmsComment", notes = "findByField PmsComment")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsCommentDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsCommentDOV1 pmsComment = pmsCommentServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsComment);
    }

    @ApiOperation(value = "findAll PmsComment", notes = "findAll PmsComment")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsCommentDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsCommentDOV1> list = pmsCommentServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsComment", notes = "listByCondition PmsComment")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsCommentDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsCommentDOV1.class);
        List<PmsCommentDOV1> list = pmsCommentServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsComment", notes = "update PmsComment")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsCommentDOV1 pmsComment) {
        int row = pmsCommentServiceV1.update(pmsComment);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsComment", notes = "updateByCondition PmsComment")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsCommentDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsCommentDOV1.class);
        int rows = pmsCommentServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsComment", notes = "delete PmsComment")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsCommentServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsComment", notes = "deleteByIds PmsComment")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsCommentServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsComment", notes = "deleteByCondition PmsComment")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsCommentDOV1.class);
        int rows = pmsCommentServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsComment", notes = "count PmsComment")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsCommentDOV1.class);
        int count = pmsCommentServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}