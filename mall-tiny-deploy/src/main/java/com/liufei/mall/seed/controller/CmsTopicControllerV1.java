package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsTopicDOV1;
import com.liufei.mall.seed.service.CmsTopicServiceV1;

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
* @description CmsTopic controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/topic")
public class CmsTopicControllerV1 {

    @Resource
    private CmsTopicServiceV1 cmsTopicServiceV1;

    @ApiOperation(value = "Create CmsTopic", notes = "Create CmsTopic")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsTopicDOV1 cmsTopic) {
        int row = cmsTopicServiceV1.save(cmsTopic);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsTopic", notes = "batchCreate CmsTopic")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsTopicDOV1> cmsTopics) {
        int rows = cmsTopicServiceV1.save(cmsTopics);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsTopic", notes = "findById CmsTopic")
    @GetMapping("/{id}")
    public Result<CmsTopicDOV1> findById(@PathVariable Integer id) {
        CmsTopicDOV1 cmsTopic = cmsTopicServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsTopic);
    }

    @ApiOperation(value = "findByIds CmsTopic", notes = "findByIds CmsTopic")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsTopicDOV1>> findByIds(@PathVariable String ids) {
        List<CmsTopicDOV1> cmsTopics = cmsTopicServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsTopics);
    }

    @ApiOperation(value = "findByField CmsTopic", notes = "findByField CmsTopic")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsTopicDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsTopicDOV1 cmsTopic = cmsTopicServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsTopic);
    }

    @ApiOperation(value = "findAll CmsTopic", notes = "findAll CmsTopic")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsTopicDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsTopicDOV1> list = cmsTopicServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsTopic", notes = "listByCondition CmsTopic")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsTopicDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsTopicDOV1.class);
        List<CmsTopicDOV1> list = cmsTopicServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsTopic", notes = "update CmsTopic")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsTopicDOV1 cmsTopic) {
        int row = cmsTopicServiceV1.update(cmsTopic);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsTopic", notes = "updateByCondition CmsTopic")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsTopicDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsTopicDOV1.class);
        int rows = cmsTopicServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsTopic", notes = "delete CmsTopic")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsTopicServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsTopic", notes = "deleteByIds CmsTopic")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsTopicServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsTopic", notes = "deleteByCondition CmsTopic")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsTopicDOV1.class);
        int rows = cmsTopicServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsTopic", notes = "count CmsTopic")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsTopicDOV1.class);
        int count = cmsTopicServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}