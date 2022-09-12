package com.liufei.mall.tiny.controller;

import com.liufei.mall.seed.core.Result;
import com.liufei.mall.tiny.service.UmsMemberServiceV2;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/7
 */
@RestController
@RequestMapping("/v2/ums/member")
public class UmsMemberControllerV2 {

    @Resource
    private UmsMemberServiceV2 memberService;

    @ApiOperation("获取验证码")
    @GetMapping(value = "/getAuthCode")
    public Result getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone,authCode);
    }

}
