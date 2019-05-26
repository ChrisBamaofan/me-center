package com.me.aop.cglib;

/**
 * @author zhaohaojie
 * @date 2019-04-19 17:48
 */
public class Test2 {
    {
        Test test6 = new Test(6);
    }
    Test test5 = new Test(5);
    static{
        Test test = new Test(1);
    }
    static Test test2 = new Test(2);
    static{
        Test test3 = new Test(3);
    }
    Test test4 = new Test(4);

    public static void main(String[] args) {
        Test2 t= new Test2();
    }
}

