package com.liufei.mall.seed.core;

/**
 * @author liufei
 * @version 1.0.0
 * @description 自定义异常类
 * @date 2022/9/4
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
