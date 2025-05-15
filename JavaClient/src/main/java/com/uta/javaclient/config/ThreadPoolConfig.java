package com.uta.javaclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(
                3,//核心线程数
                5,//最大线程数
                8,//临时线程存活时间
                TimeUnit.SECONDS,//存活时间单位
                new LinkedBlockingQueue<>(4),//任务阻塞队列
                Executors.defaultThreadFactory(),//创建线程池用的工厂
                new ThreadPoolExecutor.CallerRunsPolicy()//回调策略（一共四种策略）
        );
    }
}
