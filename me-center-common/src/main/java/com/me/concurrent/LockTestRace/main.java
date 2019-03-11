package com.me.concurrent.LockTestRace;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaohaojie
 * @date 2019-03-06 23:38
 */
public class main {
    public static void main(String[] args) {
        SeckillProductRemain remain = new SeckillProductRemain();
        LinkedList threads = new LinkedList<Thread>();
        for (int i=0;i<100;i++){
            Runnable r  = new TaskRunnable(remain);
            Thread t = new Thread(r,"r="+i);
            threads.add(t);
        }
        for (int j=0;j<threads.size();j++){
            Thread t = (Thread)threads.get(j);
            t.start();
        }
    }
}

