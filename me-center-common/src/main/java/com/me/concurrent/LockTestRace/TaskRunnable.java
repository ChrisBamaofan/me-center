package com.me.concurrent.LockTestRace;

/**
 * 减库存的请求
 *
 * @author zhaohaojie
 * @date 2019-03-06 23:41
 */
public class TaskRunnable implements Runnable{

    private SeckillProductRemain remain;
    public TaskRunnable(SeckillProductRemain remain){
        this.remain = remain;
    }
    @Override
    public void run() {
        this.remain.decreaseNumber();
    }
}

