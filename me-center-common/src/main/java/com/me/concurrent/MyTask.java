package com.me.concurrent;

/**
 * @author zhaohaojie
 * @date 2019-02-14 15:05
 */
public class MyTask implements Runnable{

    private TaskData taskData;

    public MyTask(TaskData taskData){
        this.taskData = taskData;
    }

    @Override
    public void run() {
        MyTaskExecutor.instance.execute(taskData);
    }
}

