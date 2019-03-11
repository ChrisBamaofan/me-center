package com.me.concurrent;

/**
 * @author zhaohaojie
 * @date 2019-03-10 17:15
 */
public class TestClazz extends TestAbsClazz {
    @Override
    public void dosomething() {
        super.say();
    }

    public static void main(String[] args) {
        TestClazz c = new TestClazz();
        c.dosomething();
    }
}

