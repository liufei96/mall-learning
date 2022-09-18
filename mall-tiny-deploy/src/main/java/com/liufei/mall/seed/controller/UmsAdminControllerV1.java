package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.UmsAdminDOV1;
import com.liufei.mall.seed.service.UmsAdminServiceV1;

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
* @description UmsAdmin controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/ums/admin")
public class UmsAdminControllerV1 {

    @Resource
    private UmsAdminServiceV1 umsAdminServiceV1;

    @ApiOperation(value = "Create UmsAdmin", notes = "Create UmsAdmin")
    @PostMapping
    public Result<Integer> create(@RequestBody UmsAdminDOV1 umsAdmin) {
        int row = umsAdminServiceV1.save(umsAdmin);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate UmsAdmin", notes = "batchCreate UmsAdmin")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<UmsAdminDOV1> umsAdmins) {
        int rows = umsAdminServiceV1.save(umsAdmins);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById UmsAdmin", notes = "findById UmsAdmin")
    @GetMapping("/{id}")
    public Result<UmsAdminDOV1> findById(@PathVariable Integer id) {
        UmsAdminDOV1 umsAdmin = umsAdminServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(umsAdmin);
    }

    @ApiOperation(value = "findByIds UmsAdmin", notes = "findByIds UmsAdmin")
    @GetMapping("/findByIds/{ids}")
    public Result<List<UmsAdminDOV1>> findByIds(@PathVariable String ids) {
        List<UmsAdminDOV1> umsAdmins = umsAdminServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(umsAdmins);
    }

    @ApiOperation(value = "findByField UmsAdmin", notes = "findByField UmsAdmin")
    @GetMapping("/findByField/{field}/{value}")
    public Result<UmsAdminDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        UmsAdminDOV1 umsAdmin = umsAdminServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(umsAdmin);
    }

    @ApiOperation(value = "findAll UmsAdmin", notes = "findAll UmsAdmin")
    @GetMapping("/findAll")
    public Result<PageInfo<UmsAdminDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<UmsAdminDOV1> list = umsAdminServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition UmsAdmin", notes = "listByCondition UmsAdmin")
    @PostMapping("/listByCondition")
    public Result<PageInfo<UmsAdminDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(UmsAdminDOV1.class);
        List<UmsAdminDOV1> list = umsAdminServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update UmsAdmin", notes = "update UmsAdmin")
    @PutMapping
    public Result<Integer> update(@RequestBody UmsAdminDOV1 umsAdmin) {
        int row = umsAdminServiceV1.update(umsAdmin);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition UmsAdmin", notes = "updateByCondition UmsAdmin")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<UmsAdminDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(UmsAdminDOV1.class);
        int rows = umsAdminServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete UmsAdmin", notes = "delete UmsAdmin")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = umsAdminServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds UmsAdmin", notes = "deleteByIds UmsAdmin")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = umsAdminServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition UmsAdmin", notes = "deleteByCondition UmsAdmin")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsAdminDOV1.class);
        int rows = umsAdminServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count UmsAdmin", notes = "count UmsAdmin")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(UmsAdminDOV1.class);
        int count = umsAdminServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}