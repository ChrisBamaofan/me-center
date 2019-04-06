package com.me.concurrent;

import jdk.nashorn.internal.codegen.types.Type;
import jdk.nashorn.internal.ir.Optimistic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * @author zhaohaojie
 * @date 2019-03-06 22:04
 */
public class MyLock implements Lock {

    private final Sync sync = new Sync();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    public static class Sync extends AbstractQueuedSynchronizer{

        //是否被其他线程占用
        protected boolean isHeldByOtherThread(){
            return getState()==1;
        }

        //在调用Lock的acquire方法时调用到tryAcquire
        @Override
        protected boolean tryAcquire(int arg) {

            if (compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0){
                throw new IllegalMonitorStateException();
            }
            //释放锁
            setExclusiveOwnerThread(null);
            //状态改为0
            setState(0);
            return true;
        }

        //每个condition包含一个condition队列
        Condition newCondition(){
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked(){
        return sync.isHeldByOtherThread();
    }

    public int getQueuedLength(){
        return sync.getQueueLength();
    }

    public int getWaitQueuedLength(AbstractQueuedSynchronizer.ConditionObject condition){
        return sync.getWaitQueueLength(condition);
    }
}

