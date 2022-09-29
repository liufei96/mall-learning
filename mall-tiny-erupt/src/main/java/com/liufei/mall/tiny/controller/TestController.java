package com.liufei.mall.tiny.controller;

import com.liufei.mall.tiny.core.Result;
import com.liufei.mall.tiny.core.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/29
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/first")
    public Result first() {
        String message = "返回消息";
        return ResultGenerator.genSuccessResult(message);
    }

}
