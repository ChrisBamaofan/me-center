package ProductAndConsume.linklist;

import ProductAndConsume.Lists;

import java.util.LinkedList;

/**
 * @author zhaohaojie
 * @date 2019-03-24 19:43
 */
public class MyStack {
    public LinkedList<String> strings = new LinkedList<String>();

    public synchronized void add() throws InterruptedException {
        if (strings.size()<100){
            for (int i=0;i<100;i++){
                String str = System.currentTimeMillis()+" and i is "+i;
                System.out.println("product add "+str);
                strings.add(str);
                this.notify();
            }
        }else{
            this.wait();
        }
    }

    public synchronized void consume() throws InterruptedException {
        if (strings.size() ==0){
            this.wait();
        }
        for (int i=0;i<strings.size();i++){
            System.out.println("consumer["+i+"] get "+strings.get(i));
        }
        this.notify();
    }
}

