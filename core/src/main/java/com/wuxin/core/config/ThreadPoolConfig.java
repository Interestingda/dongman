package com.wuxin.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Author:TangHong
 * 创建多线程爬取视频资源
 * data:2022/10/22
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {
    @Bean("task")
    public Executor asyncServiceExecutor() {
        //创建线程池
        return Executors.newFixedThreadPool(20);
    }
}