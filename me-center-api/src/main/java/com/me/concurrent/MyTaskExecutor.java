package com.me.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程池任务执行类
 *
 * @author zhaohaojie
 * @date 2019-02-14 15:14
 */
@Slf4j
public class MyTaskExecutor {
    public final static MyTaskExecutor instance = new MyTaskExecutor();

    public void execute(TaskData taskData){
        //注册的那一整套实现类，在一个静态map中

        //TODO 处理失败，最多5次失败
    }
}

