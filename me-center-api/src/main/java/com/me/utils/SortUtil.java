package com.me.utils;


import com.me.entity.Student;
import com.me.mysql.domain.SeckillSuccess;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhaohaojie
 * @date 2019-01-11 17:02
 */
public class SortUtil {
    // sort
    public static void sort(Comparable[] arr){
        if (arr == null){
            throw new NullPointerException("arr 不能为空！排序失败！");
        }
    }

    //对元素进行比较,假如 v = B,w =A ; 返回 false
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    //是否已经排过序
    public static boolean isSorted(Comparable[] arr){
        for (int i =0;i<arr.length;i++){
            if (less(arr[i],arr[i-1])){//后者 比 前者 小。
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        SeckillSuccess seckillSuccess = new SeckillSuccess();
//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        concurrentHashMap.put("Key",seckillSuccess);
//        concurrentHashMap.put("String","121212");
//        concurrentHashMap.get("String");
//        concurrentHashMap.get("Key");
//        for (int i=0;i<10000;i++){
////            ThreadLocal tl = new ThreadLocal();
//            concurrentHashMap.put("Thread"+i,"数据"+i);
//            String str = (String)concurrentHashMap.getOrDefault("Thread"+i,"Thread"+i+"未获取到数据");
//            System.out.println(str);
//        }
        Student st1 = new Student();
        st1.setName("ben");
        Student st2 = new Student();
        st2.setName("ben");
        HashMap map = new HashMap();
        HashSet set = new HashSet();
        map.put(null,null);
        map.put("key",null);
        set.add(st1);
        set.remove(st1);
        System.out.println(map.get("key"));
        System.out.println(map.get(null));
    }
}

