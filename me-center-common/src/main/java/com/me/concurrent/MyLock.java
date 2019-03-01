package com.me.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author zhaohaojie
 * @date 2019-03-01 19:03
 */
public class MyLock extends AbstractQueuedSynchronizer {

    private int state=0;

    protected MyLock() {
        super();
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}

