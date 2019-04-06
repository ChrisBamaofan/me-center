package com.me.mqtestCodes.JdkDelayQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaohaojie
 * @date 2019-04-02 16:45
 */
public class Main {

    public static void main(String[] args) {
        DelayQueue<Message> delayQueue = new DelayQueue<>();
        Message m1 = new Message(1,"this is 1",3000);
        Message m2 = new Message(2,"this is 2",10000);
        delayQueue.offer(m1);
        delayQueue.offer(m2);
        System.out.println(System.currentTimeMillis());
        // 启动消费线程 消费添加到延时队列中的消息，前提是任务到了延期时间
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(new MsgConsumer(delayQueue));
        exec.shutdown();

    }
}

