package com.liufei.mall.seed.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.UpdateCondition;
import com.liufei.mall.seed.model.PmsAlbumPicDOV1;
import com.liufei.mall.seed.service.PmsAlbumPicServiceV1;

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
* @description PmsAlbumPic controller for basix CURD, including condition get, count etc
* @date 2022-09-18
*/
@RestController
@RequestMapping("/v1/pms/album/pic")
public class PmsAlbumPicControllerV1 {

    @Resource
    private PmsAlbumPicServiceV1 pmsAlbumPicServiceV1;

    @ApiOperation(value = "Create PmsAlbumPic", notes = "Create PmsAlbumPic")
    @PostMapping
    public Result<Integer> create(@RequestBody PmsAlbumPicDOV1 pmsAlbumPic) {
        int row = pmsAlbumPicServiceV1.save(pmsAlbumPic);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "batchCreate PmsAlbumPic", notes = "batchCreate PmsAlbumPic")
    @PostMapping("/batchCreate")
    public Result<Integer> batchCreate(@RequestBody List<PmsAlbumPicDOV1> pmsAlbumPics) {
        int rows = pmsAlbumPicServiceV1.save(pmsAlbumPics);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "findById PmsAlbumPic", notes = "findById PmsAlbumPic")
    @GetMapping("/{id}")
    public Result<PmsAlbumPicDOV1> findById(@PathVariable Integer id) {
        PmsAlbumPicDOV1 pmsAlbumPic = pmsAlbumPicServiceV1.findById(id);
        return ResultGenerator.genSuccessResult(pmsAlbumPic);
    }

    @ApiOperation(value = "findByIds PmsAlbumPic", notes = "findByIds PmsAlbumPic")
    @GetMapping("/findByIds/{ids}")
    public Result<List<PmsAlbumPicDOV1>> findByIds(@PathVariable String ids) {
        List<PmsAlbumPicDOV1> pmsAlbumPics = pmsAlbumPicServiceV1.findByIds(ids);
        return ResultGenerator.genSuccessResult(pmsAlbumPics);
    }

    @ApiOperation(value = "findByField PmsAlbumPic", notes = "findByField PmsAlbumPic")
    @GetMapping("/findByField/{field}/{value}")
    public Result<PmsAlbumPicDOV1> findByField(@PathVariable String field, @PathVariable String value) {
        PmsAlbumPicDOV1 pmsAlbumPic = pmsAlbumPicServiceV1.findBy(field, value);
        return ResultGenerator.genSuccessResult(pmsAlbumPic);
    }

    @ApiOperation(value = "findAll PmsAlbumPic", notes = "findAll PmsAlbumPic")
    @GetMapping("/findAll")
    public Result<PageInfo<PmsAlbumPicDOV1>> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<PmsAlbumPicDOV1> list = pmsAlbumPicServiceV1.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "listByCondition PmsAlbumPic", notes = "listByCondition PmsAlbumPic")
    @PostMapping("/listByCondition")
    public Result<PageInfo<PmsAlbumPicDOV1>> listByCondition(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsAlbumPicDOV1.class);
        List<PmsAlbumPicDOV1> list = pmsAlbumPicServiceV1.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "update PmsAlbumPic", notes = "update PmsAlbumPic")
    @PutMapping
    public Result<Integer> update(@RequestBody PmsAlbumPicDOV1 pmsAlbumPic) {
        int row = pmsAlbumPicServiceV1.update(pmsAlbumPic);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "updateByCondition PmsAlbumPic", notes = "updateByCondition PmsAlbumPic")
    @PutMapping("/updateByCondition")
    public Result<Integer> updateByCondition(@RequestBody UpdateCondition<PmsAlbumPicDOV1> updateCondition) {
        Condition condition = updateCondition.getCondition().generateRequestCondition(PmsAlbumPicDOV1.class);
        int rows = pmsAlbumPicServiceV1.updateByCondition(updateCondition.getModel(), condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "delete PmsAlbumPic", notes = "delete PmsAlbumPic")
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@RequestParam Integer id) {
        int row = pmsAlbumPicServiceV1.deleteById(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation(value = "deleteByIds PmsAlbumPic", notes = "deleteByIds PmsAlbumPic")
    @DeleteMapping("/deleteByIds/{ids}")
    public Result<Integer> deleteByIds(@PathVariable String ids) {
        int rows = pmsAlbumPicServiceV1.deleteByIds(ids);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "deleteByCondition PmsAlbumPic", notes = "deleteByCondition PmsAlbumPic")
    @PostMapping("/deleteByCondition")
    public Result<Integer> deleteByCondition(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsAlbumPicDOV1.class);
        int rows = pmsAlbumPicServiceV1.deleteByCondition(condition);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation(value = "count PmsAlbumPic", notes = "count PmsAlbumPic")
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody RequestCondition requestCondition) {
        Condition condition = requestCondition.generateRequestCondition(PmsAlbumPicDOV1.class);
        int count = pmsAlbumPicServiceV1.count(condition);
        return ResultGenerator.genSuccessResult(count);
    }
}