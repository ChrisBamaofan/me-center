package Collection.Queue;

import com.alibaba.fastjson.JSONObject;
import com.me.mysql.domain.SeckillSuccess;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author zhaohaojie
 * @date 2019-02-17 22:01
 */
public class QueueTestMamin {

    static class comparebleClazz implements Comparable{

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
    public static void main(String[] args) {

        Comparator<SeckillSuccess> seckillSuccessComparator = new Comparator<SeckillSuccess>() {
            @Override
            public int compare(SeckillSuccess o1, SeckillSuccess o2) {
                return o1.getPid().compareTo(o2.getPid());//pid小的优先级高
            }
        };
        // 优先级队列
        Queue successQueue = new PriorityQueue<SeckillSuccess>(10,seckillSuccessComparator);
        for (int i=0;i<6;i++){
            SeckillSuccess seckillSuccess = new SeckillSuccess();
            seckillSuccess.setPid(i);
            successQueue.offer(seckillSuccess);
        }

        System.out.println(JSONObject.toJSONString(successQueue.peek()));

        /**
         * priorityBlockingQueue
         * offer：与priorityQueue的区别为 ReentrantLock的添加，
         * 优先级的选择策略有默认或者自定义comparable接口的compare方法
         * @author : zhaohaojie
         * @date : 2019/2/18 16:40
         */
        Queue queue2 = new PriorityBlockingQueue();
        ((PriorityBlockingQueue) queue2).offer(21);

        /**
         * 基于链表的阻塞队列
         *
         */
        final Queue linkedBlockingQueue = new LinkedBlockingQueue(1);
        linkedBlockingQueue.offer(1);
        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                linkedBlockingQueue.offer(2);
            }
        });

        Executors.newFixedThreadPool(15);
    }
}

