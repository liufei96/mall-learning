package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsCommentReplayDOV1;
import com.liufei.mall.seed.service.PmsCommentReplayServiceV1;

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
* @description PmsCommentReplay controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/comment/replay")
public class PmsCommentReplayControllerV1 {

    @Resource
    private PmsCommentReplayServiceV1 pmsCommentReplayServiceV1;

    @ApiOperation(value = "Create PmsCommentReplay", notes = "Create PmsCommentReplay")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsCommentReplayDOV1 pmsCommentReplay) {
        int row = pmsCommentReplayServiceV1.save(pmsCommentReplay);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsCommentReplay", notes = "batchCreate PmsCommentReplay")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsCommentReplayDOV1> pmsCommentReplays) {
        int rows = pmsCommentReplayServiceV1.save(pmsCommentReplays);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsCommentReplay", notes = "findById PmsCommentReplay")
    @GetMapping("/{id}")
    public Result<PmsCommentReplayDOV1> findById(@PathVariable Integer id) {
        PmsCommentReplayDOV1 pmsCommentReplay = pmsCommentReplayServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsCommentReplay);
    }

    @ApiOperation(value = "findByIds PmsCommentReplay", notes = "findByIds PmsCommentReplay")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsCommentReplayDOV1>> findByIds(@PathVariable String ids) {
        List<PmsCommentReplayDOV1> pmsCommentReplays = pmsCommentReplayServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsCommentReplays);
    }

    @ApiOperation(value = "findByField PmsCommentReplay", notes = "findByField PmsCommentReplay")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsCommentReplayDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsCommentReplayDOV1 pmsCommentReplay = pmsCommentReplayServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsCommentReplay);
    }

    @ApiOperation(value = "findAll PmsCommentReplay", notes = "findAll PmsCommentReplay")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsCommentReplayDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsCommentReplayDOV1> list = pmsCommentReplayServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsCommentReplay", notes = "listByCondition PmsCommentReplay")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsCommentReplayDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsCommentReplayDOV1.class);
        List<PmsCommentReplayDOV1> list = pmsCommentReplayServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsCommentReplay", notes = "update PmsCommentReplay")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsCommentReplayDOV1 pmsCommentReplay) {
        int row = pmsCommentReplayServiceV1.update(pmsCommentReplay);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsCommentReplay", notes = "updateByCondition PmsCommentReplay")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsCommentReplayDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsCommentReplayDOV1.class);
        int rows = pmsCommentReplayServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsCommentReplay", notes = "delete PmsCommentReplay")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsCommentReplayServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsCommentReplay", notes = "deleteByIds PmsCommentReplay")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsCommentReplayServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsCommentReplay", notes = "deleteByCondition PmsCommentReplay")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsCommentReplayDOV1.class);
        int rows = pmsCommentReplayServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsCommentReplay", notes = "count PmsCommentReplay")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsCommentReplayDOV1.class);
        int count = pmsCommentReplayServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}