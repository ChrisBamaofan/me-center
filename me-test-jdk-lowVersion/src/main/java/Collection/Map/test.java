package Collection.Map;

import com.me.mysql.domain.SeckillSuccess;

import java.util.TreeMap;

/**
 * @author zhaohaojie
 * @date 2019-03-05 11:32
 */
public class test {
    public static void main(String[] args) {
        System.out.println(1 << 30);
        TreeMap treeMap = new TreeMap();
        treeMap.put("name","jack");
        TreeMap treeMap2 = new TreeMap();
        treeMap.put("name","jack");
        System.out.println(treeMap.get("name"));
        System.out.println(treeMap == treeMap2);
        System.out.println(treeMap.equals(treeMap2));

        SeckillSuccess sc1 = new SeckillSuccess();
        SeckillSuccess sc2=null;
        sc2  = sc1;

        System.out.println(sc2.equals(sc1));
    }
}

