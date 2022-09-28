package com.liufei.mall.tiny.service;

import com.liufei.mall.tiny.model.PayloadDto;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;

import java.text.ParseException;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/28
 */
public interface JwtTokenService {

    /**
     * 使用HMAC算法生成token
     */
    String generateTokenByHMAC(String payloadStr, String secret) throws JOSEException;

    /**
     * 使用HMAC算法校验token
     */
    PayloadDto verifyTokenByHMAC(String token, String secret) throws ParseException, JOSEException;

    /**
     * 使用RSA算法生成token
     */
    String generateTokenByRSA(String payloadStr, RSAKey rsaKey) throws JOSEException;

    /**
     * 使用RSA算法校验token
     */
    PayloadDto verifyTokenByRSA(String token, RSAKey rsaKey) throws ParseException, JOSEException;

    /**
     * 获取默认payload
     */
    PayloadDto getDefaultPayloadDto();

    /**
     * 获取默认的RSAKey
     */
    RSAKey getDefaultRSAKey();
}
