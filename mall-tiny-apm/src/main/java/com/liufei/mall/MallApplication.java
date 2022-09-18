package com.liufei.mall;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MallApplication {

    public static void main(String[] args) {
        ElasticApmAttacher.attach();
        SpringApplication.run(MallApplication.class, args);
    }

}
