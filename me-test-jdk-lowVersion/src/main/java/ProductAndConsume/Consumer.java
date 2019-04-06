package ProductAndConsume;

/**
 * @author zhaohaojie
 * @date 2019-03-24 19:14
 */
public class Consumer {
    String lock;
    public Consumer(String lock){
        super();
        this.lock = lock;
    }
    public void consume() throws InterruptedException {
        synchronized (lock){
            if (Lists.strings.size() ==0){
                lock.wait();
            }
            for (int i=0;i<Lists.strings.size();i++){
                System.out.println("consumer["+i+"] get "+Lists.strings.get(i));
            }
            lock.notify();
        }
    }
}

