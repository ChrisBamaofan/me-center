package ProductAndConsume;

/**
 * @author zhaohaojie
 * @date 2019-03-24 19:11
 */
public class Producter {
    String lock;
    public Producter(String lock){
        super();
        this.lock= lock;
    }
    public void product() throws InterruptedException {
        synchronized (lock){
            if (Lists.strings.size()==100){
                lock.wait();
            }
            for (int i=0;i<100;i++){
                String str = System.currentTimeMillis()+" and i is "+i;
                System.out.println("product add "+str);
                Lists.strings.add(str);
            }
            lock.notify();
        }
    }
}

