package com.me.concurrent;

/**
 * @author zhaohaojie
 * @date 2019-03-08 0:16
 */
public class VolatileTest {
    public static volatile int i=0;

    public void add(){
        i=i+1;
    }

    static class Thread1 extends Thread{
        public Thread1(String name){
            super(name);
        }
        private Thread t;
        public Thread1(Thread tr){
            this.t = tr;
        }
        public void run(){
            try {
                System.out.println(Thread.currentThread()+"time is 2");
                if (t!=null){
                    t.interrupt();
                    System.out.println("t "+t.getName()+" is interrupted!"+t.getState());
                }
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static Runnable runnable = new Runnable() {
        @Override // 可以省略
        public void run() {
            // 一直 run
            while (true) {
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(runnable);
        t.start();

        System.out.println(t.getState());
        t.interrupt();
        System.out.println(t.getState());
        System.out.println(t.isInterrupted());
    }
}

