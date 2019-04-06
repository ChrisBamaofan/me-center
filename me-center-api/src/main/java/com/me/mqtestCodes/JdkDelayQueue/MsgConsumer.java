package com.me.mqtestCodes.JdkDelayQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @author zhaohaojie
 * @date 2019-04-02 16:40
 */
public class MsgConsumer implements Runnable {
    private DelayQueue<Message> queue;

    public MsgConsumer(DelayQueue<Message> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Message msg =  queue.take();
                System.out.println(System.currentTimeMillis()+" 获取到消息 "+msg.getId()+" : "+msg.getBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

