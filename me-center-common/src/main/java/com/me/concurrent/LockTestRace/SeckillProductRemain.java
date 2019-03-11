package com.me.concurrent.LockTestRace;

import com.me.concurrent.MyLock;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author zhaohaojie
 * @date 2019-03-06 23:32
 */
@Slf4j
public class SeckillProductRemain {
    private static Integer number =100;
    public MyLock lock =new MyLock();
    public SeckillProductRemain(){
//        lock = ;
    }

    public void decreaseNumber(){
        lock.lock();
        try{
            AbstractQueuedSynchronizer.ConditionObject cd = (AbstractQueuedSynchronizer.ConditionObject) lock.newCondition();
//            log.debug(Thread.currentThread().getName()+"当前排队树"+lock.getQueuedLength());
            log.debug(Thread.currentThread().getName()+"当前排队树"+lock.getWaitQueuedLength(cd));
            log.debug(Thread.currentThread().getName() );
            log.debug(Thread.currentThread().getName()+"修改number之前为"+number);
            number-=1;
            log.debug(Thread.currentThread().getName()+"修改number之后为"+number);
        }catch (RuntimeException e){

        }finally {
            lock.unlock();
        }
    }

    public int getNumber(){
        return  number;
    }
}

