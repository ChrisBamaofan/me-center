package Threadpool;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池
 *
 * @author zhaohaojie
 * @date 2019-02-17 14:40
 */
public class ThreadpoolExectuorTest {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getString(){
        String str  = threadLocal.get();
        if (str==null){
            System.out.println(Thread.currentThread()+" will set value is "+System.currentTimeMillis());
            threadLocal.set(Thread.currentThread()+" set value is "+System.currentTimeMillis());
        }
        str = threadLocal.get();
        return str;
    }
    public static void main(String[] args) {
        Thread[] threads = new Thread[6];
        for (int i=0;i<5;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(ThreadpoolExectuorTest.getString());
                }
            });
        }
        for (int i=0;i<5;i++){
            threads[i].start();
        }
        Semaphore semaphore = new Semaphore(10);
        try {
            semaphore.acquire();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        ReentrantLock reentrantLock = new ReentrantLock();
//        ThreadPoolExecutor tp = new ScheduledThreadPoolExecutor(22);
//        DelayQueue delayQueue = new DelayQueue();
//        ExecutorService es = Executors.newCachedThreadPool();
//        es.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("im in newCachedThreadPool");
//            }
//        });

    }
}

