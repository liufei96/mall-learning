package com.liufei.mall;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({"com.liufei.mall.seed.dao", "com.liufei.mall.tiny.dao"})
public class MallApplication {

    public static void main(String[] args) {
        ElasticApmAttacher.attach();
        SpringApplication.run(MallApplication.class, args);
    }

}
