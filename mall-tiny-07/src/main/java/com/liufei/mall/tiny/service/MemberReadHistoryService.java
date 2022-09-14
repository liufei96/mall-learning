package com.liufei.mall.tiny.service;

import com.liufei.mall.tiny.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 会员浏览商品记录管理service
 * @date 2022/9/13
 */
public interface MemberReadHistoryService {

    /**
     * 生成浏览记录
     */
    MemberReadHistory create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     */
    List<MemberReadHistory> list(Long memberId);
}
