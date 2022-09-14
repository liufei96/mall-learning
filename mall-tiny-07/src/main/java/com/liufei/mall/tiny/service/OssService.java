package com.liufei.mall.tiny.service;

import com.liufei.mall.tiny.model.OssCallbackResult;
import com.liufei.mall.tiny.model.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liufei
 * @version 1.0.0
 * @description oss上传管理Service
 * @date 2022/9/14
 */
public interface OssService {

    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();

    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
