package com.liufei.mall.seed.core;

/**
 * @author liufei
 * @version 1.0.0
 * @description 统一返回结果
 * @date 2022/9/4
 */
public class Result<T> {

    private int code;

    private String message;

    private T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }


    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }
}
