package com.me.concurrent;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.*;

/**
 * @author zhaohaojie
 * @date 2019-02-13 12:19
 */
public class MyPool extends ThreadPoolExecutor implements AbstractPool {
    @Autowired
    private PoolParam poolParam;

    private ThreadPoolExecutor pool;
    private LinkedBlockingQueue queue;

    public MyPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public void init(){
        pool = new ThreadPoolExecutor(poolParam.getCorePoolSize(),poolParam.getMaxPoolSize(),poolParam.getMaxPoolSize(),
                TimeUnit.SECONDS,queue,new CallerRunsPolicy());
        queue = new LinkedBlockingQueue();
    }

    @Override
    public void addNewTaskToQueue(TaskData taskData) {
        pool.execute(new MyTask(taskData));
    }

    @Override
    public Integer getQueueSize() {
        return null;
    }
}

