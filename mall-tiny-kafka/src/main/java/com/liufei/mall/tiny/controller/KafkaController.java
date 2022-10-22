package com.liufei.mall.tiny.controller;

import com.liufei.mall.tiny.core.Result;
import com.liufei.mall.tiny.core.ResultGenerator;
import com.liufei.mall.tiny.kafka.KafkaProducer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liufei
 * @version 1.0.0
 * @description Kafka功能测试
 * @date 2022/10/22
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {


    @Autowired
    private KafkaProducer kafkaProducer;

    @ApiOperation("发送消息")
    @GetMapping(value = "/sendMessage")
    public Result sendMessage(@RequestParam String message) {
        kafkaProducer.send(message);
        return ResultGenerator.genSuccessResult();
    }

}
