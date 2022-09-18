package com.liufei.mall.tiny.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.model.UmsAdminDOV1;
import com.liufei.mall.seed.model.UmsPermissionDOV1;
import com.liufei.mall.tiny.model.UmsAdminLoginParam;
import com.liufei.mall.tiny.service.LoginService;
import com.liufei.mall.tiny.service.UmsAdminServiceV2;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liufei
 * @version 1.0.0
 * @description 后台用户管理
 * @date 2022/9/10
 */
@RestController
@RequestMapping("/v2/ums/admin")
public class UmsAdminControllerV2 {

    @Resource
    private UmsAdminServiceV2 adminServiceV2;

    @Resource
    private LoginService loginService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public Result<UmsAdminDOV1> register(@RequestBody UmsAdminDOV1 umsAdminParam, BindingResult result) {
        UmsAdminDOV1 umsAdmin = loginService.register(umsAdminParam);
        if (umsAdmin == null) {
            ResultGenerator.genFailResult("注册失败");
        }
        return ResultGenerator.genSuccessResult(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    public Result login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = loginService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return ResultGenerator.genFailResult("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResultGenerator.genSuccessResult(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @GetMapping(value = "/permission/{adminId}")
    @ResponseBody
    public Result<List<UmsPermissionDOV1>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermissionDOV1> permissionList = adminServiceV2.getPermissionList(adminId);
        return ResultGenerator.genSuccessResult(permissionList);
    }
}
