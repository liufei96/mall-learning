package com.liufei.mall.tiny.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.tiny.model.OssCallbackResult;
import com.liufei.mall.tiny.model.OssPolicyResult;
import com.liufei.mall.tiny.service.OssService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liufei
 * @version 1.0.0
 * @description Oss相关操作接口
 * @date 2022/9/14
 */
@RestController
@RequestMapping("/aliyun/oss")
public class OssController {

    @Resource
    private OssService ossService;

    @ApiOperation(value = "oss上传签名生成")
    @GetMapping(value = "/policy")
    public Result<OssPolicyResult> policy() {
        OssPolicyResult result = ossService.policy();
        return ResultGenerator.genSuccessResult(result);
    }

    @ApiOperation(value = "oss上传成功回调")
    @PostMapping(value = "callback")
    public Result<OssCallbackResult> callback(HttpServletRequest request) {
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        return ResultGenerator.genSuccessResult(ossCallbackResult);
    }
}
