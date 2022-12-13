package com.wuxin.domanservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Atothor:aa
 * data:2022/10/22
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {
    @Bean("task")
    public Executor asyncServiceExecutor(){
        //


        return  Executors.newFixedThreadPool(20);

    }
}