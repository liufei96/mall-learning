package com.liufei.mall.tiny.core;

/**
 * @author liufei
 * @version 1.0.0
 * @description 响应码枚举
 * @date 2022/9/4
 */
public enum ResultCode {
    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "异常"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private final int code;
    private String message;

    ResultCode(int code) {
        this.code = code;
    }

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
