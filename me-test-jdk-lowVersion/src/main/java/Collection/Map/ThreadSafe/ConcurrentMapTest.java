package Collection.Map.ThreadSafe;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhaohaojie
 * @date 2019-02-17 14:10
 */
public class ConcurrentMapTest {

    public static void main(String[] args) {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("",123);
        System.out.println(concurrentHashMap.get(""));
    }
}

