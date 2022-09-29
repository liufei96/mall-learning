package com.liufei.mall.tiny.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.erupt.job.handler.EruptJobHandler;

/**
 * @author liufei
 * @version 1.0.0
 * @description
 * @date 2022/9/29
 */
@Service
@Slf4j
public class JobHandlerImpl implements EruptJobHandler {

    @Override
    public String exec(String code, String param) {
        log.info("定时任务已经执行，code:{},param:{}",code,param);
        return "success";
    }
}
