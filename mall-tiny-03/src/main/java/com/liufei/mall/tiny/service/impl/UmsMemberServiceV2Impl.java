package com.liufei.mall.tiny.service.impl;

import com.liufei.mall.seed.core.AbstractService;
import com.liufei.mall.seed.core.Result;
import com.liufei.mall.seed.core.ResultGenerator;
import com.liufei.mall.seed.model.UmsMemberDOV1;
import com.liufei.mall.tiny.service.RedisService;
import com.liufei.mall.tiny.service.UmsMemberServiceV2;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;


/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/7
 */
@Service
public class UmsMemberServiceV2Impl extends AbstractService<UmsMemberDOV1> implements UmsMemberServiceV2 {

    private static final Logger log = LoggerFactory.getLogger(UmsMemberServiceV2Impl.class);

    @Resource
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public Result generateAuthCode(String telephone) {
        String key = REDIS_KEY_PREFIX_AUTH_CODE + telephone;
        if (redisService.get(key) != null) {
            return ResultGenerator.genFailResult("请稍后再获取");
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        // 验证码绑定手机号并存储到redis
        redisService.set(key, sb.toString());
        redisService.expire(key, AUTH_CODE_EXPIRE_SECONDS);
        return ResultGenerator.genSuccessResult(sb.toString());
    }

    @Override
    public Result verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return ResultGenerator.genFailResult("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if (authCode.equals(realAuthCode)) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("验证码不正确");
    }
}
