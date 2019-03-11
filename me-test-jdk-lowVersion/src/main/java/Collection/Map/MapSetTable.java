package Collection.Map;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhaohaojie
 * @date 2019-02-17 14:11
 */
public class MapSetTable {

    public static void main(String[] args) {
        List<String> strings = new CopyOnWriteArrayList<String>();
        strings.add("1231");
        strings.add("1232");
        strings.add("2223");
        strings.add(null);
        System.out.println(strings.size()+"get0 = "+strings.get(3));

        ReadWriteLock lock = new ReentrantReadWriteLock();
        HashMap map = new HashMap();
        map.put("",123);
        Integer ig = Integer.valueOf(123);
        System.out.println(ig.hashCode());
        System.out.println(hash(ig.hashCode()));
        HashSet set= new HashSet();
        set.add(123);
        set.add(234);
        set.add(456);
        System.out.println(set.size());
        set.remove(123);
LinkedHashMap map1 = new LinkedHashMap();
map1.put("12","12");
        Hashtable hashtable = new Hashtable();
        hashtable.put("",123);
//        map = Collections.synchronizedMap(map);
LinkedHashSet set1 = new LinkedHashSet();
set1.add(12);
        TreeMap treeMap = new TreeMap();
        treeMap.put("bname","ben");
    }

    static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}

