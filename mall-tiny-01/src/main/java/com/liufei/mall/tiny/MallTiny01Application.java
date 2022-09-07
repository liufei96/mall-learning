package com.liufei.mall.tiny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.liufei.mall.tiny.dao")
public class MallTiny01Application {

    public static void main(String[] args) {
        SpringApplication.run(MallTiny01Application.class, args);
    }

}
