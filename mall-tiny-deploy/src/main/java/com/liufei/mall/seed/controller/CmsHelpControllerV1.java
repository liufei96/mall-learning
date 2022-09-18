package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsHelpDOV1;
import com.liufei.mall.seed.service.CmsHelpServiceV1;

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
* @description CmsHelp controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/help")
public class CmsHelpControllerV1 {

    @Resource
    private CmsHelpServiceV1 cmsHelpServiceV1;

    @ApiOperation(value = "Create CmsHelp", notes = "Create CmsHelp")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsHelpDOV1 cmsHelp) {
        int row = cmsHelpServiceV1.save(cmsHelp);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsHelp", notes = "batchCreate CmsHelp")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsHelpDOV1> cmsHelps) {
        int rows = cmsHelpServiceV1.save(cmsHelps);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsHelp", notes = "findById CmsHelp")
    @GetMapping("/{id}")
    public Result<CmsHelpDOV1> findById(@PathVariable Integer id) {
        CmsHelpDOV1 cmsHelp = cmsHelpServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsHelp);
    }

    @ApiOperation(value = "findByIds CmsHelp", notes = "findByIds CmsHelp")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsHelpDOV1>> findByIds(@PathVariable String ids) {
        List<CmsHelpDOV1> cmsHelps = cmsHelpServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsHelps);
    }

    @ApiOperation(value = "findByField CmsHelp", notes = "findByField CmsHelp")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsHelpDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsHelpDOV1 cmsHelp = cmsHelpServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsHelp);
    }

    @ApiOperation(value = "findAll CmsHelp", notes = "findAll CmsHelp")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsHelpDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsHelpDOV1> list = cmsHelpServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsHelp", notes = "listByCondition CmsHelp")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsHelpDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsHelpDOV1.class);
        List<CmsHelpDOV1> list = cmsHelpServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsHelp", notes = "update CmsHelp")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsHelpDOV1 cmsHelp) {
        int row = cmsHelpServiceV1.update(cmsHelp);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsHelp", notes = "updateByCondition CmsHelp")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsHelpDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsHelpDOV1.class);
        int rows = cmsHelpServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsHelp", notes = "delete CmsHelp")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsHelpServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsHelp", notes = "deleteByIds CmsHelp")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsHelpServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsHelp", notes = "deleteByCondition CmsHelp")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsHelpDOV1.class);
        int rows = cmsHelpServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsHelp", notes = "count CmsHelp")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsHelpDOV1.class);
        int count = cmsHelpServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}