package com.wuxin.domanservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@MapperScan("com.wuxin.common.domain.mapper")
@SpringBootApplication
//开启基于注解的缓存
@EnableCaching
public class DomanserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DomanserviceApplication.class, args);
    }

}
