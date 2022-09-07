package com.liufei.mall.seed.core;

/**
 * @author liufei
 * @version 1.0.0
 * @description 快速生成返回对象
 * @date 2022/9/4
 */
public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static <T> Result<T> genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
