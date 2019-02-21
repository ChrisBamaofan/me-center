package com.me.concurrent.javaConcurrentAnimated;

import com.me.entity.Student;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaohaojie
 * @date 2019-02-17 10:40
 */
public class laucher {

    public static void main(String[] args) {

        String key = "key";
        HashMap map=new HashMap();
        map.put("key","value");
        HashSet set = new HashSet();
        set.add("value;");
        Hashtable hashtable = new Hashtable();
        hashtable.put("key","value");
        System.out.println(map.get(key));;
        System.out.println(set.remove("value;"));;
        System.out.println(hashtable.get(key));
        ExecutorService service = Executors.newCachedThreadPool();
        ThreadLocal<Student> tl = new ThreadLocal<>();
        tl.get();
        tl.set(null);
    }
}

