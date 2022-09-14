package com.liufei.mall.tiny.service.impl;

import com.liufei.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import com.liufei.mall.tiny.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.liufei.mall.tiny.service.MemberReadHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/13
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberReadHistoryServiceImpl.class);

    @Resource
    private MemberReadHistoryRepository memberReadHistoryRepository;

    @Override
    public MemberReadHistory create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        return memberReadHistoryRepository.save(memberReadHistory);
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>();
        for (String id : ids) {
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deleteList.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
