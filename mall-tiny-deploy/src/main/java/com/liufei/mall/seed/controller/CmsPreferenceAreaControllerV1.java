package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.CmsPreferenceAreaDOV1;
import com.liufei.mall.seed.service.CmsPreferenceAreaServiceV1;

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
* @description CmsPreferenceArea controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/cms/preference/area")
public class CmsPreferenceAreaControllerV1 {

    @Resource
    private CmsPreferenceAreaServiceV1 cmsPreferenceAreaServiceV1;

    @ApiOperation(value = "Create CmsPreferenceArea", notes = "Create CmsPreferenceArea")
    @PostMapping
    public Result<Integer> create(@RequestBody CmsPreferenceAreaDOV1 cmsPreferenceArea) {
        int row = cmsPreferenceAreaServiceV1.save(cmsPreferenceArea);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate CmsPreferenceArea", notes = "batchCreate CmsPreferenceArea")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<CmsPreferenceAreaDOV1> cmsPreferenceAreas) {
        int rows = cmsPreferenceAreaServiceV1.save(cmsPreferenceAreas);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById CmsPreferenceArea", notes = "findById CmsPreferenceArea")
    @GetMapping("/{id}")
    public Result<CmsPreferenceAreaDOV1> findById(@PathVariable Integer id) {
        CmsPreferenceAreaDOV1 cmsPreferenceArea = cmsPreferenceAreaServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(cmsPreferenceArea);
    }

    @ApiOperation(value = "findByIds CmsPreferenceArea", notes = "findByIds CmsPreferenceArea")
    @GetMapping("/findByIds/{ids}")
    public Result<List<CmsPreferenceAreaDOV1>> findByIds(@PathVariable String ids) {
        List<CmsPreferenceAreaDOV1> cmsPreferenceAreas = cmsPreferenceAreaServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(cmsPreferenceAreas);
    }

    @ApiOperation(value = "findByField CmsPreferenceArea", notes = "findByField CmsPreferenceArea")
    @GetMapping("/findByField/{field}/{value}")
    public Result<CmsPreferenceAreaDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        CmsPreferenceAreaDOV1 cmsPreferenceArea = cmsPreferenceAreaServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(cmsPreferenceArea);
    }

    @ApiOperation(value = "findAll CmsPreferenceArea", notes = "findAll CmsPreferenceArea")
    @GetMapping("/findAll")
    public Result<PageInfo<CmsPreferenceAreaDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<CmsPreferenceAreaDOV1> list = cmsPreferenceAreaServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition CmsPreferenceArea", notes = "listByCondition CmsPreferenceArea")
    @PostMapping("/listByCondition")
    public Result<PageInfo<CmsPreferenceAreaDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(CmsPreferenceAreaDOV1.class);
        List<CmsPreferenceAreaDOV1> list = cmsPreferenceAreaServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update CmsPreferenceArea", notes = "update CmsPreferenceArea")
    @PutMapping
    public Result<Integer> update(@RequestBody CmsPreferenceAreaDOV1 cmsPreferenceArea) {
        int row = cmsPreferenceAreaServiceV1.update(cmsPreferenceArea);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition CmsPreferenceArea", notes = "updateByCondition CmsPreferenceArea")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<CmsPreferenceAreaDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(CmsPreferenceAreaDOV1.class);
        int rows = cmsPreferenceAreaServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete CmsPreferenceArea", notes = "delete CmsPreferenceArea")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = cmsPreferenceAreaServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds CmsPreferenceArea", notes = "deleteByIds CmsPreferenceArea")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = cmsPreferenceAreaServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition CmsPreferenceArea", notes = "deleteByCondition CmsPreferenceArea")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsPreferenceAreaDOV1.class);
        int rows = cmsPreferenceAreaServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count CmsPreferenceArea", notes = "count CmsPreferenceArea")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(CmsPreferenceAreaDOV1.class);
        int count = cmsPreferenceAreaServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}