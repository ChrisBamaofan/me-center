package com.me.concurrent;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaohaojie
 * @date 2019-02-13 12:19
 */
public class MyPool implements AbstractPool {
    @Autowired
    private PoolParam poolParam;

    private ThreadPoolExecutor pool;
    private LinkedBlockingQueue queue;

    public void init(){
        pool = new ThreadPoolExecutor(poolParam.getCorePoolSize(),poolParam.getMaxPoolSize(),poolParam.getMaxPoolSize(),
                TimeUnit.SECONDS,queue,new ThreadPoolExecutor.CallerRunsPolicy());
        queue = new LinkedBlockingQueue();
    }

    @Override
    public boolean addNewTaskToQueue() {
        return false;
    }

    @Override
    public Integer getQueueSize() {
        return null;
    }
}

