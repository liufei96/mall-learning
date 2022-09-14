package com.liufei.mall.tiny.service;

import com.liufei.mall.seed.core.Result;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/7
 */
public interface UmsMemberServiceV2 {

    Result generateAuthCode(String telephone);

    Result verifyAuthCode(String telephone, String authCode);
}
