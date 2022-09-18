package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsMemberReportDOV1;
import com.liufei.mall.seed.service.CmsMemberReportServiceV1;

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
* @description CmsMemberReport controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/member/report")
public class CmsMemberReportControllerV1 {

    @Resource
    private CmsMemberReportServiceV1 cmsMemberReportServiceV1;

    @ApiOperation(value = "Create CmsMemberReport", notes = "Create CmsMemberReport")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsMemberReportDOV1 cmsMemberReport) {
        int row = cmsMemberReportServiceV1.save(cmsMemberReport);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsMemberReport", notes = "batchCreate CmsMemberReport")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsMemberReportDOV1> cmsMemberReports) {
        int rows = cmsMemberReportServiceV1.save(cmsMemberReports);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsMemberReport", notes = "findById CmsMemberReport")
    @GetMapping("/{id}")
    public Result<CmsMemberReportDOV1> findById(@PathVariable Integer id) {
        CmsMemberReportDOV1 cmsMemberReport = cmsMemberReportServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsMemberReport);
    }

    @ApiOperation(value = "findByIds CmsMemberReport", notes = "findByIds CmsMemberReport")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsMemberReportDOV1>> findByIds(@PathVariable String ids) {
        List<CmsMemberReportDOV1> cmsMemberReports = cmsMemberReportServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsMemberReports);
    }

    @ApiOperation(value = "findByField CmsMemberReport", notes = "findByField CmsMemberReport")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsMemberReportDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsMemberReportDOV1 cmsMemberReport = cmsMemberReportServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsMemberReport);
    }

    @ApiOperation(value = "findAll CmsMemberReport", notes = "findAll CmsMemberReport")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsMemberReportDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsMemberReportDOV1> list = cmsMemberReportServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsMemberReport", notes = "listByCondition CmsMemberReport")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsMemberReportDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsMemberReportDOV1.class);
        List<CmsMemberReportDOV1> list = cmsMemberReportServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsMemberReport", notes = "update CmsMemberReport")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsMemberReportDOV1 cmsMemberReport) {
        int row = cmsMemberReportServiceV1.update(cmsMemberReport);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsMemberReport", notes = "updateByCondition CmsMemberReport")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsMemberReportDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsMemberReportDOV1.class);
        int rows = cmsMemberReportServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsMemberReport", notes = "delete CmsMemberReport")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsMemberReportServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsMemberReport", notes = "deleteByIds CmsMemberReport")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsMemberReportServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsMemberReport", notes = "deleteByCondition CmsMemberReport")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsMemberReportDOV1.class);
        int rows = cmsMemberReportServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsMemberReport", notes = "count CmsMemberReport")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsMemberReportDOV1.class);
        int count = cmsMemberReportServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}