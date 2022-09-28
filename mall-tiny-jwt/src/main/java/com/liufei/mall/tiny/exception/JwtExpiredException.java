package com.liufei.mall.tiny.exception;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/28
 */
public class JwtExpiredException extends RuntimeException{
    public JwtExpiredException(String message) {
        super(message);
    }
}
