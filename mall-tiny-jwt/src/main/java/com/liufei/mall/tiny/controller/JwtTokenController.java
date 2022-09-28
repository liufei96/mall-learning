package com.liufei.mall.tiny.controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.tiny.model.PayloadDto;
import com.liufei.mall.tiny.service.JwtTokenService;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * @author liufei
 * @version 1.0.0
 * @description JWT令牌管理Controller
 * @date 2022/9/28
 */
@RestController
@RequestMapping("/token")
public class JwtTokenController {

    @Resource
    private JwtTokenService jwtTokenService;

    @ApiOperation("使用对称加密（HMAC）算法生成token")
    @GetMapping(value = "/hmac/generate")
    public Result generateTokenByHMAC() {
        try {
            PayloadDto payloadDto = jwtTokenService.getDefaultPayloadDto();
            String token = jwtTokenService.generateTokenByHMAC(JSONUtil.toJsonStr(payloadDto), SecureUtil.md5("test"));
            return ResultGenerator.genSuccessResult(token);
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return ResultGenerator.genFailResult("使用对称加密（HMAC）算法生成token 失败");
    }

    @ApiOperation("使用对称加密（HMAC）算法验证token")
    @GetMapping(value = "/hmac/verify")
    public Result verifyTokenByHMAC(String token) {
        try {
            PayloadDto payloadDto = jwtTokenService.verifyTokenByHMAC(token, SecureUtil.md5("test"));
            return ResultGenerator.genSuccessResult(payloadDto);
        } catch (JOSEException | ParseException e) {
            e.printStackTrace();
        }
        return ResultGenerator.genFailResult("使用对称加密（HMAC）算法验证token成功");
    }

    @ApiOperation("使用非对称加密（RSA）算法生成token")
    @GetMapping(value = "/rsa/generate")
    public Result generateTokenByRSA() {
        try {
            PayloadDto payloadDto = jwtTokenService.getDefaultPayloadDto();
            String token = jwtTokenService.generateTokenByRSA(JSONUtil.toJsonStr(payloadDto), jwtTokenService.getDefaultRSAKey());
            return ResultGenerator.genSuccessResult(token);
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return ResultGenerator.genFailResult("使用非对称加密（RSA）算法生成token失败");
    }

    @ApiOperation("使用非对称加密（RSA）算法验证token")
    @GetMapping(value = "/rsa/verify")
    public Result verifyTokenByRSA(String token) {
        try {
            PayloadDto payloadDto = jwtTokenService.verifyTokenByRSA(token, jwtTokenService.getDefaultRSAKey());
            return ResultGenerator.genSuccessResult(payloadDto);
        } catch (ParseException | JOSEException e) {
            e.printStackTrace();
        }
        return ResultGenerator.genFailResult("使用非对称加密（RSA）算法验证token失败");
    }

    @ApiOperation("获取非对称加密（RSA）算法公钥")
    @GetMapping(value = "/rsa/publicKey")
    public Object getRSAPublicKey() {
        RSAKey key = jwtTokenService.getDefaultRSAKey();
        return new JWKSet(key).toJSONObject();
    }
}
