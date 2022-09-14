package com.liufei.mall.tiny.nosql.mongodb.repository;

import com.liufei.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description 会员商品浏览历史Repository
 * @date 2022/9/13
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {

    /**
     * 根据会员id按时间倒序获取浏览记录
     * @param memberId 会员id
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);

}
