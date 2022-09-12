package com.liufei.mall.tiny.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liufei.mall.seed.core.RequestCondition;
import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.model.PmsBrandDOV1;
import com.liufei.mall.seed.service.PmsBrandServiceV1;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 品牌管理Controller
 * @date 2022/9/12
 */
@RestController
@RequestMapping("/v2/brand")
public class PmsBrandControllerV2 {

    @Resource
    private PmsBrandServiceV1 brandServiceV1;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandControllerV2.class);

    @ApiOperation("获取所有品牌列表")
    @GetMapping(value = "/listAll")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public Result<List<PmsBrandDOV1>> getBrandList() {
        return ResultGenerator.genSuccessResult(brandServiceV1.findAll());
    }

    @ApiOperation("添加品牌")
    @PostMapping(value = "/create")
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public Result createBrand(@RequestBody PmsBrandDOV1 pmsBrandDOV1) {
        Result result;
        int count = brandServiceV1.save(pmsBrandDOV1);
        if (count == 1) {
            result = ResultGenerator.genSuccessResult(pmsBrandDOV1);
            LOGGER.debug("createBrand success:{}", pmsBrandDOV1);
        } else {
            result = ResultGenerator.genFailResult("操作失败");
            LOGGER.debug("createBrand failed:{}", pmsBrandDOV1);
        }
        return result;
    }

    @ApiOperation("更新品牌信息")
    @PostMapping(value = "/update")
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public Result updateBrand(@RequestBody PmsBrandDOV1 pmsBrandDOV1, BindingResult bindingResult) {
        Result result;
        int count = brandServiceV1.update(pmsBrandDOV1);
        if (count == 1) {
            result = ResultGenerator.genSuccessResult(pmsBrandDOV1);
            LOGGER.debug("updateBrand success:{}", pmsBrandDOV1);
        } else {
            result = ResultGenerator.genFailResult("操作失败");
            LOGGER.debug("updateBrand failed:{}", pmsBrandDOV1);
        }
        return result;
    }

    @ApiOperation("删除指定id的品牌")
    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public Result deleteBrand(@PathVariable("id") Long id) {
        int count = brandServiceV1.deleteById(id.intValue());
        if (count == 1) {
            LOGGER.debug("deleteBrand success :id={}", id);
            return ResultGenerator.genSuccessResult(null);
        } else {
            LOGGER.debug("deleteBrand failed :id={}", id);
            return ResultGenerator.genFailResult("操作失败");
        }
    }

    @ApiOperation("分页查询品牌列表")
    @GetMapping(value = "/listByCondition")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public Result<PageInfo<PmsBrandDOV1>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1")
                                                    @ApiParam("页码") Integer page,
                                                    @RequestParam(value = "pageSize", defaultValue = "3")
                                                    @ApiParam("每页数量") Integer size,
                                                    @RequestBody RequestCondition requestCondition) {
        PageHelper.startPage(page, size);
        Condition condition = requestCondition.generateRequestCondition(PmsBrandDOV1.class);
        List<PmsBrandDOV1> brandList = brandServiceV1.findByCondition(condition);
        PageInfo<PmsBrandDOV1> pageInfo = new PageInfo<>(brandList);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public Result<PmsBrandDOV1> brand(@PathVariable("id") Long id) {
        return ResultGenerator.genSuccessResult(brandServiceV1.findById(id.intValue()));
    }
}
