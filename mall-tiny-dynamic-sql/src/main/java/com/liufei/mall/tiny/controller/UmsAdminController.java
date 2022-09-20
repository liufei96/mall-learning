package com.liufei.mall.tiny.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liufei.mall.tiny.core.Result;
import com.liufei.mall.tiny.core.ResultGenerator;
import com.liufei.mall.tiny.model.AdminRoleDto;
import com.liufei.mall.tiny.model.RoleStatDto;
import com.liufei.mall.tiny.model.UmsAdmin;
import com.liufei.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 后台用户管理Controller
 * @date 2022/9/20
 */
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Resource
    private UmsAdminService adminService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@RequestBody UmsAdmin umsAdmin) {
        adminService.create(umsAdmin);
        return ResultGenerator.genSuccessResult(umsAdmin);
    }

    @ApiOperation("修改")
    @PutMapping("/update")
    public Result update(@RequestBody UmsAdmin umsAdmin) {
        adminService.update(umsAdmin);
        return ResultGenerator.genSuccessResult(umsAdmin);
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        int row = adminService.delete(id);
        return ResultGenerator.genSuccessResult(row);
    }

    @ApiOperation("根据ID查询")
    @GetMapping("/select/{id}")
    public Result<UmsAdmin> select(@PathVariable Long id) {
        UmsAdmin umsAdmin = adminService.select(id);
        return ResultGenerator.genSuccessResult(umsAdmin);
    }

    @ApiOperation("分页查询所有")
    @GetMapping("/listAll")
    public Result<PageInfo<UmsAdmin>> listAll(@RequestParam(value = "pageNum", defaultValue = "1")
                                              @ApiParam("页码") Integer pageNum,
                                              @RequestParam(value = "pageSize", defaultValue = "5")
                                              @ApiParam("每页数量") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsAdmin> list = adminService.listAll(pageNum, pageSize);
        PageInfo<UmsAdmin> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation("分页条件查询")
    @GetMapping("/list")
    public Result<PageInfo<UmsAdmin>> list(@RequestParam(value = "pageNum", defaultValue = "1")
                                           @ApiParam("页码") Integer pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "5")
                                           @ApiParam("每页数量") Integer pageSize,
                                           @RequestParam(required = false)
                                           @ApiParam("用户名") String username,
                                           @RequestParam
                                           @ApiParam(value = "状态", required = true) List<Integer> statusList) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsAdmin> list = adminService.list(pageNum, pageSize, username, statusList);
        PageInfo<UmsAdmin> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation("使用Lambda表达式分页查询")
    @GetMapping("/lambdaList")
    public Result<PageInfo<UmsAdmin>> lambdaList(@RequestParam(value = "pageNum", defaultValue = "1")
                                                 @ApiParam("页码") Integer pageNum,
                                                 @RequestParam(value = "pageSize", defaultValue = "5")
                                                 @ApiParam("每页数量") Integer pageSize,
                                                 @RequestParam(required = false)
                                                 @ApiParam(value = "用户名") String username,
                                                 @RequestParam
                                                 @ApiParam(value = "状态", required = true) List<Integer> statusList) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsAdmin> list = adminService.lambdaList(pageNum, pageSize, username, statusList);
        PageInfo<UmsAdmin> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation("使用子查询")
    @GetMapping("/subList")
    public Result<List<UmsAdmin>> subList(@RequestParam Long roleId) {
        List<UmsAdmin> list = adminService.subList(roleId);
        return ResultGenerator.genSuccessResult(list);
    }

    @ApiOperation("使用Group和Join查询")
    @GetMapping("/groupList")
    public Result<List<RoleStatDto>> groupList() {
        List<RoleStatDto> list = adminService.groupList();
        return ResultGenerator.genSuccessResult(list);
    }

    @ApiOperation("条件删除")
    @GetMapping("/deleteByUsername")
    public Result deleteByUsername(@RequestParam String username) {
        int rows = adminService.deleteByUsername(username);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation("条件修改")
    @GetMapping("/updateByIds")
    public Result updateByIds(List<Long> ids, Integer status) {
        int rows = adminService.updateByIds(ids, status);
        return ResultGenerator.genSuccessResult(rows);
    }

    @ApiOperation("一对多查询")
    @GetMapping("/selectWithRoleList")
    public Result<AdminRoleDto> selectWithRoleList(@RequestParam Long id) {
        AdminRoleDto adminRoleDto = adminService.selectWithRoleList(id);
        return ResultGenerator.genSuccessResult(adminRoleDto);
    }
}
