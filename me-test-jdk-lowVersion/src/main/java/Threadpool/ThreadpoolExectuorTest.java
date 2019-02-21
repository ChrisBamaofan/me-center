package Threadpool;

import java.util.concurrent.*;

/**
 * 线程池
 *
 * @author zhaohaojie
 * @date 2019-02-17 14:40
 */
public class ThreadpoolExectuorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor tp = new ScheduledThreadPoolExecutor(22);
        DelayQueue delayQueue = new DelayQueue();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("im in newCachedThreadPool");
            }
        });

    }
}

