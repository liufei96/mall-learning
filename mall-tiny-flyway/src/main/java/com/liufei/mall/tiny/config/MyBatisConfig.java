package com.liufei.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.liufei.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}
