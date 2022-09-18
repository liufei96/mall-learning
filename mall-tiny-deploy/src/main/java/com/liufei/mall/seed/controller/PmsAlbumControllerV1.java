package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsAlbumDOV1;
import com.liufei.mall.seed.service.PmsAlbumServiceV1;

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
* @description PmsAlbum controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/album")
public class PmsAlbumControllerV1 {

    @Resource
    private PmsAlbumServiceV1 pmsAlbumServiceV1;

    @ApiOperation(value = "Create PmsAlbum", notes = "Create PmsAlbum")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsAlbumDOV1 pmsAlbum) {
        int row = pmsAlbumServiceV1.save(pmsAlbum);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsAlbum", notes = "batchCreate PmsAlbum")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsAlbumDOV1> pmsAlbums) {
        int rows = pmsAlbumServiceV1.save(pmsAlbums);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsAlbum", notes = "findById PmsAlbum")
    @GetMapping("/{id}")
    public Result<PmsAlbumDOV1> findById(@PathVariable Integer id) {
        PmsAlbumDOV1 pmsAlbum = pmsAlbumServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsAlbum);
    }

    @ApiOperation(value = "findByIds PmsAlbum", notes = "findByIds PmsAlbum")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsAlbumDOV1>> findByIds(@PathVariable String ids) {
        List<PmsAlbumDOV1> pmsAlbums = pmsAlbumServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsAlbums);
    }

    @ApiOperation(value = "findByField PmsAlbum", notes = "findByField PmsAlbum")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsAlbumDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsAlbumDOV1 pmsAlbum = pmsAlbumServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsAlbum);
    }

    @ApiOperation(value = "findAll PmsAlbum", notes = "findAll PmsAlbum")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsAlbumDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsAlbumDOV1> list = pmsAlbumServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsAlbum", notes = "listByCondition PmsAlbum")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsAlbumDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsAlbumDOV1.class);
        List<PmsAlbumDOV1> list = pmsAlbumServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsAlbum", notes = "update PmsAlbum")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsAlbumDOV1 pmsAlbum) {
        int row = pmsAlbumServiceV1.update(pmsAlbum);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsAlbum", notes = "updateByCondition PmsAlbum")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsAlbumDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsAlbumDOV1.class);
        int rows = pmsAlbumServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsAlbum", notes = "delete PmsAlbum")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsAlbumServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsAlbum", notes = "deleteByIds PmsAlbum")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsAlbumServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsAlbum", notes = "deleteByCondition PmsAlbum")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsAlbumDOV1.class);
        int rows = pmsAlbumServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsAlbum", notes = "count PmsAlbum")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsAlbumDOV1.class);
        int count = pmsAlbumServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}