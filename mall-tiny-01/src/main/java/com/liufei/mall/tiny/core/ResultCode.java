package com.liufei.mall.tiny.core;

/**
 * @author liufei
 * @version 1.0.0
 * @description 响应码枚举
 * @date 2022/9/4
 */
public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(200),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
