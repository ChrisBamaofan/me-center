package com.me.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 通过springboot自带的线程池机制来跑异步任务
 * @author zhaohaojie
 * @date 2019-02-14 11:43
 */
@EnableAsync
@Configuration
@Slf4j
public class ThreadPoolConfig {

    @Autowired
    private PoolParam poolParam;

    @Bean
    public ThreadPoolTaskExecutor executeInPool(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(poolParam.getCorePoolSize());
        taskExecutor.setKeepAliveSeconds(poolParam.getKeepAliveSeconds());
        taskExecutor.setMaxPoolSize(poolParam.getMaxPoolSize());
        taskExecutor.setQueueCapacity(poolParam.getQueueCapacity());
        taskExecutor.setThreadNamePrefix("pool-executor-");
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }
}

